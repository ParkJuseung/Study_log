package sist.question.classSection;

import java.util.Arrays;

public class MyArrayList {

    private String[] list;
    private int index; // 역할 : 현재 데이터가 들어갈 방번호

    MyArrayList() {
        this.list = new String[4];
        this.index = 0;
    }

    public void add(String str) {
        if(checkLength()){
            doubleList();
        }
        list[this.index] = str;
        this.index++;
    }

    private boolean checkLength() {
        if(this.list.length == this.index){
            return true;
        }
        return false;
    }
    private void doubleList(){

        String[] temp = new String[list.length*2];
        for(int i = 0; i < list.length; i++){
            temp[i] = list[i];
        }
        this.list = temp; // 배열 교체
    }


    public String get(int index){
        return list[index];
    }

    public int size() {
        return index;
    }

    @Override
    public String toString() {
        String temp = "";
        temp += "\r\n";
        temp += String.format("length : %d\n",this.list.length);
        temp += String.format("index : %d\n",this.index);
        temp += "[\r\n";
        for(int i = 0; i < this.list.length; i++) {
            temp += String.format("\t%d : %s\r\n", i, this.list[i]);
        }
        temp += "]";
        temp += "\r\n";

        return temp;


//        return "MyArrayList{" +
//                "list=" + Arrays.toString(list) +
//                ", index=" + index +
//                '}';
    }

}
