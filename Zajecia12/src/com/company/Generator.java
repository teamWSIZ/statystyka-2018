package com.company;

public class Generator {
    public static double f(double x){
        return x;
    }

    public static double gen(){
        double number,y,x;

        do {
            number = Math.random();
            x = Math.random();
            y = Generator.f(x);
        }while(number<y);

        return number;

    }
}
