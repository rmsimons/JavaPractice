
public class SummingMystery {

	public static void main(String[] args) {
		int iSum;
		double dSum; //we'll use this later
		
		iSum = 0;
		for (int i=0; i<1000; i++) {
			iSum = iSum + 1;
			
		}
		
		System.out.println("The integer sum is " + iSum); 
		
		if (iSum ==1000) {
			System.out.println("The answer is correct!");
					
		}
		else {
			System.out.println("The answer is WRONG!"); 
			
		}
		
		dSum = 0.0;
		for (int i=0; i<100000; i++) {
			dSum = dSum + 0.01;
			
		}
		System.out.println("The decimal sum is " + dSum);;
		
		if (dSum ==1000.0) {
			System.out.println("The answer is correct!");;
			
		}
		else { 
			System.out.println("The answer is WRONG!");
			
		}
	}

}
