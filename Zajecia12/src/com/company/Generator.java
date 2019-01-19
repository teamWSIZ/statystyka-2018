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

    public static double gen2(){
        double x = Math.random();

        if(x>0.5)
            return 10-Math.random();
        else
            return 10+Math.random();
    }
}
