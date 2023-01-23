package by.it.han.calc.service;

import by.it.han.calc.exception.CalcException;
import by.it.han.calc.exception.VarException;
import by.it.han.calc.model.Var;
import by.it.han.calc.util.Patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final String expression;

    private final Map<String, Integer> mapOperation = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    public Parser(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public Var calc() throws CalcException, VarException {
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
            values.add(index, tmpResult.toString().replace(" ", ""));
        }
        return Var.create(values.get(0));
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

    private Var calcOneOperation(String leftStr, String operation, String rightStr) throws CalcException, VarException {
        Var right = Var.create(rightStr);
        if (operation.equals("=")) {
            return Var.saveVar(leftStr, right);
        }
        Var left = Var.create(leftStr);
        switch (operation) {
            case "+" -> {
                return left.add(right);
            }
            case "*" -> {
                return left.mul(right);
            }
            case "-" -> {
                return left.sub(right);
            }
            case "/" -> {
                return left.div(right);
            }
        }
        throw new CalcException("incorrect data");
    }
}
