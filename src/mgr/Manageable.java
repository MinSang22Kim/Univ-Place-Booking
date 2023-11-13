package mgr;

import Booking.User;

import java.util.Scanner;

public interface Manageable {

    boolean matches(String kwd);
    boolean bookingMatches(String kwd);
    void print();
    void bookingPrint();
    void bookingMatchesUser(String kwd);
    void sheetbookingPrint(String sheetname);
    void read(Scanner scanner);
    boolean IsBooking(Sheet sheet, User user, String date, int startHour, int endHour);

    Sheet getSheet(String name);
    boolean IsNotSheet();
}
