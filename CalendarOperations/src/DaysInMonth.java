
public class DaysInMonth {

	public static void main(String[] args) {

		answerDays(4, 1991);
		answerDays(7, 2017);
		answerDays(8, 2018);
		answerDays(9, 2019);
		answerDays(10, 2020);
		answerDays(1, 2009);
		answerDays(5, 2010);
		answerDays(2, 2010);
		answerDays(2, 2012);
		answerDays(2, 2000);
		answerDays(2, 2100);
		answerDays(2, 1600);
		answerDays(2, 1700);

	}

	public static void answerDays(int month, int year) {
		if (month < 1 || month > 12 || year < 0) {
			throw new IllegalArgumentException("-99");
		}
		String numToMonth = "";
		{

			if (month == 1)
				numToMonth = "Jan";
			else if (month == 2)
				numToMonth = "Feb";
			else if (month == 3)
				numToMonth = "Mar";
			else if (month == 4)
				numToMonth = "Apr";
			else if (month == 5)
				numToMonth = "May";
			else if (month == 6)
				numToMonth = "Jun";
			else if (month == 7)
				numToMonth = "Jul";
			else if (month == 8)
				numToMonth = "Aug";
			else if (month == 9)
				numToMonth = "Sep";
			else if (month == 10)
				numToMonth = "Oct";
			else if (month == 11)
				numToMonth = "Nov";
			else if (month == 12)
				numToMonth = "Dec";

		}
		if (month == 2) {
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				System.out.println("Number of days in Feb, " + year + " = 29");

			} else {
				System.out.println("Number of days in Feb, " + year + " = 28");

			}

		} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println("Number of days in " + numToMonth + ", " + year + " = 31");

		} else {
			System.out.println("Number of days in " + numToMonth + ", " + year + " = 30");

		}

	}

}
