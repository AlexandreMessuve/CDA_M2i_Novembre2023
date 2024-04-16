package org.scientifique;

public class Worker extends Person{
    protected String companyName;
    protected String companyAddress;
    protected String phonePro;

    public Worker(String lastname, String firstname, String email, String phone, String companyName, String companyAddress, String phonePro) {
        super(lastname, firstname, email, phone);
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.phonePro = phonePro;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getPhonePro() {
        return phonePro;
    }

    public void setPhonePro(String phonePro) {
        this.phonePro = phonePro;
    }

    @Override
    public String toString() {
        return super.toString() +
                "companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", phonePro='" + phonePro + '\'';
    }
}
