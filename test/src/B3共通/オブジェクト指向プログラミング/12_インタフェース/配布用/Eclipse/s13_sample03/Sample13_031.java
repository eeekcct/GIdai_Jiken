package s13_sample03;

public class Sample13_031 {

	public static void main(String[] args) {
		IPizzaOrder shop;
		IPizza pizza;

		shop = new PizzaShopFast();

		shop.setSize("ラージピザ");
		shop.setTopping("マッシュルーム");
		shop.setAddress("長岡市");

		int time = shop.getTime();
		System.out.println(time + "分でお届けします");

		int price = shop.getPrice();
		System.out.println(price + "円");

		shop.makePizza();
		pizza = shop.delivery();

		System.out.println("\n----------「商品の説明」----------");
		System.out.println(pizza.getProperties());
		System.out.println("\n-------------------------------");
	}

}
