//Robert Simons
//CS 143 Final
//Question 1 - StringMinHeap

import java.util.Arrays;
import java.util.NoSuchElementException;

//Implements a priority queue of strings using a
//min-heap represented as an array.
public class StringMinHeap {
	private String[] elementData;
	private int size;
	private String lastAdded;
	private int lastAddedLocation;

	// Constructs an empty queue.
	public StringMinHeap() {
		elementData = new String[10];
		size = 0;
	}

	// Adds the given element to this queue.
	public void add(String value) {
		lastAdded = value;
		
		// resize if necessary
		if (size + 1 >= elementData.length) {
			elementData = Arrays.copyOf(elementData, elementData.length * 2);
		}
		
		// insert as new rightmost leaf
		elementData[size + 1] = value;
		
		// "bubble up" toward root as necessary to fix ordering
		int index = size + 1;
		boolean found = false;
		while (!found && hasParent(index)) {
			int parent = parent(index);
			if (elementData[index].compareTo(elementData[parent]) < 0) {
				swap(elementData, index, parent(index));
				index = parent(index);
			} else {
				found = true;
			}
		}
		size++;
	}

	// Removes and returns the minimum value in the queue.
    // If the queue is empty, throws a NoSuchElementException.
	public String removeMin() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		String result = bubbleDown(1);
        return result;    
	}

	// Removes and returns the last added value in the queue.
    // If the queue is empty, throws a NoSuchElementException.
	public String removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		contains(lastAdded);
		String result = bubbleDown(lastAddedLocation);
        return result; 
	}

	// Removes and returns the specified value in the queue.
    // If the queue is empty, throws a NoSuchElementException.
	public String remove(String object) {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		contains(object);
		String result = bubbleDown(lastAddedLocation);
        return result; 
	}

	//Returns true is the specified value is in the queue
	//Updates the location of the specified value
	public boolean contains(String value) {
		boolean flag = false;
		for (int i = 1; i < elementData.length; i++) {
			if (elementData[i].equals(value)) {
				lastAddedLocation = i;
				flag = true;
			}
		}
		return flag;
	}

	//Returns the number of elements in the queue
	public int size() {
		return size;
	}

	// Returns true if there are no elements in this queue.
	private boolean isEmpty() {
		return size == 0;
	}

	// move rightmost/specified leaf to become new root
	// "bubble down" root as necessary to fix ordering
	private String bubbleDown(int location) {
		String result = elementData[location];
		elementData[location] = elementData[size];
        size--;
        int index = location;
        boolean found = false;
        while (!found && hasLeftChild(index)) {
            int left = leftChild(index);
            int right = rightChild(index);
            int child = left;
            if (hasRightChild(index) && elementData[right].compareTo(elementData[left]) < 0) {
                child = right;
            }
            if (elementData[index].compareTo(elementData[child]) > 0) {
                swap(elementData, index, child);
                index = child;
            } else {
                found = true;  
            }
        }
        return result;
	}

	
	/*
	*The following are generic helper methods
	*for navigating indexes up/down the tree
	*/
	private int parent(int index) {
		return index / 2;
	}
	
	private int leftChild(int index) {
		return index * 2;
	}
	
	private int rightChild(int index) {
		return index * 2 + 1;
	}
	
	private boolean hasParent(int index) {
		return index > 1;
	}
	
	private boolean hasLeftChild(int index) {
		return leftChild(index) <= size;
	}
	
	private boolean hasRightChild(int index) {
		return rightChild(index) <= size;
	}
	
	private void swap(String[] a, int index1, int index2) {
		String temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
}