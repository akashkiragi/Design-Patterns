package com.design.patterns.creational;

/* any common methods for business logic without exposing most of things can be unimplemented by ProtoType method
 * 
 * Here cloneMethod() making the clone of object of particular class, 
 * which is mandatory to define in every class it implements
 * 
 * */
interface ProtoType {

	public ProtoType cloneMethod();

	public int area();
}

class Triangle implements ProtoType {

	private int height;
	private int base;
	private int length;

	public Triangle() {

	}

	public Triangle(int height, int base, int length) {
		super();
		this.height = height;
		this.base = base;
		this.length = length;
	}

	@Override
	public ProtoType cloneMethod() {
		return new Triangle(height, base, length);
	}

	@Override
	public int area() {

		return height * base * length;
	}
}

class Square implements ProtoType {

	private int length;
	private int width;

	public Square() {
	}

	public Square(int length, int width) {
		super();
		this.length = length;
		this.width = width;
	}

	@Override
	public ProtoType cloneMethod() {
		return new Square(length, width);
	}

	@Override
	public int area() {
		return length * width;
	}
}

public class PrototypePattern {
	public static void main(String[] args) {
		ProtoType squareObj = new Square(10, 20);
		ProtoType copySquareObj = (Square) squareObj.cloneMethod();

		System.out.println(copySquareObj.area());
	}

}
