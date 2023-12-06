package Booking;

import UI.UIMng;
import mgr.ProgramMng;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class BookingInfo {

    public User user;

    public String date;
    public int startHour;
    public int endHour;

    public BookingInfo(User user, String date, int startHour, int endHour) {
        this.user = user;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public String print() {
        String[] date_split = date.split("-");
        int year = Integer.parseInt(date_split[0]);
        int month = Integer.parseInt(date_split[1]);
        int day = Integer.parseInt(date_split[2]);
//        return String.format("\t예약 시간 : %d년 %d월 %d일 %d시~%d시 (예약자 : %s(%s))\n",
//                year, month, day, startHour, endHour, user.name, user.code);
        return String.format("%s/%s/%d-%d-%d/", user.name, user.code, year, month, day)+String.format("%02d~%02d", startHour, endHour);
    }

    public String printUser(String code) {
        User user = ProgramMng.getIns().findUser(code);
//        String[] date_split = date.split("-");
//        int year = Integer.parseInt(date_split[0]);
//        int month = Integer.parseInt(date_split[1]);
//        int day = Integer.parseInt(date_split[2]);
//        return String.format("\t예약 시간 : %d년 %d월 %d일 %d시~%d시 (예약자 : %s(%s))\n",
//                year, month, day, startHour, endHour, user.name, user.code);
        return String.format("%s/%s/%s/", user.name, user.code, date)+String.format("%02d~%02d", startHour, endHour);
    }


    public boolean dateEquals(BookingInfo info) {
        if(info.date.equals(date)){
            if(((startHour >= info.startHour && startHour < info.endHour )||
                    (endHour > info.startHour && endHour <= info.endHour)
            ))
                return false;
        }
        return true;
    }


    public boolean matches(String kwd) {

        if (user.code.equals(kwd))
            return true;
        return false;
    }

    public boolean matchUser(User user){
        if(user == this.user)
            return true;
        return false;
    }

}
