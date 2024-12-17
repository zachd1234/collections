//345678901234567890123456789012345678901234567890123456789012345678901234567890012345678901234567890
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Evaluates an arithmetic expression passed as a string.
 *
 * @author Murphy (starter)
 * @version December 2024
 */
public class ArithmeticExpressionEval {
    
    public static void testEvaluator() {
        System.out.println(evaluate("1+2*3"));
        System.out.println(evaluate("(1+2)*3"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression: ");
        String input = scanner.nextLine();
        while (!input.equals("")) {
            try {
                System.out.println(evaluate(input));
            } catch (NumberFormatException e) {
                System.out.println("Error: NumberFormatException");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: IllegalArgumentException");
            }
            System.out.println("Enter expression: ");
            input = scanner.nextLine();
        }
        System.out.println("Exited");
    }
    
    public static double evaluate(String expression) {
        //assign priorities
        String[] expressionList = tokenize(expression);
        int basePriority= 1;
        MyRobustLinkedList<ExpressionTree> nodeList = new MyRobustLinkedList<ExpressionTree>();
        
        for(String character : expressionList) {
            if(("+-*/()".indexOf(character) != -1)) {
                //add opperator node
                int oppType = "+-*/()".indexOf(character);
                if(oppType == 0 || oppType == 1) {
                    ExpressionTree newNode = new OperatorNode(character, basePriority); 
                }
            } else {
                //add number node
            }
        }
        
        return 0; // so it will compile
    }

    /**
     * Tokenizes an arithmetic expression. Supports numbers, the operators + - * /,
     * and parentheses.
     * 
     * @returns String array of tokens or null if unexpected characters
     */
    private static String[] tokenize(String expression) {
        ArrayList<String> tokens = new ArrayList<>();
        StringBuilder numberBuffer = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char currChar = expression.charAt(i);
            
            if (Character.isDigit(currChar) || currChar == '.') {
                numberBuffer.append(currChar);
            } else {
                if (numberBuffer.length() > 0) {
                    tokens.add(numberBuffer.toString());
                    numberBuffer.setLength(0);
                }
                if ("+-*/()".indexOf(currChar) != -1) {
                    tokens.add("" + currChar);
                } else if (currChar == ' ') {
                    // do nothing if space
                } else { // unexpected character
                    return null;
                }
            }
        }

        if (numberBuffer.length() > 0) { // string ended with numbers
            tokens.add(numberBuffer.toString());
        }
  
        return tokens.toArray(new String[0]);
    }
    
    // Binary tree for representing an arithmetic expression
    // Subclasses for operators versus numbers
    private static class ExpressionTree implements Comparable<ExpressionTree> {

        // To work with MyRobustLinkedList
        public int compareTo(ExpressionTree other) { 
            return 0;
        }
    }
    
    private static class NumberNode extends ExpressionTree {
        private double number;
        
        private NumberNode(double number) {
            this.number = number;
        }

        private double getNumber() {
            return number;
        }
    }
    
    private static class OperatorNode extends ExpressionTree {
        private String operator;
        private int priority;
        private ExpressionTree leftTree;
        private ExpressionTree rightTree;
        
        private OperatorNode(String operator, int priority) {
            this.operator = operator;
            this.priority = priority;
            this.leftTree = null;
            this.rightTree = null;
        }

        private String getOperator() {
            return operator;
        }
        
        private int getPriority() {
            return priority;
        }
        
        private void setPriority(int priority) {
            this.priority = priority;
        }
        
        private void setLeftTree(ExpressionTree tree) {
            leftTree = tree;
        }
        
        private void setRightTree(ExpressionTree tree) {
            rightTree = tree;
        }
    }
}
