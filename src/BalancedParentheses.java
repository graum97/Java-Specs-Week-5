import java.util.HashMap;
import java.util.Stack;

public class BalancedParentheses {
    public static boolean balancedParentheses(String string) {
        int numberOfOpenParens = 0;

        for (int i = 0; i <  string.length(); i += 1) {
            if (string.charAt(i) == '(') {
                numberOfOpenParens += 1;
            } else if (string.charAt(i) == ')') {
                numberOfOpenParens -= 1;
            } else if (numberOfOpenParens < 0) {
                return false;
            }
        }
        return numberOfOpenParens == 0;
    }

    public static boolean balancedBrackets(String string) {
        Stack<Character> stack = new Stack<Character>();

        HashMap<Character, Character> bracketPairs = new HashMap<Character, Character>();

        bracketPairs.put(')', '(');
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');
        bracketPairs.put('>', '<');

        for (int i = 0; i < string.length(); i += 1) {
            if (bracketPairs.containsValue(string.charAt(i))) {
                stack.push(string.charAt(i));
            } else if (bracketPairs.containsKey(string.charAt(i))) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character mostRecentBracket = stack.pop();
                if (!mostRecentBracket.equals(bracketPairs.get(string.charAt(i)))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
