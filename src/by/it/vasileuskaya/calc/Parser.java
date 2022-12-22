package by.it.vasileuskaya.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Var calc(String expression) {
        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length == 1) {
            return Var.create(parts[0]);
        }
        Var rightPart = Var.create(parts[1]);
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            if (operation.equals("=")) {
                return Var.save(parts[0], rightPart);
            }
            Var leftPart = Var.create(parts[0]);
            switch (operation) {
                case "+":
                    return leftPart.add(rightPart);
                case "-":
                    return leftPart.sub(rightPart);
                case "*":
                    return leftPart.mul(rightPart);
                case "/":
                    return leftPart.div(rightPart);
            }
        }
        return null;
    }
}
