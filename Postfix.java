package mentorAssessment;
import java.util.*;

public class Postfix {
    public static int evaluate(String postfix) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int op2 = stack.pop();
                int op1 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(op1 + op2);
                        break;
                    case '-':
                        stack.push(op1 - op2);
                        break;
                    case '*':
                        stack.push(op1 * op2);
                        break;
                    case '/':
                        stack.push(op1 / op2);
                        break;
                }
            }
        }
        return stack.pop();
    }

//    public static void main(String[] args) {
//        System.out.println(evaluate("82/")); // 4
//        System.out.println(evaluate("138*+")); // 25
//        System.out.println(evaluate("545*+5/")); // 5
    	public static void main(String[] args) {
    	    Scanner scanner = new Scanner(System.in);
    	    System.out.print("Enter a postfix expression: ");
    	    String postfix = scanner.nextLine();
    	    System.out.println("Result: " + evaluate(postfix));
    	}

    }

