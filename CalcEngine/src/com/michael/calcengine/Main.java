package com.michael.calcengine;

public class Main {

    public static void main(String[] args) {

        String[] statements = {
              "add 1.0",
              "add xx 25.0",
              "addX 0.0 0.0",
              "divide 100.0 50.0",
              "add 25.0 92.0",
              "subtract 225.0 17.0",
              "multiply 11.0 3.0"
        };

        CalculateHelper helper = new CalculateHelper();

        for (String statement : statements) {
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch (InvalidStatementException e) {
                System.out.println(e.getMessage());
                if (e.getCause() != null)
                    System.out.println("  Original Exception: " + e.getCause().getMessage());
            }
        }
    }

    static void useMathEquation() {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d',100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);
    }
}
