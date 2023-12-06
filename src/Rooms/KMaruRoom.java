package Rooms;

import Booking.BookingInfo;
import Booking.User;
import mgr.Manageable;
import mgr.Sheet;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class KMaruRoom implements Manageable {
    int number;
    String code;
    String name;
    ArrayList<Sheet> sheets = new ArrayList<>();

    public KMaruRoom(int num) {
        number = num;
    }

    @Override
    public boolean matches(String kwd) {
        if (code.contains(kwd) || name.contains(kwd))
            return true;
        return false;
    }

    @Override
    public boolean bookingMatches(String kwd) {
        for (var sheet : sheets) {
            if (sheet.matches(kwd))
                sheet.print();
        }
        return false;
    }

    @Override
    public void print() {
        System.out.format("%s(%s)\n", name, code);
    }

    @Override
    public String bookingPrint() {
        StringBuffer sb = new StringBuffer();
        String s = null;
        sb.append(String.format("%s(%s) 좌석별 예약 현황\n", name, code));
        for (var sheet : sheets)
            sb.append(sheet.print());
        s = sb.toString();
        return s;
    }

    @Override
    public void sheetbookingPrint(String sheetname) {
        Sheet sheet = getSheet(sheetname);
        sheet.print();
    }

    @Override
    public void read(Scanner scanner) {
        code = scanner.next();
        name = scanner.next();
        String content = scanner.next();
        while (true) {
            if (content.equals("0"))
                break;
            sheets.add(new Sheet(content));
            content = scanner.next();

        }
    }

    @Override
    public String bookingMatchesUser(String kwd) {
        StringBuffer sb = new StringBuffer();
        String s = null;
        for (var sheet : sheets) {
            if (sheet.matches(kwd)) {
                sb.append(sheet.printUser(name, kwd));
                sb.append("@");
            }
        }
        s = sb.toString();
        return s;
    }


    //true = 예약 가능, false = 예약 불가능
    @Override
    public boolean IsBooking(Sheet sheet, User user, String date, int startHour, int endHour) {
        ArrayList<BookingInfo> bookingInfos = sheet.bookingInfo;
        BookingInfo bookingInfo = new BookingInfo(null, date, startHour, endHour);
        for (var info : bookingInfos) {
            if (!info.dateEquals(bookingInfo))
                return false;
        }
        return true;
    }

    @Override
    public boolean addBooking(Sheet sheet, User user, String date, int startHour, int endHour) {
        ArrayList<BookingInfo> bookingInfos = sheet.bookingInfo;
        BookingInfo bookingInfo = new BookingInfo(null, date, startHour, endHour);
        for (var info : bookingInfos) {
            if (!info.dateEquals(bookingInfo))
                return false;
        }
        sheet.addBooking(user, date, startHour, endHour);
        return true;
    }

    @Override
    public Sheet getSheet(String name) {
        Sheet selectSheet = null;
        for (var sheet : sheets) {
            if (sheet.name.equals(name)) {
                selectSheet = sheet;
                return selectSheet;
            }
        }
        return null;
    }

    @Override
    public boolean IsNotSheet() {
        return false;
    }

}