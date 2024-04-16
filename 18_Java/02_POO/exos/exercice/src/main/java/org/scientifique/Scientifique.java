package org.scientifique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scientifique extends Worker{
    private List<String> disciplines;
    private List<String> types;

    public Scientifique(String lastname, String firstname, String email, String phone, String companyName, String companyAddress, String phonePro, List<String> disciplines, List<String> types) {
        super(lastname, firstname, email, phone, companyName, companyAddress, phonePro);
        this.disciplines = disciplines;
        this.types = types;
    }

    public List<String> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(ArrayList<String> disciplines) {
        this.disciplines = disciplines;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return super.toString() +
                "disciplines=" + Arrays.toString(disciplines.toArray()) +
                ", types=" + Arrays.toString(types.toArray());
    }
}
