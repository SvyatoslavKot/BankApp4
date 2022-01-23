package com.company.builder;

import com.company.bankCentralOffice.ManagerCustomerService;
import com.company.bankCentralOffice.ManagerSpecialAccountOperations;

public class BankCentralOfficeBuilder implements BankBuilder {

    private final ManagerCustomerService customerServiceDepartment = new ManagerCustomerService();
    private final ManagerSpecialAccountOperations specialAccountOperations = new ManagerSpecialAccountOperations();

    public ManagerCustomerService getCustomerServiceDepartment() {
        return customerServiceDepartment;
    }

    public ManagerSpecialAccountOperations getSpecialAccountOperations() {
        return specialAccountOperations;
    }
}
