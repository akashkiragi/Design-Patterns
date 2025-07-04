package com.design.patterns.creational;

public class AbstractFactory {

	public static void main(String[] args) {
		CarProducer carProducer = new CarProducer();
		int price = carProducer.getCarType("Economy").getCar("model1").getPrice();
		System.out.println("The given car price is :: " + price);
	}

}

//Acess the Abstarct Factory
class CarProducer {

	CarFactory carFactory;

	public CarFactory getCarType(String str) {

		switch (str) {
		case "Luxury": {
			carFactory = new LuxuryCar();
			break;
		}
		case "Economy": {
			carFactory = new EconomyCar();
			break;
		}
		default:
			carFactory = null;
		}

		return carFactory;

	}
}

//Abstract Factory
interface CarFactory {

	Car getCar(String string);

}

class EconomyCar implements CarFactory {

	Car car;

	@Override
	public Car getCar(String string) {
		switch (string) {
		case "model1": {
			car = new EcoCar2();
			break;
		}
		case "model2": {
			car = new EcoCar2();
			break;
		}
		default:
			car = null;
		}
		return car;

	}

}

class LuxuryCar implements CarFactory {

	Car car;

	@Override
	public Car getCar(String string) {
		switch (string) {
		case "model1": {
			car = new LuxCar1();
			break;
		}
		case "model2": {
			car = new LuxCar2();
			break;
		}
		default:
			car = null;
		}
		return car;

	}

}

//factory
interface Car {

	int getPrice();

}

class LuxCar1 implements Car {

	@Override
	public int getPrice() {
		return 50000;
	}

}

class LuxCar2 implements Car {
	@Override
	public int getPrice() {
		return 200000;
	}
}

class EcoCar1 implements Car {
	@Override
	public int getPrice() {
		return 25000;
	}
}

class EcoCar2 implements Car {
	@Override
	public int getPrice() {
		return 15000;
	}
}