package Fields;

import Booking.BookingInfo;
import Booking.User;
import mgr.Manageable;
import mgr.Sheet;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FootVolleyballField implements Manageable {
    int number;
    String code;
    String name;
    int count;
    ArrayList<Sheet> sheets = new ArrayList<>();

    public FootVolleyballField(int num) {
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
            if (sheet.matches(kwd)) {
                sheet.print();
                return true;
            }
        }
        return false;
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

    @Override
    public void print() {
        System.out.format("%s(%s) 수용인원 : %s명\n", name, code, count);
    }

    @Override
    public String bookingPrint() {
        StringBuffer sb = new StringBuffer();
        String s = null;
        sb.append(String.format("%s(%s) 구역별 예약 현황\n", name, code));
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
        count = scanner.nextInt();
        String content = scanner.next();
        while (true) {
            if (content.equals("0"))
                break;
            sheets.add(new Sheet(content));
            content = scanner.next();

        }
    }

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
