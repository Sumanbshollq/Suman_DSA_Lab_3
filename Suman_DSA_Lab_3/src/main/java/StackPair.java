import java.util.Scanner;
import java.util.Stack;

public class StackPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enetr the input String - ");
        String input = sc.next();
        if (checkBracket(input)) {
            System.out.println("Given expression is balanced");
        } else {
            System.out.println("Given expression is not balanced");
        }
    }

    public static boolean checkBracket(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char k = input.charAt(i);
            if (k == '[' || k == '(' || k == '{') {
                stack.push(k);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char c = stack.pop();
                if (k == ']') {
                    if (c != '[') {
                        return false;
                    }
                } else if (k == '}') {
                    if (c != '{') {
                        return false;
                    }
                } else if (k == ')') {
                    if (c != '(') {
                        return false;
                    }
                } else {
                    System.out.println("Entered wrong values");
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
}
