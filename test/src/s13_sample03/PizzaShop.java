package s13_sample03;

public abstract class PizzaShop implements PizzaOrder{
	protected IPizza pizza;
	protected String userSize;
	protected String userTopping;
	protected String userAddress;

	public void setSize(String size) {
		userSize = size;
	}

	public void setTopping(String topping) {
		userTopping = topping;
	}

	public void setAddress(String address) {
		userAddress = address;
	}
	public IPizza delivery() {
		return pizza;
	}
}
