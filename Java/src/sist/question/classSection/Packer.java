package sist.question.classSection;

public class Packer {
    static int pencilCount;
    static int earaserCount;
    static int ballPointPenCount;
    static int rulerCount;

    //연필을 검수하고 포장
    void packing(Pencil pencil){
        pencil.info();
        pencilCount++;
    }

    //지우개
    void packing(Eraser eraser){
        eraser.info();
        earaserCount++;
    }

    //볼펨 검수 및 포장
    void packing(BallPointPen ballPointPen){
        ballPointPen.info();
        ballPointPenCount++;
    }

    //자 검수 및 포장
    void packing(Ruler ruler){
        ruler.info();
        rulerCount++;
    }

    //포장한 내용물 개수 출력
    //0 : 모든 내용물
    //1 : 연필
    //2 : 지우개
    //3 : 볼펜
    //4 : 자
    void countPacking(int type){
        System.out.println("==============");
        System.out.println("포장결과");
        System.out.println("==============");
        switch (type){
            case 0 :
                System.out.println("연필" + pencilCount + "회");
                System.out.println("지우개" + earaserCount + "회");
                System.out.println("볼펜" + ballPointPenCount + "회");
                System.out.println("자" + rulerCount + "회");
                break;
            case 1 :
                System.out.println("연필" + pencilCount + "회");
                break;
            case 2 :
                System.out.println("지우개" + earaserCount + "회");
                break;
            case 3 :
                System.out.println("볼펜" + ballPointPenCount + "회");
                break;
            case 4 :
                System.out.println("자" + rulerCount + "회");
                break;
        }
    }
}

class Pencil{
    String hardness;

    public void setHardness(String hardness) {
        this.hardness = hardness;
    }

    String info(){
        String pencilInfo = String.format("%s 진하기 연필입니다.", hardness);
        return pencilInfo;
    }
}

class Eraser{
    String size;

    public void setSize(String size) {
        this.size = size;
    }

    String info(){
        String eraserInfo = String.format("%s 사이즈 지우개입니다.", size);
        return eraserInfo;
    }
}

class BallPointPen{
    double thickness;
    String color;


    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public void setColor(String color) {
        this.color = color;
    }

    String info(){
        String ballPointPenInfo = String.format("%s 색상 %fmm 볼펜입니다.", color, thickness);
        return ballPointPenInfo;
    }
}

class Ruler{
    int length;
    String shape;

    public void setLength(int length) {
        this.length = length;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    String info(){
        String rulerInfo = String.format("%dcm %s입니다.", length, shape);
        return rulerInfo;
    }
}