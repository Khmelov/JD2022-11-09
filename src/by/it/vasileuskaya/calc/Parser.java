package by.it.vasileuskaya.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final Map<String, Integer> mapPriorityOperation = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    public Var calc(String expression) throws CalcException {

        List<String> fixedValues = Arrays.asList(expression.split(Patterns.OPERATION));
        List<String> values = new ArrayList<>(fixedValues);

        List<String> operations = new ArrayList<>();
        Matcher operationMatcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (operationMatcher.find()) {
            operations.add(operationMatcher.group());
        }
        while (operations.size() > 0) {
            int operationIndex = findOperationIndex(operations);
            String operation = operations.remove(operationIndex);
            String left = values.remove(operationIndex);
            String right = values.remove(operationIndex);
            Var tmpResult = calcOneOperation(left, operation, right);
            values.add(operationIndex, tmpResult.toString());
        }
        return Var.create(values.get(0));
    }

    private int findOperationIndex(List<String> operations) {
        int currentIndex = -1;
        int currentPriority = -1;
        for (int i = 0; i < operations.size(); i++) {
            Integer priorityForEquals = mapPriorityOperation.get(operations.get(i));
            if (currentPriority < priorityForEquals) {
                currentPriority = priorityForEquals;
                currentIndex = i;
            }
        }
        return currentIndex;
    }

    private Var calcOneOperation(String leftStr, String operation, String rightStr) throws CalcException {

        Var rightPart = Var.create(rightStr);
        if (operation.equals("=")) {
            return Var.save(leftStr, rightPart);
        }
        Var leftPart = Var.create(leftStr);
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
        throw new CalcException("Incorrect data");
    }
}
