package sist.question.collectionSection;

import java.util.Arrays;

public class MyQueue {
    private String[] list = new String[3];
    int index = 0;

    public boolean add(String value){
        for(int i = 0 ; i<list.length; i++){
            if(list[list.length-1] != null){
                String[] newList = new String[list.length*2];
                for(int j = 0; j<list.length; j++){
                    newList[j] = list[j];
                }
                list = newList;
            }else if(list[i] == null){
                list[i] = value;
                return true;
            }
        }
        return false;
    }

    public String poll(){
        String pollString = list[0];
        for(int i = 0; i<list.length-1; i++){
           list[i] = list[i+1];
        }
        return pollString;
    }

    public int size(){
        for(int i = 0; i< list.length; i++){
            if(list[i] == null){
                index = i;
                break;
            }
        }
        return index;
    }

    public String peek(){
        return list[0];
    }

    public void clear(){
        list = new String[3];
    }

    public void trimToSize(){
        String[] newArr = new String[index+1];
        for(int i =0; i<index+1; i++){
            newArr[i] = list[i];
        }
    }
}
