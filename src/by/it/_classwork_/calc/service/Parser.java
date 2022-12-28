package by.it._classwork_.calc.service;

import by.it._classwork_.calc.exception.CalcException;
import by.it._classwork_.calc.repository.VarRepo;
import by.it._classwork_.calc.util.Patterns;
import by.it._classwork_.calc.entity.Var;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final VarRepo varRepo;

    public Parser(VarRepo varRepo) {
        this.varRepo = varRepo;
    }

    @SuppressWarnings("ConstantConditions")
    public Var calc(String expression) throws CalcException {
        //1+2  4+5  6*9  9-{1,2,3} 3 A=9
        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length == 1) {
            return varRepo.create(parts[0]);
        }
        Var right = varRepo.create(parts[1]);
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            if (operation.equals("=")){
                return varRepo.save(parts[0],right);
            }
            Var left = varRepo.create(parts[0]);
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
