package sist.question.classSection;

public class Refrigerator {
    private Item[] items = new Item[100];
    private int index = 0;

    public void add(Item item) {
        items[index] = item;
        index++;
    }

    public Item get(String name) {
        for(int i = 0; i<index; i++){
            if(items[i].getName().equals(name)){
                for(int j = i; j<index; j++){
                    items[j] = items[j+1];
                    index--;
                }
                return items[i];
            }
        }

        return null;
    }

    public int count() {
        return index;
    }

    public void listItem() {
        for(int i = 0; i<index; i++){

            System.out.println(items[i].getName() + "(" + items[i].getExpiration() + ")");
        }
    }
}
