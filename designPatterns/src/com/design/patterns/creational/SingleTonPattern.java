package com.design.patterns.creational;
/*
 *PAttern that avoid creation of multiple instance of objects an return same instance every time it is called
 * 
 */

//Eager-way
//Where the obj is initialized with static method
class Example {
	private static Example ex = new Example();

	private Example() {
	}

	public static Example getInstance() {
		return ex;
	}
}

//Lazy way 
//where the initialization will be done on the first call of getInstance()
//Here issue with multiThreaded env
class Example2 {
	private static Example2 ex = null;

	private Example2() {
	}

	public static Example2 getInstance() {
		if (ex == null)
			ex = new Example2();
		return ex;
	}
}

//where the initialization will be done on the first call of getInstance()
//Here synchronized prevent the multithred env but multiple call will make the high consumption of time
class Example3 {
	private static Example3 ex = null;

	private Example3() {
	}

	synchronized public static Example3 getInstance() {
		if (ex == null)
			ex = new Example3();
		return ex;
	}
}

//where the initialization will be done on the first call of getInstance()
//Here Optimemzed way of instance creation where the syncronized 
//after null check then the synchronize again null check which avoid the multi threaded applicaTION
class Example4 {
	private static Example4 ex = null;

	private Example4() {
	}

	synchronized public static Example4 getInstance() {
		if (ex == null) { //t1 and t2 null check 
			synchronized (Example4.class) { // synchonize allows only one thread
				if (ex == null) 
					ex = new Example4(); // t1 initialize 
				//t2 will check for null and return as already initalized
			}
		}

		return ex;
	}
}

public class SingleTonPattern {

}
