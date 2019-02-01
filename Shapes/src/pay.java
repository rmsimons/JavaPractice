
public class pay {

	public static void main(String[] args) {
		System.out.print("Wage = " + pay(5.50, 6));

		
		
	}
	

	public static double pay(double salary, int hours) {
		double totalPay;
		if (hours > 8) {
			totalPay = (salary * 8) + (salary * 3 / 2 * (hours - 8));
		} else {
			totalPay = salary * hours;
		}
		return totalPay;

	}

}
	
	


