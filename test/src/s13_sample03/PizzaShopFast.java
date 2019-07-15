package s13_sample03;

public class PizzaShopFast extends PizzaShop {


	public int getTime() {
		return 30;
	}

	public int getPrice() {
		return 1000;
	}

	public void makePizza() {
		pizza = new Pizza();
		pizza.makeBase(userSize + "の生地を作りました。");
		pizza.addTopping(userTopping + "をトッピングしました。");
	}


}
