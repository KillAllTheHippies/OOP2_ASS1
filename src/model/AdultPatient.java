package model;

/**
 * Created by Jamie on 24/02/15.
 */
public class AdultPatient extends Patient {

    private String occupation;

    public AdultPatient(String name, String address, String gender, String occupation) {

        super(name, address, gender);
        this.occupation = occupation;

    }

    public String getOccupation() {

        return occupation;

    }

}
