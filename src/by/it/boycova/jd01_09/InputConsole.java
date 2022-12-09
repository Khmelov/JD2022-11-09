package by.it.boycova.jd01_09;

import java.util.Scanner;

class InputConsole implements InPut{

    private final Scanner scanner;

    public InputConsole(Scanner scanner){
        this.scanner=scanner;
    }

    @Override
     public String getCommand() {
        String line=scanner.nextLine();
        line.replaceAll("\\s+","");
         return line.equalsIgnoreCase("end")
                 ? null
                 : line;
     }
 }
