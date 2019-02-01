
//Robert Simons
//This class manages the source code for a website. 
//It takes a queue of HTML tags, searches for errors,
//and revises the code.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class HTMLManager {
	private Queue<HTMLTag> inputTags;

	// Takes a queue of HTML tags and stores them as a field
	public HTMLManager(Queue<HTMLTag> page) {
		if (page == null) {
			throw new IllegalArgumentException("No HTML tags are on the page");
		}
		this.inputTags = new LinkedList<>();
		int size = page.size();
		for (int i = 0; i < size; i++) {
			HTMLTag temp = page.remove();
			this.inputTags.add(temp);
			page.add(temp);
		}
	}

	// Returns a list of the HTML tags being managed
	public List<HTMLTag> getTags() {
		ArrayList<HTMLTag> list = new ArrayList<>();
		int size = inputTags.size();
		for (int i = 0; i < size; i++) {
			HTMLTag temp = inputTags.remove();
			list.add(temp);
			inputTags.add(temp);

		}
		return list;

	}

	// Removes every instance of the specified tag from the list
	public void removeAll(HTMLTag tag) {
		checkLegalTag(tag);
		int size = inputTags.size();
		for (int i = 0; i < size; i++) {
			HTMLTag temp = inputTags.remove();
			if (temp != tag) {
				inputTags.add(temp);
			}
		}
	}

	// appends the specified tag to the end of the list
	public void add(HTMLTag tag) {
		checkLegalTag(tag);
		inputTags.add(tag);
	}

	// checks if the input tag is null
	private void checkLegalTag(HTMLTag tag) {
		if (tag == null) {
			throw new IllegalArgumentException("Not an HTML tag");
		}
	}

	// prints the stored queue as a string
	public String toString() {
		List<HTMLTag> list = new ArrayList<>(this.inputTags);
		StringBuilder out = new StringBuilder();
		for (Object obj : list) {
			out.append(obj.toString());
			out.append("\t");
		}
		return out.toString();

	}

	// Corrects the input queue in stages:
	// 1: determines if the tag is closing, opening, or self-closing
	// 2: if opening --> stores in corrected queue and in stack
	// if self-closing --> stores in corrected queue
	// if closing -->compares against top of stack
	// -->if matches opening, stores in corrected queue
	// -->if not matching opening, stores correct match in queue
	// -->and discards stack value
	// 3: if closing and stack is empty, discards tag
	public void fixHTML() {
		Queue<HTMLTag> correctTags = new LinkedList<HTMLTag>();
		Stack<HTMLTag> debugStack = new Stack<HTMLTag>();

		while (!inputTags.isEmpty()) {

			HTMLTag peek = inputTags.peek();
			if (peek.isSelfClosing()) {
				correctTags.add(inputTags.remove());
			} else if (peek.isOpening()) {
				HTMLTag temp = inputTags.remove();
				correctTags.add(temp);
				debugStack.push(temp);
			} else {
				if (debugStack.isEmpty()) {
					inputTags.remove();
				} else {
					HTMLTag stackPeek = debugStack.peek();
					if (stackPeek.matches(peek)) {
						debugStack.pop();
						correctTags.add(inputTags.remove());
					} else {

						if (!stackPeek.matches(peek)) {
							correctTags.add(stackPeek.getMatching());
							debugStack.pop();

						}

					}
				}

			}

		}

		while (!debugStack.isEmpty()) {
			HTMLTag temp = debugStack.pop();
			correctTags.add(temp.getMatching());
		}
		inputTags = correctTags;

	}
}
