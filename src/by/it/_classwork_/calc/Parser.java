package by.it._classwork_.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    @SuppressWarnings("ConstantConditions")
    public Var calc(String expression) {
        //1+2  4+5  6*9  9-{1,2,3} 3 A=9
        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length == 1) {
            return Var.create(parts[0]);
        }
        Var right = Var.create(parts[1]);
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            if (operation.equals("=")){
                return Var.save(parts[0],right);
            }
            Var left = Var.create(parts[0]);
            switch (operation) {
                case "+":
                    return left.add(right);
                case "*":
                    return left.mul(right);
                case "-":
                    return left.sub(right);
                case "/":
                    return left.div(right);
            }
        }

        return null;
    }
}
