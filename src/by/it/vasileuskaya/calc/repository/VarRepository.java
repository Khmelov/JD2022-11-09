package by.it.vasileuskaya.calc.repository;

import by.it.vasileuskaya.calc.ConsoleRunner;
import by.it.vasileuskaya.calc.exception.CalcException;
import by.it.vasileuskaya.calc.model.Matrix;
import by.it.vasileuskaya.calc.model.Scalar;
import by.it.vasileuskaya.calc.model.Var;
import by.it.vasileuskaya.calc.model.Vector;
import by.it.vasileuskaya.calc.util.PathFinder;
import by.it.vasileuskaya.calc.util.Patterns;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class VarRepository {

    public static final String FILE_PATH = PathFinder.getFilePath("var.txt", ConsoleRunner.class);
    private final Map<String, Var> varsInMap = new HashMap<>();

    public VarRepository() {
        loadVarMap();
    }

    private void loadVarMap() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
                while (bufferedReader.ready()) {
                    String line = bufferedReader.readLine();
                    String[] parts = line.split("=");
                    String nameVar = parts[0];
                    Var var = create(parts[1]);
                    varsInMap.put(nameVar, var);
                }
            } catch (IOException | CalcException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Var create(String varName) throws CalcException {
        if (varName.matches(Patterns.SCALAR)) {
            return new Scalar(varName);
        } else if (varName.matches(Patterns.VECTOR)) {
            return new Vector(varName);
        } else if (varName.matches(Patterns.MATRIX)) {
            return new Matrix(varName);
        } else if (varsInMap.containsKey(varName)) {
            return varsInMap.get(varName);
        }
        Var var = varsInMap.get(varName);
        if (var == null) {
            throw new CalcException("Variable " + varName + " not found");
        }
        return var;
    }

    public Var save(String name, Var value) {
        varsInMap.put(name, value);
        saveVarToFile(FILE_PATH);
        return value;
    }

    private void saveVarToFile(String filePath) {
        try (PrintWriter printWriter = new PrintWriter(filePath)) {
            for (Map.Entry<String, Var> stringVarEntry : varsInMap.entrySet()) {
                printWriter.printf("%s=%s%n", stringVarEntry.getKey(), stringVarEntry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void print() {
        for (Map.Entry<String, Var> entry : varsInMap.entrySet()) {
            System.out.printf("%s=%s%n", entry.getKey(), entry.getValue());
        }
    }
}
