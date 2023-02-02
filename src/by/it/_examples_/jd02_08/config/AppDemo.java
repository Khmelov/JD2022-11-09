package by.it._examples_.jd02_08.config;

import java.io.*;
import java.time.LocalDateTime;

public class AppDemo implements Externalizable {

    @Serial
    private static final long serialVersionUID = 4197268381791240148L;
    public Database database;
    public Logger logger;

    public transient LocalDateTime localDateTime=LocalDateTime.now();

    @Override
    public String toString() {
        return "App{" +
                "\ndatabase=" + database +
                "\n logger=" + logger +
                "\n}";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(database);
        out.writeObject(logger);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        database=(Database)in.readObject();
        logger=(Logger) in.readObject();
    }
}
