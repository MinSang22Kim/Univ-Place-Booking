package Booking;

import java.util.ArrayList;

public class User {
    String code;
    String name;

    public ArrayList<BookingInfo> bookingList = new ArrayList<>();

    public User(String code, String name)
    {
        this.code = code;
        this.name = name;
    }

    public boolean matches(String code,String name){
        if(this.code.equals(code)&&this.name.equals(name))
            return true;
        return false;
    }

    public boolean matches(String code){
        if(this.code.equals(code))
            return true;
        return false;
    }

    public boolean check(String date, int starthour, int endhour){
        for(BookingInfo s : bookingList){
            if(s.date.equals(date)&&s.startHour == starthour&&s.endHour == endhour)
                return true;
        }
        return false;
    }

    public void print(){
        for(BookingInfo b : bookingList){

        }
    }
}