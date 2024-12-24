package sist.question.classSection;

import java.util.Calendar;

public class Item {
    Calendar calendar;
    private String name;
    private String expiration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
}
