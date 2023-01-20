package by.it._classwork_.calc.service;

import by.it._classwork_.calc.entity.Var;
import by.it._classwork_.calc.exception.CalcException;
import by.it._classwork_.calc.repository.VarRepo;
import by.it._classwork_.calc.util.Patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final Map<String, Integer> mapOperation = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    private final VarRepo varRepo;

    public Parser(VarRepo varRepo) {
        this.varRepo = varRepo;
    }

    @SuppressWarnings("ConstantConditions")
    public Var calc(String expression) throws CalcException {
        //A=3+8*5-4/3
        //Values     = A 24 5 4 3
        //Operations = + - /
        List<String> fixedValues = Arrays.asList(expression.split(Patterns.OPERATION));
        List<String> values = new ArrayList<>(fixedValues);

        List<String> operations = new ArrayList<>();
        Matcher operationMatcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (operationMatcher.find()) {
            operations.add(operationMatcher.group());
        }
        while (operations.size() > 0) {
            int index = findOperationIndex(operations);
            String operation = operations.remove(index);
            String left = values.remove(index);
            String right = values.remove(index);
            Var tmpResult = calcOneOperation(left, operation, right);
            values.add(index, tmpResult.toString());
        }
        return varRepo.create(values.get(0));
    }

    private int findOperationIndex(List<String> operations) {
        int index = -1;
        int pr = -1;
        for (int i = 0; i < operations.size(); i++) {
            Integer tmpPr = mapOperation.get(operations.get(i));
            if (pr < tmpPr) {
                pr = tmpPr;
                index = i;
            }
        }
        return index;
    }

    private Var calcOneOperation(String leftStr, String operation, String rightStr) throws CalcException {
        Var right = varRepo.create(rightStr);
        if (operation.equals("=")) {
            return varRepo.save(leftStr, right);
        }
        Var left = varRepo.create(leftStr);
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
        throw new CalcException("incorrect data");
    }
}
