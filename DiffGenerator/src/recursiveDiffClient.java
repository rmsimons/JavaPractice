
public class recursiveDiffClient {

	public static void main(String[] args) {
		String str1 = "abcdfghjqz";
		String str2 = "abcdefgijkrxyz";
		recursiveDiff diff = new recursiveDiff(str1, str2);
		System.out.println(diff);
	}

}
