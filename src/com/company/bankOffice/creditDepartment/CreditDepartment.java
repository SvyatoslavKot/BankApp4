package com.company.bankOffice.creditDepartment;

import com.company.bankOffice.Staff;

import java.util.ArrayList;

public class CreditDepartment {
    ArrayList<Staff> creditPersonal = new ArrayList<>() {
        {
            add(new CreditManager("Олег",22,"Стажер"));
        }
    };

    public ArrayList<Staff> getCreditPersonal() {
        return creditPersonal;
    }
}
