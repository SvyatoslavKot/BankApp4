package com.company.service;

public class WaitingInLine {

    private int viewRnd(){
        final int max = 8;
        final int rnd = rnd(max);
        return rnd;
    }

    private   int rnd (final int max){
        return (int) (Math.random() * max);

    }

    public void waitingInLine(String name){
        int i = viewRnd();
        System.out.println(" клиент " + name + " " + i + " в очереди.");
        System.out.println(name + " ожидайте: " + i + " секунд.");
        while ( i>0){
            try {
                i--;
                Thread.sleep(1000L);
            }catch (InterruptedException e){
                System.out.println("ExceptionInInitializerError e");
            }
        }}

}
