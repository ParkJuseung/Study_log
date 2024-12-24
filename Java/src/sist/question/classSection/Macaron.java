package sist.question.classSection;

import java.util.Random;

public class Macaron {

    private int size;
    private String color;
    private int thickness;
    private final String[] colorArr = {"red", "blue", "yellow", "white", "pink", "purple","green", "black"};
    public boolean isPass;

    Random random = new Random();

    public int getSize() {
        return size;
    }

    public void setSize() {
        this.size = random.nextInt(5, 15);
    }

    public String getColor() {
        return color;
    }

    public void setColor() {
        int i = random.nextInt(colorArr.length);
        this.color = colorArr[i];
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness() {
        this.thickness = random.nextInt(1, 20);
    }
}
