//Robert Simons
//Alex, I added: field : name; because in the instructions you asked
//for List<Person> to be sorted by name but it didn't have one.
//I apologize if I misinterpreted what you were saying.
//I am submitting this one with BackpackManager so you can see
//what I added and why.
import java.util.ArrayList;
import java.util.List;


public class Person {
	public final double MAX_WEIGHT;
	public final List<Food> foodItems;
	public final String name;

	public Person(double maxWeight, String name) {
		MAX_WEIGHT = maxWeight;
		this.foodItems = new ArrayList<>();
		this.name = name;
	}
}
