import java.util.Stack;

public class Question4 {
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            }
            else if (c == '{') {
                stack.push('}');
            }
            else if (c == '[') {
                stack.push(']');
            }
            else if (c == '<') {
                stack.push('>');
            }
            else if (c == '¿') {
                stack.push('?');
            }
            else if (stack.isEmpty() || stack.pop() != c) {
                return "NO";
            }
        }

        if (stack.isEmpty()) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static void main(String args[]){
        String input = "{([]})}";
        System.out.println(isBalanced(input));
    }
}