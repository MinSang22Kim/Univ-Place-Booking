package UI.PlaceBooking;

import UI.DEFINE;
import UI.UIMng;
import mgr.ProgramMng;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookingBtn extends JButton {
    final Point bookingPos = new Point(850,450);
    final Point area = new Point(100,50);
    public BookingBtn()
    {
        setText(DEFINE.BOOKING_BTN);
        setBounds(bookingPos.x, bookingPos.y, area.x, area.y);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String content = String.format("예약정보\n장소:%s(%s)\n예약날짜:%s %d시~%d시\n예약자:%s(%s)",
                        UIMng.getInstance().selectPlaceName, UIMng.getInstance().selectSheetName,
                        UIMng.getInstance().selectDate, UIMng.getInstance().startTime, UIMng.getInstance().endTime,
                        ProgramMng.getInstance().user.name, ProgramMng.getInstance().user.code);

                int response = JOptionPane.showConfirmDialog(null, content, "예약 정보 확인", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {

                } else {

                }
            }
        });
    }
}
