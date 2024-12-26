package sist.question.classSection;

public class Barista {

    public Espresso makeEspresso(int bean) {
        Espresso espresso = new Espresso();
        espresso.setBean(bean);
        return espresso;
    }

    public Espresso[] makeEspressoes(int bean, int count){
        Espresso[] espresso = new Espresso[count];
        for(int i = 0; i<count; i++){
            Espresso.setBean(bean);
        }
        return espresso;
    }

    public Latte makeLatte(int bean, int milk) {
        Latte latte = new Latte();
        return latte;
    }

    public Latte[] makeLattes(int bean, int milk, int count) {
        Latte[] latte = new Latte[count];
        for(int i =0; i<count; i++){
            Latte.setLatte(bean, milk);
        }
        return latte;
    }

    public Americano makeAmericano(int bean, int water, int ice) {
        Americano americano = new Americano();
        return americano;
    }


    public Americano[] makeAmericanos(int bean, int water, int ice, int count) {
        Americano[] americano = new Americano[count];
        return americano;
    }

    public void result() {
    }
}

class Coffee{
    static int bean;
    static int water;
    static int ice;
    static int milk;
    static int beanunitPrice;
    static int waterUnitPrice;
    static int iceUnitPrice;
    static int milkUnitPrice;
    static int beanTotalPrice;
    static int waterTotalPrice;
    static int iceTotalPrice;
    static int milkTotalPrice;
    static int americno;
    static int latte;
    static int espresso;



}

class Espresso{
    static int bean;

    public static void setBean(int bean) {
        Espresso.bean = bean;
    }

    public void drink() {
    }
}

class Latte{
    static int bean;
    static int milk;

    public static void setLatte(int bean, int milk){
        Latte.bean = bean;
        Latte.milk = milk;
    }

    public void drink() {
    }
}

class Americano{

    public void drink() {
    }
}

