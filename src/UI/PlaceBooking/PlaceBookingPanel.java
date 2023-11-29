package UI.PlaceBooking;

import UI.UIMng;

import javax.swing.*;

public class PlaceBookingPanel extends JPanel {
    public SheetSelectPanel sheetSelectPanel;
    DaySelectPanel daySelectPanel;
    TimeSelectPanel timeSelectPanel;
    BookingBtn bookingBtn;
    GotoMenuBtn gotoMenuBtn;
    public PlaceBookingPanel()
    {
        setLayout(null);
        setSize(UIMng.getIns().SCREEN_SIZE.x,UIMng.getIns().SCREEN_SIZE.y);

        sheetSelectPanel = new SheetSelectPanel();
        timeSelectPanel = new TimeSelectPanel();
        daySelectPanel = new DaySelectPanel();
        bookingBtn = new BookingBtn();
        gotoMenuBtn = new GotoMenuBtn();

        add(daySelectPanel);
        add(sheetSelectPanel);
        add(timeSelectPanel);
        add(bookingBtn);
        add(gotoMenuBtn);
        add(UIMng.getIns().kguIcon);
    }
}
