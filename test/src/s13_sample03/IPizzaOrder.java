package s13_sample03;

interface IPizzaOrder {
	public void setSize(String  size);
	public void setTopping(String topping);
	public void setAddress(String address);
	public int getPrice();
	public int getTime();
	public void makePizza();
	public IPizza delivery();
}
