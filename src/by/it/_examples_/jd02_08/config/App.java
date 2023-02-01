package by.it._examples_.jd02_08.config;

import java.io.Serial;
import java.io.Serializable;

public class App implements Serializable {


    @Serial private static final long serialVersionUID = 4197268381791240148L;
    private Database database;
    private Logger logger;


    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public String toString() {
        return "App{" +
                "\ndatabase=" + database +
                "\n logger=" + logger +
                "\n}";
    }
}
