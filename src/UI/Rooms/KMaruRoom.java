package UI.Rooms;

import Booking.BookingInfo;
import Booking.User;
import mgr.Manageable;
import mgr.Sheet;

import java.util.ArrayList;
import java.util.Scanner;

public class KMaruRoom implements Manageable {
    int number;
    String code;
    String name;
    ArrayList<Sheet> sheets = new ArrayList<>();

    public KMaruRoom(int num)
    {
        number = num;
    }
    @Override
    public boolean matches(String kwd) {
        if(code.contains(kwd) || name.contains(kwd))
            return true;
        return false;
    }

    @Override
    public boolean bookingMatches(String kwd) {
        for(var sheet : sheets)
        {
            if(sheet.matches(kwd))
                sheet.print();
        }
        return false;
    }

    @Override
    public void print() {
        System.out.format("%s(%s)\n", name, code);
    }

    @Override
    public void bookingPrint() {
        System.out.format("%s(%s) 좌석별 예약 현황\n", name, code);
        for(var sheet : sheets)
            sheet.print();
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
        while (true){
            if(content.equals("0"))
                break;
            sheets.add(new Sheet(content));
            content = scanner.next();

        }
    }

    @Override
    public void bookingMatchesUser(String kwd){
        for(var sheet : sheets){
                if(sheet.matches(kwd)){
                   // System.out.format("\t%s(%s)  ", name, code);
                    sheet.printUser(name,code);
                }
        }
    }


    //true = 예약 가능, false = 예약 불가능
    @Override
    public boolean IsBooking(Sheet sheet, User user, String date, int startHour, int endHour) {
        ArrayList<BookingInfo> bookingInfos = sheet.bookingInfo;
        BookingInfo bookingInfo = new BookingInfo(null,date, startHour, endHour);
        for(var info : bookingInfos) {
            if (!info.dateEquals(bookingInfo))
                return false;
        }
        sheet.addBooking(user, date, startHour, endHour);
        return true;
    }

    @Override
    public Sheet getSheet(String name) {
        Sheet selectSheet = null;
        do {
            for(var sheet : sheets)
            {
                if(sheet.name.equals(name))
                    selectSheet = sheet;
            }
        }while (selectSheet == null);

        return selectSheet;
    }

    @Override
    public boolean IsNotSheet() {
        return false;
    }
}