import java.util.*;
import java.util.function.Supplier;


class Lazy<T> {
	T value = null;
	Supplier<T> supplier;

	public Lazy(Supplier<T> supplier) {
		this.supplier = supplier;
	}

	public T get() {
		if(value == null) {
			value = supplier.get();
			supplier = null;
		}

		return value;
	}

}

class Main {

	public static int compute(int x) {
		System.out.println("Computing intensive operations");
		return x*2;
	}
	public static void main(String args[]) {
		computeDumb();
		computeSmart();
	}

	private static void computeDumb() {

		System.out.println("---Using a dumb method of computing :/---");

		int x = 1;

		//The temp value may have been unnecessarily computed
		//If this was an intensive computation, we would have wasted alot of resources
		var temp = compute(x);	

		//If call does not pass the first predicate, we would have wasted temp computation
		if(x >= 2 && temp <= 9) {
			System.out.println(String.format("Computed value is: %d", temp));
		}  else {

			System.out.println("Did not use computed value");
		}
	}

	private static void computeSmart() {

		System.out.println("---Using a smart method of deferred computing!---");

		int x = 3;

		//Provide the lazy value a supplier which results in a level of indirection
		var temp = new Lazy<Integer>(() -> compute(x));

		//temp only does a call once to compute and we never compute again
		//in the second call to get the value
		if(x >= 2 && temp.get() <= 9) {
			System.out.println(String.format("Computed value is: %d", temp.get()));
		}  else {
			System.out.println("Did not use computed value");
		}
	}
}