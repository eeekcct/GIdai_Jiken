package s13_sample03;

public class Pizza implements IPizza{

	private String properties="";

	public void makeBase(String size) {
		properties += "\n"+size;
	}
	
	public void addTopping(String topping) {
		properties += "\n"+topping;
	}
	
	public String getProperties() {
		return properties;
	}
}
