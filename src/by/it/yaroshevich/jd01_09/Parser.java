package by.it.yaroshevich.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Var calc(String expression) {
        String [] parts = expression.split(Paterns.OPERATION, 2);
        Var left=Var.create(parts[0]);
        if (parts.length==1){
            return left;
        }
        Var right =Var.create((parts[1]));
        Pattern pattern = Pattern.compile(Paterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()){
            String operation = matcher.group();
            switch (operation){
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);
            }
        }
        return null;
    }
}
