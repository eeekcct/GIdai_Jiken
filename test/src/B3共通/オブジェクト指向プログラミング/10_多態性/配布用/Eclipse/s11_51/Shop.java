package s11_51;

public class Shop {
	private Employee employee;

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void open() {
		employee.sayHello();
		employee.order();
		employee.cook();
		employee.payment();
		employee.sayGoodbuy();
	}
}
