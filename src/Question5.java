import java.util.Stack;

public class Question5 {
    public static String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String currentString = "";
        int currentNumber = 0;

        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                currentNumber = (currentNumber * 10) + (c - '0');
            }
            else if (c == '[') {
                numberStack.push(currentNumber);
                stringStack.push(currentString);

                currentNumber = 0;
                currentString = "";
            }
            else if (c == ']') {
                String previousString = stringStack.pop();
                int repeatTimes = numberStack.pop();

                String repeatedPart = "";
                for (int i = 0; i < repeatTimes; i++) {
                    repeatedPart = repeatedPart + currentString;
                }

                currentString = previousString + repeatedPart;
            }
            else {
                currentString = currentString + c;
            }
        }

        return currentString;
    }

    public static void main(String[] args) {
        String input1 = "3[a]2[bc]";
        String input2 = "3[a2[c]]";
        String input3 = "2[abc]3[cd]ef";

        System.out.println(decodeString(input1));
        System.out.println(decodeString(input2));
        System.out.println(decodeString(input3));
    }
}