package UI.PlaceBooking;

import UI.DEFINE;

import javax.swing.*;
import java.awt.*;

public class BookingBtn extends JButton {
    final Point bookingPos = new Point(820,350);
    final Point area = new Point(100,50);
    public BookingBtn()
    {
        setText(DEFINE.BOOKING_BTN);
        setBounds(bookingPos.x, bookingPos.y, area.x, area.y);
    }

}
