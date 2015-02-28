package model;

/**
 * Created by Jamie on 24/02/15.
 */
public abstract class Patient {
    private String name, address, gender;

    public Patient(String name, String address, String gender) {

        this.name = name;
        this.address=address;
        this.gender=gender;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }
}
