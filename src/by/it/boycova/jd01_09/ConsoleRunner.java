package by.it.boycova.jd01_09;

import java.util.Scanner;

class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InPut input= new InputConsole(scanner);
        Parser parser= new Parser();
        OutPut output=new OutputConsole();
        for(;;){
            String expression= input.getCommand();
            if(expression!=null){
                Var result = parser.calc(expression);
                output.showResult(result);
            }else {
                break;
            }
        }

    }
}
