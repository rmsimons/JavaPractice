//Robert Simons

import java.util.Stack;

public class LispEvaluator {

	private String lispInput;
	private Stack<Object> operatorStack;
	private Stack<Double> argumentStack;
	private double solution;

	public LispEvaluator(String lisp) {
		if (lisp.isEmpty()) {
			throw new IllegalArgumentException("Not a valid Lisp Expression");
		}
		this.lispInput = lisp.replaceAll("\\s+", ""); 
		this.operatorStack = new Stack<>();
		this.argumentStack = new Stack<>();
	}

	public void parse() {
		String[] arr = this.lispInput.split("(?!^)");
		for (String s : arr) {
			if (("0123456789").contains(s)) {
				this.operatorStack.push(Double.parseDouble(s));
			} else {
				switch (s) {
				case "(":
					break;
				case ")":
					computeResult();
					break;
				case "+":
					this.operatorStack.push("+");
					break;
				case "-":
					this.operatorStack.push("-");
					break;
				case "/":
					this.operatorStack.push("/");
					break;
				case "*":
					this.operatorStack.push("*");
					break;
				case "%":
					this.operatorStack.push("%");
					break;
				case "^":
					this.operatorStack.push("^");
					break;
				}
			}
		}
		this.solution = Double.parseDouble(String.valueOf(this.operatorStack.pop()));
	}

	// calculates the value of the expression before the closing parenthesis
	public void computeResult() {
		double result;
		String temp;
		boolean isNumeric = true;
		do {
			temp = (String.valueOf(operatorStack.pop()));
			try {
				argumentStack.push(Double.parseDouble(temp));
			} catch (NumberFormatException nfe) {
				isNumeric = false;
			}
		} while (isNumeric);
		switch (temp) {
		case "+" :
			result = argumentStack.pop();
			while (!argumentStack.isEmpty()) {
				result += argumentStack.pop();
			}
			break;
		case "-" :
			result = argumentStack.pop();
			while (!argumentStack.isEmpty()) {
				result -= argumentStack.pop();
			}
			break;
		case "/" :
			result = argumentStack.pop();
			while (!argumentStack.isEmpty()) {
				result /= argumentStack.pop();
			}
			break;
		case "*" :
			result = argumentStack.pop();
			while (!argumentStack.isEmpty()) {
				result *= argumentStack.pop();
			}
			break;
		case "%" :
			result = argumentStack.pop();
			while (!argumentStack.isEmpty()) {
				result %= argumentStack.pop();
			}
			break;
		case "^" :
			result = argumentStack.pop();
			while (!argumentStack.isEmpty()) {
				result = Math.pow(result, argumentStack.pop());
			}
			break;
		default:
			result = argumentStack.pop();
			break;
		}
		operatorStack.push(result);
	}
	
	public double evaluate() {
		parse();
		return this.solution;
	}
}
