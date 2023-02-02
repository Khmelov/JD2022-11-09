package by.it.han.jd02_08.model;

import java.io.Serial;
import java.io.Serializable;

public class Phone implements Serializable {

    @Serial
    private static final long serialVersionUID = 6590047062100035476L;

    private String model;
    private String phoneNumber;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
