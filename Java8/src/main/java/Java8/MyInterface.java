package Java8;

@FunctionalInterface
public interface MyInterface {

	void print();

	
	//java8
	default void body() {
		System.out.println("This is my interface function boy");
	}
}
