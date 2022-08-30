package com.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserDaoImplTest {
	
	private Connection conn;
	private List<User> users;
	
	private static int NUM_TEST_USERS =1000;
	
	private List<User> loadUsers() throws IOException {
		return Files
				.lines(Paths.get("../greatexpectations.txt"))//lines
				.map(line -> line.split("[^A-Za-z]"))//arrays of words
				.map(Arrays::asList)//Lists of words
				.flatMap(list -> list.stream())//words and empty entries
				.filter(word -> word.length() > 3 && word.length() < 20)
				.map(word -> new User(word))
				.limit(NUM_TEST_USERS)
				.collect(Collectors.toList());
	}
	
	@Before
	public void setUp() throws SQLException, IOException {
		
		users = loadUsers();
		
		//System.out.println(users);
		//System.out.println(users.size());
		
		var props = Profile.getProperties("db"); 
		
		var db = Database.instance();
		
		db.connect(props);
		
		conn = db.getConnection();
		
		// changes will be actual in a session, but won't be saved 
		conn.setAutoCommit(false);
	}
	
	@After
	public void tearDown() throws SQLException {
		System.out.println("After");
		Database.instance().close();
	}
	
	private int getMaxId() throws SQLException {
		var stmt = conn.createStatement();
		
		var rs = stmt.executeQuery("select max(id) as id from user");
		rs.next();
		var id = rs.getInt("id");
		
		stmt.close();
		return id;
	}
	
	@Test
	public void testSaveMultiple() throws SQLException {
		UserDao userDao = new UserDaoImpl();
		
		for(var u: users) {
			userDao.save(u);
		}
		
		var maxId = getMaxId();
		
		System.out.println(maxId);
	}
	
	@Test
	public void testSave() throws SQLException {
		User user = new User("Jupiter");
		UserDao userDao = new UserDaoImpl();
		userDao.save(user);
		
		var stmt = conn.createStatement();
		var rs = stmt.executeQuery("select id, name from user order by id desc");
		var result = rs.next();
		assertTrue("cannot retrieve inserted user", result);
		
		var name = rs.getString("name");
		assertEquals("user name doesn't match retrieved", user.getName(), name);
		
		stmt.close();
	}
}
