package datastructures.stack;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Before sorting:");
        stack.printStack();

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();
    }

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!tempStack.isEmpty() &&  tempStack.peek() > temp) {
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }


    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        String result = "";

        for (Character c : str.toCharArray()) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static boolean isBalancedParentheses(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (stack.isEmpty() || stack.pop() != '(') {
                return false;
            }

        }
        return stack.isEmpty();

    }
}
