package Task1_4;

// Java program for checking balanced Parenthesis
// www.geeksforgeeks.org

public class BalancedParan {
    // Returns true if character1 and character2 are matching left and right Parenthesis.
    static boolean isMatchingPair(char character1, char character2) {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else if (character1 == '[' && character2 == ']')
            return true;
        else
            return false;
    }

    // Return true if expression has balanced Parenthesis.
    static boolean areParenthesisBalanced(char exp[]) {
        // Declare an empty character stack.
        stack st = new stack();

        // Traverse the given expression to check matching parenthesis.
        for (int i = 0; i < exp.length; i++) {

            // If the exp[i] is a starting parenthesis then push it.
            if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
                st.push(exp[i]);

            // If exp[i] is an ending parenthesis then pop from stack and check if the popped parenthesis is a matching pair.
            if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {

                // If we see an ending parenthesis without a pair then return false.
                if (st.isEmpty()) {
                    return false;
                }

                // Pop the top element from stack, if it is not a pair parenthesis of character
                // then there is a mismatch. This happens for expressions like {(}).
                else if (!isMatchingPair(st.pop(), exp[i])) {
                    return false;
                }
            }

        }

        // If there is something left in expression then there is a starting parenthesis without a closing parenthesis.

        if (st.isEmpty())
            return true; // Balanced.
        else {   // Not Balanced.
            return false;
        }
    }

    // Driver program to Task1_1 above functions
    public static void main(String[] args) {
        char exp[] = {'{', '(', ')', '}', '[', ']'};
        if (areParenthesisBalanced(exp))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }

    // UTILITY FUNCTIONS

    static class stack {
        int top = -1;
        char items[] = new char[100];

        void push(char x) {
            if (top == 99) {
                System.out.println("Stack full");
            } else {
                items[++top] = x;
            }
        }

        char pop() {
            if (top == -1) {
                System.out.println("Underflow error");
                return '\0';
            } else {
                char element = items[top];
                top--;
                return element;
            }
        }

        boolean isEmpty() {
            return (top == -1) ? true : false;
        }
    }
}