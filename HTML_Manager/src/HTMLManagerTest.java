// CSE 143
// This testing program stub creates a queue of HTML tags 
// in a valid sequence.
// You may use this as a starting point for testing
// your removeAll method.
import java.util.*;

public class HTMLManagerTest {
	public static void main(String[] args) {
		// <div><div><b><i>Hi</i></b><br/></div></div>
		Queue<HTMLTag> tags = new LinkedList<HTMLTag>();
		tags.add(new HTMLTag("div", HTMLTagType.OPENING));		// <div>
		tags.add(new HTMLTag("div", HTMLTagType.OPENING));		// <div>
		tags.add(new HTMLTag("b", HTMLTagType.OPENING));      	// <b>
		tags.add(new HTMLTag("i", HTMLTagType.OPENING));		// <i>
		tags.add(new HTMLTag("i", HTMLTagType.CLOSING));		// </i>
		tags.add(new HTMLTag("b", HTMLTagType.CLOSING));     	// </b>
		tags.add(new HTMLTag("br", HTMLTagType.SELF_CLOSING));  // <br/>
		tags.add(new HTMLTag("div", HTMLTagType.CLOSING));		// </div>
		tags.add(new HTMLTag("div", HTMLTagType.CLOSING));		// </div>
		
		HTMLManager manager = new HTMLManager(tags);

		//Test 1, removes all <b>
		manager.removeAll(new HTMLTag("b", HTMLTagType.OPENING));
		System.out.println(manager.toString());
		
		//Test 2, removes all </i>
		manager.removeAll(new HTMLTag("i", HTMLTagType.CLOSING));
		System.out.println(manager.toString());
		
		//Test 3, removes all <br/>
		manager.removeAll(new HTMLTag("br", HTMLTagType.SELF_CLOSING));
		System.out.println(manager.toString());
	}
}