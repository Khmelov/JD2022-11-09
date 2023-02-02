package by.it.han.jd02_08.model;

import java.io.Serial;
import java.io.Serializable;

public class Info implements Serializable {
    @Serial
    private static final long serialVersionUID = 4197268381791240148L;
    private Man man;
    private Phone phone;

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Info{" +
                "man=" + man +
                ", phone=" + phone +
                '}';
    }
}
