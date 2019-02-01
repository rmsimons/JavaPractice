
//Robert Simons
//CS143 Final
//Question 2

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BackpackManager {
	private double totalMoney;
	private List<Person> friendsList;
	private TreeMap<Double, Food> dFactorMap;

	// Implements dFactor algorithm to determine approximate value of food
	// Maps food in order of most important to least
	public BackpackManager(double totalMoney, List<Person> friends, List<Food> availableMeals) {
		this.totalMoney = totalMoney;
		friendsList = friends;
		dFactorMap = new TreeMap<>(Collections.reverseOrder());
		for (int i = 0; i < availableMeals.size(); i++) {
			Food f = availableMeals.get(i);
			double price = f.price;
			double weight = f.weight;
			// approximate algorithm to how important each food is
			// effectively determines the economic "density" value
			// the higher the dFactor, the more important it is
			double dFactor = (price / weight) / weight;
			dFactorMap.put(dFactor, f);
		}
	}

	public List<Person> makeAssignments() {

		for (int i = 0; i < friendsList.size(); i++) {
			Person p = friendsList.get(i);
			double maxWeight = p.MAX_WEIGHT;
			double currentWeight = 0.0;

			// Places the food into the Person backpack
			// going from most important to least important
			Iterator<Map.Entry<Double, Food>> itr = dFactorMap.entrySet().iterator();
			// pre:there is still food left, the person can carry more food
			while (itr.hasNext() && currentWeight < maxWeight) {
				Map.Entry<Double, Food> entry = itr.next();
				Food f = entry.getValue();
				double foodWeight = f.weight;
				// pre:there is enough space and money to buy food
				// post:food added to person and removed from available map,
				// money reduced
				if (foodWeight <= maxWeight - currentWeight && totalMoney - f.price >= 0) {
					p.foodItems.add(f);
					totalMoney -= f.price;
					currentWeight += foodWeight;
					itr.remove();
				}
			}

		}
		// Custom Comparator for the names of the Person Class
		// Puts names in alphabetical order
		if (!friendsList.isEmpty()) {
			Collections.sort(friendsList, new Comparator<Person>() {
				public int compare(Person object1, Person object2) {
					if (object1.name == object2.name)
						return 0;
					return object1.name.compareTo(object2.name);
				}
			});
		}
		return friendsList;
	}

}
