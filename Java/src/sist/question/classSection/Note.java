package sist.question.classSection;

public class Note {
    private String size;
    private String color;
    private int page;
    private String owner;
    private int price = 500;

    //setter, getter 구현



    public void setSize(String size) {
        if(size.equals("B3") || size.equals("A3") || size.equals("A4") || size.equals("A5") | size.equals("B4") || size.equals("B5")){
            this.size = size;
        } else System.out.println("잘못된 사이즈입니다.");
    }

    public void setColor(String color) {
        if(color.equals("검정색") || color.equals("흰색") || color.equals("노란색") || color.equals("파란색")){
            this.color = color;
        } else System.out.println("잘못된 색입니다.");
    }

    public void setPage(int page) {
        if(page>=10 && page<=200){
            this.page = page;
            price += (page-10) *10;
        }else System.out.println("잘못된 페이지입니다.");
    }


    public void setOwner(String owner) {
        if(owner.length()>=2 && owner.length()<=5){
            for(int i =0; i<owner.length(); i++){
                if(owner.charAt(i) > '가' && owner.charAt(i) < '힣'){
                    this.owner = owner;
                } else System.out.println("한글입력만 가능합니다.");
            }
        }else System.out.println("2~5자 이내로 입력이 가능합니다.");
    }

    public String info(){

        //size
        if(size.equals("A5")){
            price += 0;
        } else if (size.equals("A3")) {
            price += 400;
        } else if (size.equals("A4")) {
            price += 200;
        } else if (size.equals("B3")) {
            price += 500;
        }else if (size.equals("B4")) {
            price += 300;
        }else if (size.equals("B5")) {
            price += 100;
        }

        //color
        if(color.equals("흰색")){
            price += 0;
        }else if(color.equals("검정색")){
            price += 100;
        }else if(color.equals("노란색")){
            price += 200;
        }else if(color.equals("파란색")){
            price += 300;
        }

        //page
        String pageStatus = "";
        if(page>=10 && page<=50){
            pageStatus = "얇은";
        }else if(page>=51 && page<=100){
            pageStatus = "보통";
        }else if(page>=101 && page<=200){
            pageStatus = "두꺼운";
        }

        String output = "";
        output += "■■■■■■ 노트 정보 ■■■■■■\n";
        if(owner != null){
            output += String.format("소유자 : %s%n", owner);
            output += String.format("특성 : %s %s %s노트%n",color, pageStatus, size);
            output += String.format("가격 : %d %n", price);
        }else output += "주인 없는 노트\n";
        output += "■■■■■■■■■■■■■■■■■■■■■■";
        return output;
    }
}
