
public class TrainRoman {

	public static void main(String[] args) {
		
		System.out.println(toRoman(2));
		System.out.println(toRoman(8));
		System.out.println(toRoman(18));
		System.out.println(toRoman(22));
		System.out.println(toRoman(52));
		System.out.println(toRoman(1000));
		System.out.println(toRoman(1666));
		System.out.println(toRoman(2008));
		System.out.println(toRoman(19));
		System.out.println(toRoman(1990));

	}
	
	private static String[] rome = {"I", "V", "X", "L", "C", "D", "M"};
	private static int[] arab = {1, 5, 10, 50, 100, 500, 1000}; 
	
	public static String toRoman(int n) {
		System.out.println(n);
	    var re = new StringBuilder();
	    /*if(n == 1) re.append("I");
	    if(n == 2) re.append("II");
	    if(n == 3) re.append("III");*/
	    
	    int index = 2;
	    int remainder = 0;
	    for(int i = 6; i >= 0; i--) {
		    remainder = n / arab[i];
		    if((i > 0) && (n / arab[i - 1] == 9)) System.out.println(n + " !");
		    n -= (remainder * arab[i]);
		    switch (remainder) {
		    	case 1:
		    		re.append(rome[i]);
		    		break;
		    		
		    	case 2:
		    		re.append(String.format(rome[i] + rome[i]));
		    		break;
		    }
		    if(remainder == 3) re.append(String.format(rome[i] + rome[i] + rome[i]));
		    if(remainder == 4) re.append(String.format(rome[i] + rome[i + 1]));
	    }
	    
	    return re.toString();
	  }

}

