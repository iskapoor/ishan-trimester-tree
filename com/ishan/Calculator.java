package com.ishan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.ishan.DataTypes.Stack;
import com.ishan.DataTypes.Queue;

public class Calculator {
    private String calc;
    private String clearSqrtCalc;
    private Queue<Object> output = new Queue<>();
    private Stack<String> operators = new Stack<>();
    private static HashMap<String, Float> variables = new HashMap<>();
    private boolean isVar = false;

    public Calculator(String calc) {
        this.calc = calc;
        if (calc.contains("=")) {
            setVar();
        }
        else {
            clearSQRT();
            calcToRPN();
        }
    }

    public String clearSQRT() {
        if (calc.contains("SQRT(")) {
            int prefixLen = calc.split("SQRT")[0].length() + 5;

            int index = prefixLen-1;
            int count = 0;
            for (int i=prefixLen-1; i<calc.length(); i++) {
                if (String.valueOf(calc.charAt(i)).equals("(")) {
                    count++;
                }
                else if (String.valueOf(calc.charAt(i)).equals(")")) {
                    count--;
                }
                if (count == 0) {
                    break;
                }
                index++;
            }

            calc = calc.substring(0, prefixLen-5) + calc.substring(prefixLen-1, index+1) + "^0.5" + calc.substring(index+1, calc.length());
        }
        if (calc.contains("SQRT(")) {
            clearSQRT();
        }
        return calc;
    }

    public void setVar() {
        if (calc.contains("=")) {
            this.isVar = true;
            String name = String.valueOf(calc.charAt(0));
            Calculator value = new Calculator(calc.split("=")[1]);
            float varValue = value.compute();
            variables.put(name, varValue);
            System.out.println("Initialized Variable " + name + " with value " + varValue);
        }
    }

