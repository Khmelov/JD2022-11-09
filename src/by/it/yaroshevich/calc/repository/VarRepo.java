package by.it.yaroshevich.calc.repository;

import by.it.yaroshevich.calc.ConsoleRunner;
import by.it.yaroshevich.calc.entity.Matrix;
import by.it.yaroshevich.calc.entity.Scalar;
import by.it.yaroshevich.calc.entity.Var;
import by.it.yaroshevich.calc.entity.Vector;
import by.it.yaroshevich.calc.exception.CalcException;
import by.it.yaroshevich.calc.util.PathFinder;
import by.it.yaroshevich.calc.util.Patterns;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class VarRepo {

    public static final String FILE_PATH = PathFinder.getFilePath("var.txt", ConsoleRunner.class);
    private final Map<String, Var> vars = new HashMap<>();

    public VarRepo() {
        loadVarMap();
    }

    private void loadVarMap() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                while (reader.ready()) {
                    String line = reader.readLine();
                    String[] parts = line.split("=");
                    String name = parts[0];
                    Var var = create(parts[1]);
                    vars.put(name, var);
                }
            } catch (IOException | CalcException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Var create(String varName) throws CalcException {
        if (varName.matches(Patterns.SCALAR)) {
            return new Scalar(varName);
        }
        if (varName.matches(Patterns.VECTOR)) {
            return new Vector(varName);
        }
        if (varName.matches(Patterns.MATRIX)) {
            return new Matrix(varName);
        }
        Var var = vars.get(varName);
        if (var == null) {
            throw new CalcException("Variable %s not found".formatted(varName));
        }
        return var;
    }

    public Var save(String name, Var value) {
        vars.put(name, value);
        saveMapVarToFile(FILE_PATH);
        return value;
    }

    private void saveMapVarToFile(String filePath) {
        try (PrintWriter printWriter = new PrintWriter(filePath)) {
            for (Map.Entry<String, Var> varEntry : vars.entrySet()) {
                printWriter.printf("%s=%s%n", varEntry.getKey(), varEntry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void print() {
        for (Map.Entry<String, Var> entry : vars.entrySet()) {
              System.out.printf("%s=%s%n", entry.getKey(), entry.getValue());
        }
    }

}
