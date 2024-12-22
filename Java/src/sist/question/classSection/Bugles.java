package sist.question.classSection;

import java.util.Calendar;

public class Bugles {
    private int price;
    private int weight;
    private Calendar creationTime;
    private int expiration;

    //getter, setter 구현
    public void setWeight(int weight) {
        if(weight == 300 || weight == 500 || weight == 850){
            this.weight = weight;
        }else System.out.println("잘못된 용량입니다.");
    }

    public int getPrice() {
        if(weight==300){
            price = 850;
            expiration = 7;
        }else if(weight==500){
            price = 1200;
            expiration = 10;
        }else if(weight==850){
            price = 1950;
            expiration = 15;
        }
        return price;
    }


    public void setCreationTime(String date) {
        Calendar c = Calendar.getInstance();

    }

    public int getExpiration() {
        return expiration;
    }

    public void eat() {
        String output = "";
        output += String.format("%,d원%n", price);
        output += String.format("%d일 남았습니다.");
    }
}
