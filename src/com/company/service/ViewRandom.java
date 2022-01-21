package com.company.service;

public class ViewRandom {
    public  void viewRnd(){
        final int max = 15;
        final int rnd = rnd(max);
        System.out.println(rnd);
    }

    public  int rnd (final int max){
        return (int) (Math.random() * max);

    }
}
