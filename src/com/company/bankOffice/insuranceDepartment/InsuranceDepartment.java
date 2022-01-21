package com.company.bankOffice.insuranceDepartment;

import com.company.Client;
import com.company.service.WaitingInLine;

public class InsuranceDepartment {
    InsuranceAgent insuranceAgent = new InsuranceAgent();
    WaitingInLine waitingInLine = new WaitingInLine();

    public InsuranceAgent getInsuranceAgent(Client client) {
        waitingInLine.waitingInLine(client.getName());
        System.out.println("Клиент направлен к Страховому агенту.");
        return insuranceAgent;
    }
}
