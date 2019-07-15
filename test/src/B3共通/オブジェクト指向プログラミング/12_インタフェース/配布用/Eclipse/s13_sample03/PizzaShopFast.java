package s13_sample03;

public class PizzaShopFast implements IPizzaOrder {
	IPizza pizza;
	String userSize;
	String userTopping;
	String userAddress;

	public void setSize(String size) {
		userSize = size;
	}

	public void setTopping(String topping) {
		userTopping = topping;
	}

	public void setAddress(String address) {
		userAddress = address;
	}

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

	public IPizza delivery() {
		return pizza;
	}
}
