package com.company.bank.bankOffice.bankFactory;

import com.company.bank.bankOffice.bankFactory.accountDertment.bankAccountFactory.AccountFactory;
import com.company.bank.bankOffice.bankFactory.creditDepartment.bankCreditFactory.BankCreditFactory;
import com.company.bank.bankOffice.bankFactory.insuranceDepartment.bankInsuranceFactory.InsuranceFactory;

public class AbstractFactory {
   public BankProductFactory createFactory(String type){
        switch (type) {
            case "Account" : return new AccountFactory();
            case "Credit" : return new BankCreditFactory();
            case "Insurence" : return  new InsuranceFactory();
        }
        return null;
    }

}
