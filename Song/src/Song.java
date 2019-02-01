
public class Song {

	public static void main(String[] args) {

		verse1();
		verse2();
		verse3();
		verse4();
		verse5();
		verse6();
		verse7();

	}

	public static void verse1() {

		System.out.println("There was an old woman who swallowed a fly.");
		endverse();

	}

	public static void verse2() {

		System.out.println("There was an old woman who swallowed a spider,");
		System.out.println("That wriggled and iggled and jiggled inside her.");
		midverse2();
		endverse();

	}

	public static void verse3() {

		System.out.println("There was an old woman who swallowed a bird,");
		System.out.println("How absurd to swallow a bird.");
		midverse3();
		midverse2();
		endverse();

	}

	public static void verse4() {

		System.out.println("There was an old woman who swallowed a cat,");
		System.out.println("Imagine that to swallow a cat.");
		midverse4();
		midverse3();
		midverse2();
		endverse();

	}

	public static void verse5() {

		System.out.println("There was an old woman who swallowed a dog,");
		System.out.println("What a hog to swallow a dog.");
		midverse5();
		midverse4();
		midverse3();
		midverse2();
		endverse();

	}

	public static void verse6() {

		System.out.println("There was an old woman who swallowed a platypus,");
		System.out.println("Which had an abnormal amount of adipose.");
		midverse6();
		midverse5();
		midverse4();
		midverse3();
		midverse2();
		endverse();

	}

	public static void verse7() {

		System.out.println("There was an old woman who swallowed a horse,");
		System.out.println("She died of course.");

	}

	public static void midverse2() {

		System.out.println("She swallowed the spider to catch the fly,");

	}

	public static void midverse3() {

		System.out.println("She swallowed the bird to catch the spider,");

	}

	public static void midverse4() {

		System.out.println("She swallowed the cat to catch the bird,");

	}

	public static void midverse5() {

		System.out.println("She swallowed the dog to catch the cat,");

	}

	public static void midverse6() {

		System.out.println("She swallowed the platypus to catch the dog,");

	}

	public static void endverse() {

		System.out.println("I don't know why she swallowed that fly,");
		System.out.println("Perhaps she'll die.");
		System.out.println();

	}

}
