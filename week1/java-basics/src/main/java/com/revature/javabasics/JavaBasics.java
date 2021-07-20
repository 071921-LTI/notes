package com.revature.javabasics;

/*
 * Multi-line comment
 * Naming conventions: (not reserved keywords)
 * 	- PascalCase for ClassName/InterfaceName
 * 	- camelCase for methodName/variableName ($, _, etc)
 *  - reverse url for package declaration (all lower case)
 *  
 * [access-mod] [non-access-mod] class ClassName {}
 */

public class JavaBasics {
	
	public static String name = "JavaBasics";
	
	public int number;
	
	public JavaBasics() {
		
	}
	
	public JavaBasics(int integer, boolean bool) {
		
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World from Eclipse!");
		
		// primitive datatypes
		byte byteVar = 0; // 1 byte
		short shortVar = -1; // 2 bytes
		int intVar; // 4 bytes, declaring
		long longVar; //8 bytes
		
		intVar = 78; // initializing
		
		float floatVar = 1.1f; // 4 bytes
		double doubleVar = 2.2; // 8 bytes
		
		char charVar = 'A'; // 2 bytes
		
		boolean boolVar; // JVM dependent
		
//		boolVar = doubleVar; this doesn't work because boolean and double are not compatible
		
		intVar = byteVar; // within the same "type" going to bigger allocation
		doubleVar = intVar;

//		intVar = floatVar; this doesn't work
//		floatVar = doubleVar; This doesn't work because cannot go from bigger to smaller
		
		charVar = 0;
		
		// reference/object types
		/*
		 *  wrapper classes - 1 for each primitive type
		 */
		
		Byte byteWrap = byteVar;
//		byteWrap = new Byte(byteVar);
		Integer intWrap = intVar;
		Character charWrap = charVar;
		
		JavaBasics javaBasics = new JavaBasics();
		JavaBasics javaBasics1 = new JavaBasics();
		JavaBasics javaBasics2 = new JavaBasics();
		JavaBasics javaBasics3 = new JavaBasics(5, false);
		
		String name = "Kevin"; // Creates a string in String pool
		String name2 = new String("Kevin"); // Creates a string not in string pool
		String name3 = "Kevin";
		
		/*
		 *  Control flow statements:
		 *  	- if/else, if
		 *  	- switch
		 *  	- while
		 *  	- for
		 *  	- do/while
		 */
		
		int x = 2;
		int y = 3;
		int z = 5;
		
		/*
		 * && or || exhibit shortcircuiting behavior: won't evaluate the second expression if enough is provided from the first
		 */
		if(x == y && y >= 5) {
			System.out.println("x == y & y >= 5");
		} else if(z > x || y < x) {
			System.out.println("z > x | y < x");
		}else{
			System.out.println("!x == y & y >= 5");
		}
		
		// case 3 executes due to fallthrough behavior because a break statement is missing from case 2
		switch(x) {
		case 1:
			System.out.println("x is 1");
			break;
		case 2:
			System.out.println("x is 2");
		case 3:
			System.out.println("x is 3");
			break;
		case 4:
			System.out.println("x is 4");
			break;
		default:
			System.out.println("x is something else");
			break;
		}
		
		while(x < 10) {
			System.out.println(x);
			x++;
		}
		
		do {
			System.out.println(x);
			x++;
		} while (x < 10);
		
		for(int i = 0; i<= z; i++) {
			System.out.println(z);
		}
		
		int[] intArr = new int[5];
		int []intArr1 = new int[5];
		int intArr2[] = new int[5];
		int[] intArr3 = {0, 1, 2, 3, 4};
		
		System.out.println(intArr[0]);
		
		intArr[0] = 26;
		
		javaBasics1.printArray(intArr);
		
		double average = JavaBasics.average(intArr3);
		System.out.println(average);
		
		System.out.println(JavaBasics.name);
		
		System.out.println(javaBasics1.number);
	}
	
	/*
	 * [access-mod] [non-access-mod] [returnType/void] methodName(parameters if any){ 
	 * 	implementation
	 * }
	 */
	public void printArray(int[] arr) {
		for(int size =0; size <arr.length; size++) {
			System.out.println(arr[size]);
		}
	}
	
	public static double average(int[] arr) {
		double result = 0;
		
		/*
		 * enhanced for loop/for each loop
		 * returns the element itself
		 */
		for(int i : arr) {
			result += i;
		}
		
		return result/arr.length;
	}
}

class Basics{
	// Best practices is to have 1 class per file if possible
}