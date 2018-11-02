package generator;

public class Generator {
    public static double simple(){
        return Math.random();
    }
    public static double gen0(){
        return 0.5;
    }

    public static double gen1(){
        double number = Math.random();

        if(number>=0&&number<=0.2)
            return 0.1;
        if(number>=0.2&&number<=0.4)
            return 0.3;
        if(number>=0.4&&number<=0.6)
            return 0.5;
        if(number>=0.6&&number<=0.8)
            return 0.7;
        if(number>=0.8&&number<=1.0)
            return 0.9;

        return 0;
    }

    public static double gen2(){
        double number,y;

        do {
            number = Math.random();
            y = Math.random();
        }while(number<y);

        return number;

    }
}
