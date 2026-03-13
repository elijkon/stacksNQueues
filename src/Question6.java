import java.util.Stack;

public class Question6 {
    public static int getPrecedence(char c) {
        if (c == '^') {
            return 3;
        } else if (c == '*' || c == '/') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return -1;
        }
    }

    public static String infixToPostfix(String s) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                result = result + c;
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result = result + stack.pop();
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                while (!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(c)) {
                    result = result + stack.pop();
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        String input = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(input));
    }
}