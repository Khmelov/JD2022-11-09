package by.it.yaroshevich.jd02_08.config;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

public class Logger implements Serializable {
    @Serial
    private static final long serialVersionUID = 7095846688907168696L;
    private String path;
    private String[] level;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String[] getLevel() {
        return level;
    }

    public void setLevel(String[] level) {
        this.level = level.clone();
    }

    @Override
    public String toString() {
        return "Logger{" +
                "path='" + path + '\'' +
                ", level='" + Arrays.toString(level) + '\'' +
                '}';
    }
}
