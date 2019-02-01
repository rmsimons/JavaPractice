package week2;

public class ArrayIntList {
	private int[] data;
	private int size;
	private String name;
	
	public static final int DEFAULT_CAPACITY = 10;
	public static final String DEFAULT_NAME = "stuart";
	
	
	public ArrayIntList(int capacity, String name) {
		this.data = new int[capacity];
		this.name = name;
		this.size = 0;
	}
	
	public ArrayIntList(int capacity) {
		this(capacity, DEFAULT_NAME);
	}
	//ArrayIntList = new ArrayIntList()
	public ArrayIntList() {
		this(DEFAULT_CAPACITY);
	}
	
	public int size() {
		return this.size;
	}
	
	//List Methods we will implement:
	//add(int i). add(int index, int i), contains(int i), indexOf(int i),
	//remove(int index), clear(), get(int index), set(int index, int i), size()
	
	//adds element at the index equal size 
	public void add(int i) {
		capacityCheck();
		data[size] = i;
		size++;
	}
	
	public void add(int index, int i) {
		checkLegalIndex(index);
		capacityCheck();
		for ( int j = size; j > index; j--) {
			data[j] = data[j - 1];
		}
		data[index] = i;
		size++;
	}
	
	public boolean contains(int i) {
		for (int j = 0; j < size; j++) {
			if (data[j] == i) {
				return true;
			}
		}
		return false;
	}
	
	public int indexOf(int i) {
		for (int j = 0; j < size; j++) {
			if (data[j] == i) {
				return j;
			}
		}
		return -1;
	}
	
	public int get(int index) {
		checkLegalIndex(index);
		return data[index];
	}
	
	public int set(int index, int i) {
		checkLegalIndex(index);
		int temp = data[index];
		data[index] = i;
		return temp;
	}
	
	public int remove(int index) {
		checkLegalIndex(index);
		int temp = data[index];
		for (int i = index + 1; i < size; i++) {
			data[i - 1] = data[i];
		}
		size--;
		return temp;
	}
	
	public void clear() {
		size = 0;
	}
	
	public void reset() {
		size = 0;
		data = new int[10];
	}
	
	private void capacityCheck() {
		if(size >= 0.75 * data.length) {
			int[] dum = new int[data.length * 2];
			for (int i = 0; i < data.length; i++) {
				dum[i] = data[i];
			}
			data = dum;
		}
	}
	
	private void checkLegalIndex(int index) {
		if (index < 0 || index >= size) {
			throw new RuntimeException("Index outside of the list's bounds");
		}
	}
}
