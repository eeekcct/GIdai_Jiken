package s11_43;
import s11_41.Animal;

public class Sample11_43 {

	public static void main(String[] args) {
		Animal mypet;
		String str;

		mypet=new Animal();
		str=mypet.cry();
		System.out.println(str);

		mypet=new Dog();
		str=mypet.cry();
		System.out.println(str);

		mypet=new Cat();
		str=mypet.cry();
		System.out.println(str);
	}
}
