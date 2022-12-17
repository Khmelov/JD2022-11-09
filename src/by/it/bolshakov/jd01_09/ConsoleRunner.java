package by.it.bolshakov.jd01_09;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Input input = new InputConsole(scanner);
        Output output = new OutputConsole();
        Parser parser = new Parser();

        for (;;){
            String expression = input.getInput();
            if (expression!=null){
                Var result = parser.calc(expression);
                output.showResult(result);
            }
            else {
                break;
            }
        }
    }
}
