
public class DiffGeneratorClient {

	public static void main(String[] args) {
		
		String s1 = "Gee, the flowers sure are pretty today";
		String s2 = "Boy, the flowers sure are ugly today";
		DiffGenerator test1 = new DiffGenerator(s1, s2);
		System.out.println(test1.diff(s1,s2));
		
		System.out.println();
		
		String s3 = "Great jaerb!";
		String s4 = "Great jorb there, HamStray!";
		DiffGenerator test2 = new DiffGenerator(s3, s4);
		System.out.println(test2.diff(s3,s4));
	}

}
