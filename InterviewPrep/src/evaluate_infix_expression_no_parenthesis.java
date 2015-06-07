import java.util.Stack;


/*
 * Parsing an Infix Expression with No Parentheses (like 2 * 3 - 48/4 -4 * 5)

Establish precedence + and - Lower than * and /

Until Stream not done
get token as current 
  When current is operand (a numeric value) push to operand stack as numbers (atoi)
   When current is operator
       if the operator stack top's is of lower precedence - push operator
       else if the operator on top of stack is higher precedence than incoming 
               pop the operator stack - 
               pop 2 operands evaluate the expression 
               push solution to operand stack
               push the incoming operator to operator stack

 After all tokens done - 
 pop 2 operands and one operator - evaluate

Final answer is the lone remaining entry in operand stack.
 * */

public class evaluate_infix_expression_no_parenthesis {

	private static int evaluate(char operator, int num1, int num2) {
		
		int result = 0;
		switch (operator) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			result = num1 / num2;
			break;
		}
		
		return result;
	}
	
	private static int getPrecedence(char operator) {
		int ret = 0;
		if (operator == '-' || operator == '+') {
			ret = 1;
		} else if (operator == '*') {
			ret = 2;
		} else if (operator == '/') {
			ret = 3;
		}
		
		return ret;
	}

	private static boolean isOperator(char val) {
		switch (val) {
		case '+':
		case '-':
		case '*':
		case '/':
			return true;
		default:
			return false;
		}
	}

	private static boolean isNumber(char val) {
		return Character.isDigit(val);
	}

	private static boolean operatorGreaterOrEqual(char op1, char op2) {
		return getPrecedence(op1) >= getPrecedence(op2);
	}
	
	public static void evaluate_infix_expression(String expression) {

		//Add error checks

		System.out.println("Evaluate: " + expression);

		char[] input = expression.toCharArray();
		Stack<Integer> num = new Stack<Integer>();
		Stack <Character> op = new Stack<Character>();
		int length = input.length;

		for (int i=0; i<length; i++) {

			char c = input[i];
			System.out.println("Char = " + c);

			//If item is a number, push onto number stack
			if (isNumber(c)) {
				num.push(Character.getNumericValue(c));
				System.out.println("Push number: " + Character.getNumericValue(c));
			}
			
			//If item is operator, and op stack is empty, push onto stack
			//Or, if operator on top of stack is of lower precedence than current op, push operator
			if ((isOperator(c) && op.isEmpty()) || isOperator(c) && operatorGreaterOrEqual(c, op.peek())) {
				op.push(c);
				System.out.println("Push operator: " + c);
			}
			
			else if (isOperator(c) && operatorGreaterOrEqual(op.peek(), c)) {
				
				//Pop an operator
				char operator = op.pop();
				System.out.println("Operator: " + operator);
				
				//Pop two numbers
				int num2 = num.pop();
				int num1 = num.pop();
				System.out.println("Num2 = " + num2 + " Num1 = " + num1);
				
				int result = evaluate(operator, num1, num2);
				System.out.println("Result = " + result);

				//Push result onto number stack
				num.push(result);

				//Push incoming operator onto operator stack
				op.push(c);
			}
		}
		
		System.out.println(op.toString());
		System.out.println(num.toString());
		
		//Now, while operator stack is not empty
		while (!op.isEmpty()) {

			//Pop an operator
			char operator = op.pop();

			//Pop two numbers
			int num2 = num.pop();
			int num1 = num.pop();

			System.out.println("Num1 = " + num1 + "  Num2 = " + num2);
			int result = evaluate(operator, num1, num2);
			System.out.println("Result = " + result);
			
			//Push result onto number stack
			num.push(result);
		}

		System.out.println("Answer: " + num.pop());
	}

	public static void main(String[] args) {

		//evaluate("1+2"); //3
		//evaluate("2*3"); //6
		//evaluate("8-4"); //4
		//evaluate("8/4"); //2
		//evaluate("1+2*3+4"); //11 //output is incorrect
		evaluate_infix_expression("4+8/2*3"); //16 //output is incorrect
	}

}
