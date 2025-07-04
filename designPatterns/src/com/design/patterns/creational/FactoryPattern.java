package com.design.patterns.creational;

//Factory method where Object creation is based on the condition given 
//Shape Factory method is one which acts as common condition class
class ShapeFactory {
	public Shape getInstance(String input) {
		
		if(input.equalsIgnoreCase("triangle")) return new ShapeTriangle();
		if(input.equalsIgnoreCase("square")) return new ShapeSqure();
		
		return null;
		
	}
}
interface Shape{
	
	void printShape();
	
}

class ShapeTriangle implements Shape{
	public ShapeTriangle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printShape() {
		System.out.println("This is the triangle Instance");
		
	}	
}

class ShapeSqure implements Shape{
	public ShapeSqure() {
	}

	@Override
	public void printShape() {
		System.out.println("This is the square Instance");
		
	}
}

public class FactoryPattern {

	public static void main(String[] args) {
		
		ShapeFactory sf = new ShapeFactory();
		Shape triagle = sf.getInstance("square");
		triagle.printShape();

	}

}
