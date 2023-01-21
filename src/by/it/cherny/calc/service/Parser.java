package by.it.cherny.calc.service;

import by.it.cherny.calc.exception.CalcException;
import by.it.cherny.calc.util.Patterns;
import by.it.cherny.calc.repository.VarRepo;
import by.it.cherny.calc.entity.Var;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final VarRepo varRepo;
    public Parser(VarRepo varRepo) {
        this.varRepo = varRepo;
    }

    public Var calc(String expression) throws CalcException {

        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length==1){
            return varRepo.create(parts[0]);
        }
        Var right = varRepo.create(parts[1]);
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()){
            String operation = matcher.group();
            if (operation.equals("=")){
                return varRepo.save(parts[0],right);
            }
            Var left = varRepo.create(parts[0]);
            switch(operation){
                case"+":return left.add(right);
                case"*":return left.mul(right);
                case"-":return left.sub(right);
                case"/":return left.div(right);
            }
        }
        return null;
    }
}
