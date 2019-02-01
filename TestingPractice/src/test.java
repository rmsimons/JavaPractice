import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		String s = "HELLO! world!@#.";
		String ss = s.toLowerCase().replaceAll("[^a-z]+", "");
		char[] ch = ss.toCharArray();
		Arrays.sort(ch);
		System.out.println(ch);
		int size = ch.length;
		System.out.println(size);
		
		int[] arr = new int[26];
		for (int i = 0; i < ch.length; i++) {
			arr[ch[i] - 'a'] += 1;
		}
		System.out.println(Arrays.toString(arr));
		
		char ch2 = 'l';
		if (ch2 < 65 || (ch2 > 90 && ch2 < 97) || ch2 > 122) {
			throw new IllegalArgumentException ("Not a valid character");
			
		}
		ch2 = Character.toLowerCase(ch2);
		System.out.println(ch2);
		int charAmount = 0;
		charAmount = arr[ch2 - 'a'];
		System.out.println(charAmount);
		
		System.out.println(Arrays.toString(ch).replace(", ", ""));
	}

}
