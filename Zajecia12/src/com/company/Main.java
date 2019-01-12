package com.company;

import java.util.*;

public class Main {

    private static void dodajDane(ArrayList<Double> data){
        data.add(11.0);
        data.add(11.5);
        data.add(11.7);
        data.add(11.0);
        data.add(10.2);
        data.add(11.8);
        data.add(11.4);
        data.add(11.2);
        data.add(10.2);
        data.add(10.1);
    }

    private static Double obliczSrednia(Double [] data){
        if(data==null||data.length==0)
            return null;

        Double suma = 0.0;


        for(int i=0;i<data.length;i++)
            suma+=data[i];

        return suma/data.length;
    }

    private static Double obliczMedianę(Double [] data){

        if(data.length==1)
            return data[0];

        Arrays.sort(data);

        Double mediana;

        if(data.length/2.0==Math.round(data.length/2.0)){
            mediana = (data[(int)(data.length/2.0)-1]+data[(int)(data.length/2.0)])/2.0;

        }else{
            mediana = data[(int)(data.length/2.0)];
        }


        return mediana;
    }

    public static void main(String[] args) {

        ArrayList<Double> data1 = new ArrayList<Double>();
        dodajDane(data1);

        for(int i=0;i<data1.size();i++)
            System.out.println(data1.get(i));

        for(Double element : data1){
            System.out.println(element);
        }

        Collections.sort(data1);



        System.out.println("_____________________________");


        data1.add(40.0);

        for(int i=0;i<data1.size();i++)
            System.out.println(data1.get(i));

        System.out.println("Maksymalna wartość: "+Collections.max(data1));


        //System.out.println("Średnia wynosi:"+obliczSrednia(data));
        //System.out.println("Mediana wynosi:"+obliczMedianę(data));



        //System.out.println("Średnia wynosi:"+obliczSrednia(data));
        //System.out.println("Mediana wynosi:"+obliczMedianę(data));

        //obliczMedianę(data);
    }
}

