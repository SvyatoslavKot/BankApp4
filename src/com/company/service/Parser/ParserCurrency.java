package com.company.service.Parser;

import com.company.MainFxml;
import com.company.bank.bankOffice.BankOffice;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class ParserCurrency extends Thread{
    BankOffice bankOffice;
    public ParserCurrency(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    private static Document getPage() throws IOException{
        String url = "https://www.cbr.ru/currency_base/daily/";
        Document page = Jsoup.parse(new URL(url),3000);
        return page;
    }

    @Override
    public void run() {
       System.out.println(bankOffice.getBankCollections().getCurrencyCBR().size());
        Document page = null;
        try {
            page = getPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element tableCur = page.select("table[class=data]").first();
        Elements curs = tableCur.select("tr");
        for (Element cur : curs){
            System.out.println("tr blok");
            Elements vs = cur.select("td");
            CurElement element = new CurElement();
            int num = 0 ;
            for(Element v : vs){
                String vt = v.select("td").text();
                if(num == 0){
                    element.setCod(vt);
                    num++;
                }else if(num == 1){
                    element.setAbr(vt);
                    num++;
                }else if(num == 2){
                    element.setUnit(vt);
                    num++;
                }else if(num == 3){
                    element.setTitle(vt);
                    num++;
                }else if(num == 4){
                    element.setValues(vt);
                    num++;
                }
            }
            System.out.println(element);
            bankOffice.getBankCollections().getCurrencyCBR().put(element.getCod(), element);
        }

        // System.out.println(curs);
    }
}
