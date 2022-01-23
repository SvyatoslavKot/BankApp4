package com.company.bilder;

import com.company.Client;
import com.company.bankCentralOffice.BankCentralOffice;
import com.company.bankOffice.Atm;
import com.company.bankOffice.BankOffice;
import com.company.bankOffice.Kassa;
import com.company.bankOffice.SelfTerminal;

public class BankBilder {
    private final SelfTerminal selfServiceTerminal = new SelfTerminal();
    private final Atm atm = new Atm();
    private Kassa kassa = new Kassa();

    public SelfTerminal bildSelfServiceTerminal(BankOffice bankOffice, Client client) {
        bankOffice.getClientBankList().put(client.getPassport(),client.getName() + " " + client.getLastName());
        System.out.println(client.getName() + " подошел к терминалу самообслуживания в Банке "+ bankOffice.getNameBank() );
        return selfServiceTerminal;
    }
    public SelfTerminal bildSelfServiceTerminalCentralOffice(BankCentralOffice bankCentralOffice, Client client) {
        bankCentralOffice.getClientBankListCentral().put(client.getPassport(),client.getName() + " " + client.getLastName());
        System.out.println(client.getName() + " подошел к терминалу самообслуживания в Банке "+ bankCentralOffice.getNameBank() );
        return selfServiceTerminal;
    }
    public Atm bildAtm(BankOffice bankOffice,Client client) {
        System.out.println(client.getName() + " подошел к банкомату самообслуживания в Банке "+ bankOffice.getNameBank() );
        return atm;
    }
    public Kassa getKassa(Client client) {
        System.out.println("Клиент"+ client.getName() + " направлен в кассу.");
        return kassa;
    }

}
