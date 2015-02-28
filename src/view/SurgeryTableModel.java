package view;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.AdultPatient;
import model.ChildPatient;
import model.Patient;

public class SurgeryTableModel extends DefaultTableModel{


    private ArrayList<Patient> thePatients;

    private static final int NO_OF_COLS = 5;

    // Constants for column indices
    private static final int NAME_COL = 0;
    private static final int ADDRESS_COL = 1;
    private static final int GENDER_COL = 2;
    private static final int OCCUPATION_COL = 3;
    private static final int NAME_OF_SCHOOL_COL = 4;



    public SurgeryTableModel(ArrayList<Patient> thePatients) {
        super();
        this.thePatients = thePatients;
    }

    // Now override the methods from the superclass DefaultTableModel
    //that we need to populate the table

    public int getColumnCount()
    {
        return NO_OF_COLS;
    }

    public String getColumnName(int columnIndex)
    {
        if (columnIndex == NAME_COL)
            return "Name";
        else if(columnIndex == ADDRESS_COL)
            return "Address";
        else if (columnIndex == GENDER_COL)
            return "Gender";
        else if (columnIndex == OCCUPATION_COL)
            return "Occupation";
        else if (columnIndex == NAME_OF_SCHOOL_COL)
            return "Name of School";
        else return "";
    }

    public int getRowCount()
    {
        if (this.thePatients != null)

            return this.thePatients.size();

        else

            return 0;
    }


    public Object getValueAt(int row, int col)
    {


        // Get the selected patient.
        Patient currentPatient = this.thePatients.get(row);

        // We need to get the type of Patient.

        // if the patient object is an instance of the AdultPatient class
        // return adult specific information
        if (currentPatient.getClass() == AdultPatient.class)
        {

            if (col == NAME_COL)
                return currentPatient.getName();

            else if (col == ADDRESS_COL)
                return currentPatient.getAddress();

            else if (col == GENDER_COL)
                return currentPatient.getGender();

            else if (col == OCCUPATION_COL)
                return ((AdultPatient) currentPatient).getOccupation();

            else
                return null;
        }

        // If the patient is a child, return only child specific info
        else if (currentPatient.getClass() == ChildPatient.class)
        {

            if (col == NAME_COL)
                return currentPatient.getName();

            else if (col == ADDRESS_COL)
                return currentPatient.getAddress();

            else if (col == GENDER_COL)
                return currentPatient.getGender();

            else if (col == NAME_OF_SCHOOL_COL)
                return ((ChildPatient) currentPatient).getNameOfSchool();
            else
                return null;

        }
        else return null;

    }


}
