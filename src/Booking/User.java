package Booking;

import mgr.Sheet;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    public String code;
    public String name;
    public String password;
    public ArrayList<BookingInfo> bookingList = new ArrayList<>();

    public void read(Scanner scanner) {
        code = scanner.next();
        name = scanner.next();
        password = scanner.next();
    }

    public boolean matches(String code, String password) {
        if (this.code.equals(code) && this.password.equals(password))
            return true;
        return false;
    }

    public boolean login(String code, String password) {
        if (matches(code, password))
            return true;
        return false;
    }

    public boolean matches(String code) {
        if (this.code.equals(code))
            return true;
        return false;
    }

    public boolean check(String date, int startHour, int endHour) {
        for (BookingInfo s : bookingList) {
            if (s.date.equals(date) && s.startHour == startHour && s.endHour == endHour)
                return true;
        }
        return false;
    }

    public void print() {
        for (BookingInfo b : bookingList) {

        }
    }
}