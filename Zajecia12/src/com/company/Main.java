package com.company;

import java.util.*;

public class Main {

    Data mData = new Data(100,0,1);

    private static void dodajDane(ArrayList<Double> data, long no){

        for(int i=0;i<no;i++)
            data.add(Generator.gen());
    }

    private static Double obliczSrednia(ArrayList<Double> data){

        if(data==null||data.size()==0)
            return 0.0;

        Double suma = 0.0;

        for(Double element : data)
            suma+=element;

        return suma/data.size();
    }

    private static Double obliczMedianę(ArrayList<Double> data){

        if(data.size()==1)
            return data.get(0);

        Collections.sort(data);

        Double mediana;

        if(data.size()/2.0==Math.round(data.size()/2.0)){
            mediana = (data.get((int)(data.size()/2.0)-1)+data.get((int)(data.size()/2.0)))/2.0;

        }else{
            mediana = data.get((int)(data.size()/2.0));
        }


        return mediana;
    }

    public static void wyswietlDane(ArrayList<Double> data){
        for(Double element : data){
            System.out.println(element);
        }
    }

    public static void main(String[] args) {

        ArrayList<Double> data = new ArrayList<Double>();
        dodajDane(data,10);

        //Collections.sort(data);

        wyswietlDane(data);

        System.out.println("Średnia wynosi:"+obliczSrednia(data));
        System.out.println("Mediana wynosi:"+obliczMedianę(data));

        data.add(50.0);




        Collections.sort(data, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if(o1<o2)
                    return 1;

                if(o1==o2)
                    return 0;

                if(o1>o2)
                    return -1;

                return 0;
            }
        });
        
        System.out.println("Po dodaniu 50 do tablicy:");

        wyswietlDane(data);

        System.out.println("Średnia wynosi:"+obliczSrednia(data));
        System.out.println("Mediana wynosi:"+obliczMedianę(data));
    }
}

