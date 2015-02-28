package model;

/**
 * Created by Jamie on 24/02/15.
 */
public class ChildPatient extends Patient {

    private String nameOfSchool;
    public ChildPatient(String name, String address, String gender, String nameOfSchool) {

        super(name, address, gender);
        this.nameOfSchool = nameOfSchool;

    }

    public String getNameOfSchool() {

        return nameOfSchool;

    }
}
