package UI.PlaceBooking;

import UI.Framework.PanelBase;
import UI.LogIn.PlaceSelectPanel;
import UI.UIMng;

import javax.swing.*;

public class PlaceBookingPanel extends PanelBase {
    SheetSelectPanel sheetSelectPanel;
    DaySelectPanel daySelectPanel;
    TimeSelectPanel timeSelectPanel;
    BookingBtn bookingBtn;
    public PlaceBookingPanel()
    {
        super();
        setLayout(null);
        setSize(UIMng.getInstance().SCREEN_SIZE.x,UIMng.getInstance().SCREEN_SIZE.y);

        sheetSelectPanel = new SheetSelectPanel();
        timeSelectPanel = new TimeSelectPanel();
        daySelectPanel = new DaySelectPanel();
        bookingBtn = new BookingBtn();

        add(daySelectPanel);
        add(sheetSelectPanel);
        add(timeSelectPanel);
        add(bookingBtn);
    }
}
