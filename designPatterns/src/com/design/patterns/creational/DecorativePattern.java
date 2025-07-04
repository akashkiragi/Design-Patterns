package com.design.patterns.creational;

public class DecorativePattern {
	
	public static void main(String[] args) {
		int price = new CheeseTopping( new MashroomTopping( new FarmHouse())).cost();
		System.out.println(price);
	}
	

}

abstract class BasePizza {

	abstract int cost();
}

abstract class Topping extends BasePizza {

}

class MargeritaPizza extends BasePizza {
	int cost() {
		return 150;
	}
}

class FarmHouse extends BasePizza {
	int cost() {
		return 250;
	}
}

class CheeseTopping extends Topping {

	BasePizza bp;

	public CheeseTopping(BasePizza bp) {
		this.bp = bp;
	}

	@Override
	int cost() {
		return this.bp.cost()+25;
	}
}
class MashroomTopping extends Topping {

	BasePizza bp;

	public MashroomTopping(BasePizza bp) {
		this.bp = bp;
	}

	@Override
	int cost() {
		return this.bp.cost()+15;
	}
}
