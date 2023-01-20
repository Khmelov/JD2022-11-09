package by.it.han.jd02_03.model;

public record Good(String name) {

    @Override
    public String toString() {
        return name;
    }
}
