package Booking;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class BookingInfo {

    User user;

    String date;
    int startHour;
    int endHour;
    public BookingInfo(User user, String date, int startHour, int endHour)
    {
        this.user = user;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public void print()
    {
        String[] date_split = date.split("-");
        int year = Integer.parseInt(date_split[0]);
        int month = Integer.parseInt(date_split[1]);
        int day = Integer.parseInt(date_split[2]);
        System.out.format("\t예약 시간 : %d년 %d월 %d일 %d시~%d시 (예약자 : %s(%s))\n",
                year, month, day, startHour, endHour, user.name, user.code);
    }

    public boolean dateEquals(BookingInfo info)
    {
        boolean date_equal = !info.date.equals(date);
        boolean time_equal = endHour <= info.startHour || startHour >= info.endHour;

        return date_equal && time_equal;
    }


    public boolean matches(String kwd)
    {
        if(user.name.contains(kwd))
            return true;
        else if(user.code.contains(kwd))
            return true;
        return false;
    }

}
