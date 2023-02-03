package by.it.vasileuskaya.calc.service;

import by.it.vasileuskaya.calc.exception.CalcException;
import by.it.vasileuskaya.calc.model.Var;
import by.it.vasileuskaya.calc.repository.VarRepository;
import by.it.vasileuskaya.calc.util.Patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final VarRepository varRepo;

    private final Map<String, Integer> mapPriorityOperation = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    public Parser(VarRepository varRepo) {
        this.varRepo = varRepo;
    }

    public Var calc(String expression) throws CalcException {
        expression = expression.trim().replaceAll("\\s", "");
        List<String> fixedList = Arrays.asList(expression.split(Patterns.OPERATION));
        List<String> values = new ArrayList<>(fixedList);
        List<String> operations = new ArrayList<>();
        Matcher operationMatcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (operationMatcher.find()) {
            operations.add(operationMatcher.group());
        }
        while (operations.size() > 0) {
            int index = findIndexPriorityOperation(operations);
            String operation = operations.remove(index);
            String leftPart = values.remove(index);
            String rightPart = values.remove(index);
            Var tmpResult = calcOneOperation(leftPart, operation, rightPart);
            values.add(index, tmpResult.toString());
        }
        return varRepo.create(values.get(0));
    }

    private int findIndexPriorityOperation(List<String> operations) {
        int index = -1;
        int priority = -1;
        for (int i = 0; i < operations.size(); i++) {
            Integer tmpPriority = mapPriorityOperation.get(operations.get(i));
            if (priority < tmpPriority) {
                priority = tmpPriority;
                index = i;
            }
        }
        return index;
    }

    private Var calcOneOperation(String leftStr, String operation, String rightStr) throws CalcException {
        Var rightPart = varRepo.create(rightStr);
        if (operation.equals("=")) {
            return varRepo.save(leftStr, rightPart);
        }
        Var leftPart = varRepo.create(leftStr);
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

        throw new CalcException("Incorrect data!");
    }
}
