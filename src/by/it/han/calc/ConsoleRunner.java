package by.it.han.calc;

import by.it.han.calc.exception.CalcException;
import by.it.han.calc.exception.VarException;
import by.it.han.calc.input.Input;
import by.it.han.calc.input.InputConsole;
import by.it.han.calc.model.Message;
import by.it.han.calc.model.Var;
import by.it.han.calc.output.Printer;
import by.it.han.calc.output.PrinterConsole;
import by.it.han.calc.service.Parser;
import by.it.han.calc.service.ResMan;

import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleRunner {

    private static final String USER_LANGUAGE = "user.language";
    private static final String SORT_VAR = "sortVar";
    private static final String RU = "ru";
    private static final String EN = "en";
    private static final String BY = "by";

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Scanner scanner = new Scanner(System.in);
        Input inputConsole = new InputConsole(scanner);
        Printer printerConsole = new PrinterConsole();
        ResMan resMan = ResMan.INSTANCE;
        setLocal(resMan, scanner);
        PrinterConsole.print(resMan.get(Message.startCalc));
        while (true) {
            String expression = getExpression(inputConsole);
            if (expression == null) break;
            if (isSort(expression)) continue;
            Var result;
            try {
                result = getResult(printerConsole, expression, resMan);
            } catch (CalcException | VarException e) {
                throw new RuntimeException(e);
            }
            printValues(printerConsole, result);
        }
    }

    private static void setLocal(ResMan resMan, Scanner scanner) {
        String userLanguage = System.getProperty(USER_LANGUAGE);
        PrinterConsole.print(resMan.get(Message.question));
        String input = scanner.nextLine();
        switch (input) {
            case RU -> resMan.setLocal(new Locale(RU));
            case EN -> resMan.setLocal(new Locale(EN));
            case BY -> resMan.setLocal(new Locale(BY));
            default -> resMan.setLocal(new Locale(userLanguage));
        }
    }

    private static String getExpression(Input inputConsole) {
        return inputConsole.input();
    }

    private static boolean isSort(String expression) {
        if (expression.equalsIgnoreCase(SORT_VAR)) {
            Var.sortMap();
            return true;
        }
        return false;
    }


    private static Var getResult(Printer printerConsole, String expression, ResMan resMan) throws CalcException, VarException {
        Parser parser = new Parser(expression, resMan);
        Var result = parser.calc();
        if (result != null) {
            printerConsole.print(result);
        }
        return result;
    }

    private static void printValues(Printer printerConsole, Var result) {
        Map<String, Var> map = Objects.requireNonNull(result).getMap();
        if (map != null) {
            printerConsole.printVar(result.getMap());
        }
    }
}
