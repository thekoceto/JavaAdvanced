package com.company.P07_Google;

public class Parents {
    //•	"<Name> parents <parentName> <parentBirthday>"
    String parentName;
    String parentBirthday;

    public Parents(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n", this.parentName, this.parentBirthday);
    }
}
