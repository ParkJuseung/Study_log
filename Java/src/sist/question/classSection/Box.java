package sist.question.classSection;

public class Box {
    private Macaron[] list = new Macaron[10];
    int passCount = 0;
    int failCount = 0;

    public void cook() {
        for (int i = 0; i < list.length; i++) {
            list[i] = new Macaron();
            list[i].setSize();
            list[i].setColor();
            list[i].setThickness();
        }
    }

    public void check() {
        for(int i = 0; i<list.length; i++) {
            if(list[i].getSize() >= 8
                    && list[i].getSize() <= 14
                    && !list[i].getColor().equals("black")
                    && list[i].getThickness() >=3
                    && list[i].getThickness() <=18) {
                passCount++;
                list[i].isPass = true;
            }
            else {
                failCount++;
                list[i].isPass = false;
            }
        }

        System.out.println("Pass Count: " + passCount);
        System.out.println("Fail Count: " + failCount);
    }

    public void list() {
        String output = "";
        for (int i = 0; i < list.length; i++) {
            System.out.printf("%d번 마카롱 : %dcm(%s, %dmm) : %s\n",i,list[i].getSize(), list[i].getColor(), list[i].getThickness(), list[i].isPass ? "합격" : "불합격");

        }
    }
}
