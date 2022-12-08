package by.it.han.jd01_09;

public class Parser {

    private final String expression;

    public Parser(String expression) {
        this.expression = expression;
    }

    public Var calc() {
        String[] parts = expression.split(Patterns.OPERATION, 2);
        Var result = null;
        if (parts.length == 1) {
            return new Scalar(parts[0]);
        } else {
            String operation = expression.replaceAll("[^" + Patterns.OPERATION + "]", "");
            Var leftValue = Var.create(parts[0]);
            Var rightValue = Var.create(parts[1]);
            switch (operation) {
                case "+" -> result = leftValue.add(rightValue);
                case "-" -> result = leftValue.sub(rightValue);
                case "*" -> result = leftValue.mul(rightValue);
                case "/" -> result = leftValue.div(rightValue);
            }
        }
        return result;
    }
}
