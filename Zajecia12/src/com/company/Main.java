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

    private static Double obliczSrednia(ArrayList<Double> data){

        if(data==null||data.size()==0)
            return 0.0;

        Double suma = 0.0;

        for(Double element : data)
            suma+=element;

        return suma/data.size();
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

        ArrayList<Double> data = new ArrayList<Double>();
        dodajDane(data);

        for(int i=0;i<data.size();i++)
            System.out.println(data.get(i));

        for(Double element : data){
            System.out.println(element);
        }

        Collections.sort(data);



        System.out.println("_____________________________");


        data.add(40.0);

        for(int i=0;i<data.size();i++)
            System.out.println(data.get(i));

        System.out.println("Maksymalna wartość: "+Collections.max(data));


        System.out.println("Średnia wynosi:"+obliczSrednia(data));
        //System.out.println("Mediana wynosi:"+obliczMedianę(data));



        //System.out.println("Średnia wynosi:"+obliczSrednia(data));
        //System.out.println("Mediana wynosi:"+obliczMedianę(data));

        //obliczMedianę(data);
    }
}