    public boolean calcOrVar() {
        if (this.isVar) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isVar(String name) {
        if (variables.containsKey(name)) {
            return true;
        }
        return false;
    }

    public float replaceVar(String name) {
        if (variables.containsKey(name)) {
            return variables.get(name);
        }
        return 0;
    }

    public Queue<Object> tokenize() {
        Queue<Object> calc = new Queue<>();
        Queue<Object> output = new Queue<>();
        for (int i=0; i<this.calc.length(); i++) {
            if (!String.valueOf(this.calc.charAt(i)).equals(" ")) {
                calc.enqueue(String.valueOf(this.calc.charAt(i)));
            }
        }
        while (calc.size() > 0) {
            String i = String.valueOf(calc.peek());
            // System.out.println(i);
            if (isNum(i)) {
                i = fullInt("", calc);
                output.enqueue(Float.parseFloat(i));
            }
            else if (isOp(i)) {
                output.enqueue(i);
                calc.dequeue();
            }
            else if (isVar(i)) {
                output.enqueue(replaceVar(i));
                calc.dequeue();
            }

        }
        return output;
    }

    public void calcToRPN() {
        Queue<Object> calc = tokenize();
        while (calc.size() > 0) {
            String i = String.valueOf(calc.peek());
            if (isNum(i)) {
                output.enqueue(Float.parseFloat(i));
                calc.dequeue();
            }
            else if (isOp(i)) {
                if (operators.size() > 0) {
                    if (i.equals(")")) {
                        if (operators.size()>0) {
                            while (!operators.peek().equals("(")) {
                                output.enqueue(operators.peek());
                                operators.pop();
                            }
                            operators.pop();
                        }
                    }
                    else if (i.equals("(")) {
                        operators.push(i);
                    }
                    else {
                        if (precedence(i) > precedence(operators.peek()) || (precedence(i) >= precedence(operators.peek()) && !association(i))) {
                            operators.push(i);
                        }
                        else {
                            output.enqueue(operators.peek());
                            operators.pop();
                            operators.push(i);
                        }
                    }
                }
                else {
                    operators.push(i);
                }
                if (calc.size() > 0) {
                    calc.dequeue();
                }
            }
            else {
                calc.dequeue();
            }
            // System.out.println(index + "\t" + output);
            // System.out.println(index + "\t" + operators);
        }
        while (operators.size()>0) {
            output.enqueue(operators.peek());
            operators.pop();
        }
        // System.out.println(index + "\t" + output);
        // System.out.println(index + "\t" + operators);
    }

    public float compute() {
        ArrayList<String> eq = new ArrayList<>();
        while (output.size() > 0) {
            eq.add(String.valueOf(output.peek()));
            output.dequeue();
        }
        eq = process(eq);
        return Float.parseFloat(eq.get(0));
    }

    public ArrayList<String> process(ArrayList<String> eq) {
        int index = 0;
        boolean containsOp = false;
        for (String i : eq) {
            if (isOp(i)) {
                containsOp = true;
                break;
            }
            index++;
        }
        // System.out.println("\n\n" + eq + "\n\n");
        if (containsOp) {
            eq = operate(eq, index);
        }
        boolean done = true;
        for (String i : eq) {
            if (isOp(i)) {
                done = false;
            }
        }
        if (!done) {
            process(eq);
        }
        return eq;

    }

    public ArrayList<String> operate(ArrayList<String> eq, int index) {
        String operator = eq.get(index);
        float result = 0;
        switch (operator) {
            case "+": result = Float.parseFloat(eq.get(index-2)) + Float.parseFloat(eq.get(index-1)); break;
            case "-": result = Float.parseFloat(eq.get(index-2)) - Float.parseFloat(eq.get(index-1)); break;
            case "*": result = Float.parseFloat(eq.get(index-2)) * Float.parseFloat(eq.get(index-1)); break;
            case "/": result = Float.parseFloat(eq.get(index-2)) / Float.parseFloat(eq.get(index-1)); break;
            case "^": result = (float) Math.pow(Float.parseFloat(eq.get(index-2)), Float.parseFloat(eq.get(index-1))); break;
            case "%": result = Float.parseFloat(eq.get(index-2)) % Float.parseFloat(eq.get(index-1));
        }
        // System.out.print(result); ...
        eq.set(index, String.valueOf(result));
        eq.remove(index-1);
        eq.remove(index-2);
        return eq;
    }

    public boolean isNum(String a) {
        try {
            Float.parseFloat(a);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String fullInt(String num, Queue calc) {
        num += String.valueOf(calc.peek());
        calc.dequeue();
        if (calc.size()>0) {
            if (isNum(String.valueOf(calc.peek())) || calc.peek().equals(".")) {
                num = fullInt(num, calc);
            }
        }
        return num;
    }

    public boolean isOp(String a) {
        switch (a) {
            case "+": return true;
            case "-": return true;
            case "*": return true;
            case "/": return true;
            case "^": return true;
            case "(": return true;
            case ")": return true;
            case "%": return true;
        }
        return false;
    }

    public int precedence(String a) {
        switch (a) {
            case "+": return 1;
            case "-": return 1;
            case "*": return 3;
            case "/": return 3;
            case "^": return 4;
            case "(": return 0;
            case ")": return 0;
            case "%": return 3;
        }
        return 0;
    }

    public boolean association(String a) {
        // Right = False
        // Left = True
        switch (a) {
            case "+": return true;
            case "-": return true;
            case "*": return true;
            case "/": return true;
            case "^": return false;
            case "(": return true;
            case ")": return true;
            case "%": return true;
        }
        return false;
    }

    public String getRPN() {
        return output.formattedString();
    }

    public String toString() {
        return (
            "\n" +
            "Original Expression:\t\t" + this.calc + "\n" +
            "Tokenized Expression:\t\t" + tokenize().formattedString() + "\n" +
            "Reverse Polish Notation:\t" + getRPN() + "\n" +
            "Computed Equation: \t\t\t" + compute() + "\n"
        );
    }

    public static void main(String[] args) {
        Calculator simpleMath = new Calculator("100 + 200  * 3");
        System.out.println("Simple Math\n" + simpleMath);

        Calculator parenthesisMath = new Calculator("(100 + 200)  * 3");
        System.out.println("Parenthesis Math\n" + parenthesisMath);

        Calculator allMath = new Calculator("200 % 300 + 5 + 300 / 200 + 1 * 100");
        System.out.println("All Math\n" + allMath);

        Calculator allMath2 = new Calculator("200 % (300 + 5 + 300) / 200 + 1 * 100");
        System.out.println("All Math2\n" + allMath2); 
        
        boolean done = false;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Type \"DONE\" to exit");
            System.out.print("Type an Expression: ");
            String a = sc.nextLine();
            if (a.equals("DONE")) {
                done = true;
            }
            else {
                Calculator input = new Calculator(a);
                if (!input.calcOrVar()) {
                    System.out.println(input);
                }
            }
        } while (!done);
    }
}
