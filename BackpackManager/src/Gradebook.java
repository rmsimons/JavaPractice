//Robert Simons
//CS143 Final
//Problem 3

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Gradebook {
	private Map<String, Student> students;
	private List<Student> copy;
	private StudentNode overallRootName;
	private StudentNode overallRootGPA;
	private StudentNode overallRootLevel;

	//Enters student list into map based on their name
	public Gradebook(List<Student> students) {
		overallRootName = null;
		List<Student> copy = new ArrayList<>(students);
		this.copy = new ArrayList<>(copy);
		this.students = new TreeMap<>();
		for (int i = 0; i < copy.size(); i++) {
			Student s = copy.get(i);
			String name = s.getName();
			this.students.put(name, s);
		}
	}

	//returns a list on sorted student names
	public List<Student> sortName() {
		List<Student> sortName = new ArrayList<>(copy);
		Collections.sort(sortName, new Comparator<Student>() {
			public int compare(Student object1, Student object2) {
				if (object1.getName() == object2.getName())
					return 0;
				return object1.getName().compareTo(object2.getName());
			}
		});
		return sortName;
	}

	//returns a list of sorted student GPAs
	public List<Student> sortGPA() {
		List<Student> sortGPA = new ArrayList<>(copy);
		Collections.sort(sortGPA, new Comparator<Student>() {
			public int compare(Student object1, Student object2) {
				if (object1.getGPA() == object2.getGPA()) {
					return 0;
				} else if (object1.getGPA() < object2.getGPA()) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		return sortGPA;
	}

	//returns a list of sorted student grade levels
	public List<Student> sortGradeLevel() {
		List<Student> sortGradeLevel = new ArrayList<>(copy);
		Collections.sort(sortGradeLevel, new Comparator<Student>() {
			public int compare(Student object1, Student object2) {
				if (object1.getGradeLevel() == object2.getGradeLevel()) {
					return 0;
				} else if (object1.getGradeLevel() < object2.getGradeLevel()) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		return sortGradeLevel;
	}

	//returns all the students of the given name
	public Set<Student> findName(String name) {
		List<Student> treeCopy = new ArrayList<>(copy);
		while (!treeCopy.isEmpty()) {
			overallRootName = buildTreeName(overallRootName, treeCopy);
			treeCopy.remove(0);
		}
		Set<Student> setName = new TreeSet<>();
		setName = containsName(overallRootName, name, null);
		return setName;

	}

	//searches the tree for the names
	private Set<Student> containsName(StudentNode root, String name, Set<Student> result) {
		if (root == null) {
			return null;
		} else if (name.equals(root.data.getName())) {
			result.add(root.data);
			return containsName(root.left, name, result);
		} else if (name.compareTo(root.data.getName()) < 0) {
			return containsName(root.left, name, result);
		} else {
			return containsName(root.right, name, result);
		}
	}

	//builds a tree based on names
	private StudentNode buildTreeName(StudentNode root, List<Student> treeCopy) {
		Student value = treeCopy.get(0);
		if (root == null) {
			root = new StudentNode(value);
		} else if (value.getName().compareTo(root.data.getName()) <= 0) {
			root.left = buildTreeName(root.left, treeCopy);
		} else {
			root.right = buildTreeName(root.right, treeCopy);
		}
		return root;
	}

	//returns all the students of the given GPA
	public Set<Student> findGPA(double gpa) {
		List<Student> treeCopy = new ArrayList<>(copy);
		while (!treeCopy.isEmpty()) {
			overallRootGPA = buildTreeGPA(overallRootGPA, treeCopy);
			treeCopy.remove(0);
		}
		Set<Student> setGPA = new TreeSet<>();
		setGPA = containsGPA(overallRootGPA, gpa, null);
		return setGPA;
	}

	//searches the tree for GPAs
	private Set<Student> containsGPA(StudentNode root, Double gpa, Set<Student> result) {
		if (root == null) {
			return null;
		} else if (gpa == root.data.getGPA()) {
			result.add(root.data);
			return containsGPA(root.left, gpa, result);
		} else if (gpa < root.data.getGPA()) {
			return containsGPA(root.left, gpa, result);
		} else {
			return containsGPA(root.right, gpa, result);
		}
	}

	//builds a tree based on GPAs
	private StudentNode buildTreeGPA(StudentNode root, List<Student> treeCopy) {
		Student value = treeCopy.get(0);
		if (root == null) {
			root = new StudentNode(value);
		} else if (value.getGPA() <= root.data.getGPA()) {
			root.left = buildTreeGPA(root.left, treeCopy);
		} else {
			root.right = buildTreeGPA(root.right, treeCopy);
		}
		return root;
	}

	//returns all the students of the given grade level
	public Set<Student> findGradeLevel(int gradeLevel) {
		List<Student> treeCopy = new ArrayList<>(copy);
		while (!treeCopy.isEmpty()) {
			overallRootLevel = buildTreeLevel(overallRootLevel, treeCopy);
			treeCopy.remove(0);
		}
		Set<Student> setLevel = new TreeSet<>();
		setLevel = containsLevel(overallRootLevel, gradeLevel, null);
		return setLevel;
	}

	//searches a tree for grade levels
	private Set<Student> containsLevel(StudentNode root, int gradeLevel, Set<Student> result) {
		if (root == null) {
			return null;
		} else if (gradeLevel == root.data.getGradeLevel()) {
			result.add(root.data);
			return containsLevel(root.left, gradeLevel, result);
		} else if (gradeLevel < root.data.getGradeLevel()) {
			return containsLevel(root.left, gradeLevel, result);
		} else {
			return containsLevel(root.right, gradeLevel, result);
		}
	}

	//builds a tree based on grade levels
	private StudentNode buildTreeLevel(StudentNode root, List<Student> treeCopy) {
		Student value = treeCopy.get(0);
		if (root == null) {
			root = new StudentNode(value);
		} else if (value.getGradeLevel() <= root.data.getGradeLevel()) {
			root.left = buildTreeLevel(root.left, treeCopy);
		} else {
			root.right = buildTreeLevel(root.right, treeCopy);
		}
		return root;
	}

	//constructs StudentNode objects to be used by Gradebook
	private static class StudentNode {
		public StudentNode left;
		public StudentNode right;
		public Student data;

		public StudentNode(Student data) {
			this.data = new Student(data.getName(), data.getGradeLevel(), data.getGPA());
			this.left = null;
			this.right = null;
		}
	}
}
