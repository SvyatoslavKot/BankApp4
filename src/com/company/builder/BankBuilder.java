package com.company.builder;

import com.company.bankCentralOffice.ManagerCustomerService;
import com.company.bankCentralOffice.ManagerSpecialAccountOperations;
import com.company.bankOffice.Kassa;
import com.company.bankOffice.accountManagementDepartment.AccountManeger;
import com.company.bankOffice.creditDepartment.CreditManager;

public interface BankBuilder {
    default AccountManeger getAccountManager(){
        return null;
    }

    default ManagerCustomerService getCustomerServiceDepartment(){
        return null;
    }

    default ManagerSpecialAccountOperations getSpecialAccountOperations(){
        return null;
    }

    default Kassa getKassa(){
        return null;
    }

    default CreditManager getCreditManager(){
        return null;
    }
}
