package com.db;

import java.sql.SQLException;

public class App {
	public static void main(String[] args) {
		
		var db = Database.instance();
		// cannot use private constructor 
		//Database db2 = new Database();
		
		try {
			db.connect();
		} catch (SQLException e) {
			System.out.println("Cannot connect to database!");
		}
		
		System.out.println("Connected");
		
		UserDao userDao = new UserDaoImpl();
		/*userDao.save(new User("Mars"));
		userDao.save(new User("Mercury"));
		System.out.println("Done!");*/
		
		var users = userDao.getAll();
		users.forEach(System.out::println);
		
		var id = 0;
		var userOpt = userDao.findById(id);
		System.out.println(userOpt);
		// only when not empty!!!
		//System.out.println(userOpt.get());
		if(userOpt.isPresent()) System.out.println(userOpt.get());
		else System.out.println("No user with id: " + id);
		
		userDao.delete(new User(7, null));
		
		try {
			db.close();
		} catch (SQLException e) {
			System.out.println("Cannot close database connection!");
		}
	}
}
