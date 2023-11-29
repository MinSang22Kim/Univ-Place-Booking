package mgr;

import Booking.BookingInfo;
import Booking.User;

import javax.swing.*;
import java.util.ArrayList;

public class Sheet {
    public String name;
    public ArrayList<BookingInfo> bookingInfo = new ArrayList<>();

    public Sheet(String name) {
        this.name = name;
    }

    public void addBooking(User user, String date, int startHour, int endHour) {
        bookingInfo.add(new BookingInfo(user, date, startHour, endHour));
    }

    public boolean IsBooking() {
        return !bookingInfo.isEmpty();
    }

    public String print() {
        if(bookingInfo.isEmpty())
        {
            return (String.format("(%s) - 예약자가 없습니다.\n", name));
        }else {
            StringBuffer sb = new StringBuffer();
            String s = null;
            sb.append(String.format("(%s) - 예약자가 %d명 있습니다..\n", name, bookingInfo.size()));
            for(var booking : bookingInfo)
                sb.append(booking.print());
            s = sb.toString();
            return s;
        }
    }

    public void printUser(String name, String code) {
        if (!bookingInfo.isEmpty()) {
            for (var booking : bookingInfo) {
                System.out.format("\t%s(%s)  ", name, code);
                System.out.printf("[%s] ", this.name);
                booking.print();
            }
        }
    }

    public boolean matches(String kwd) {
        if (name.equals(kwd))
            return true;

        for (var booking : bookingInfo) {
            if (booking.matches(kwd))
                return true;
        }
        return false;
    }

    public BookingInfo findBookigInfo(User user, String date, int startHour, int endHour) {
        for (BookingInfo b : bookingInfo) {
            if (b.user.equals(user) && b.date.equals(date) && b.startHour == startHour && b.endHour == endHour)
                return b;
        }
        return null;
    }

}