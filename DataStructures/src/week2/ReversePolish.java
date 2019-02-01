package week2;

import java.util.Stack;

public class ReversePolish {

	public static void main(String[] args) {
		System.out.println("1 2 + 5 - 10 * = " + postFixEvaluate("1 2 + 5 - 10 *"));
		
		

	}
	
	
	public double postFixEvaluate(String exp) {
		Stack<Double> operands = new Stack<>();
		String[] args = exp.split(" "); 
		for (String s : args) {
			if (("+-/*").contains(s)) {
				switch(s) {
				case "+":
					operands.push(operands.pop() + operands.pop());
					break;
				case "-":
					operands.push(-operands.pop() + operands.pop());
					break;
				case "*":
					operands.push(operands.pop() * operands.pop());
					break;
				case "+/":
					operands.push(1 / operands.pop() * operands.pop());
					break;
				}
				
				
			}
			else {
				double num = Double.parseDouble(s);
				operands.push(num);
			}
			
		}
		return operands.pop();
		
	}

}
