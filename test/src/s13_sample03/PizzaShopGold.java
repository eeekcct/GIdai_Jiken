package s13_sample03;

public class PizzaShopGold extends PizzaShop {
	public int getPrice() {
		return 5000;
	}
	public void makePizza() {
		pizza=new Pizza();
		pizza.makeBase(userSize+"天然素材生地を作りました。");
		pizza.addTopping("超高級"+userTopping+"をトッピングしました。");
	}
	public IPizza delivery() {
		return pizza;
	}

}
