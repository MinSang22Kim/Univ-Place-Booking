package UI.PlaceBooking;

import UI.DEFINE;
import UI.UIMng;
import function.Booking;
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
                        UIMng.getIns().selectPlaceName, UIMng.getIns().selectSheetName,
                        UIMng.getIns().selectDate, UIMng.getIns().startTime, UIMng.getIns().endTime,
                        ProgramMng.getIns().user.name, ProgramMng.getIns().user.code);

                int response = JOptionPane.showConfirmDialog(null, content, "예약 정보 확인", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    boolean result = Booking.possibleBooking(UIMng.getIns().selectPlaceName, UIMng.getIns().selectSheetName,
                            UIMng.getIns().selectDate, String.format("%02d-%02d", UIMng.getIns().startTime, UIMng.getIns().endTime));

                    if(result)
                    {
                        Booking.booking(UIMng.getIns().selectPlaceName, UIMng.getIns().selectSheetName,
                                UIMng.getIns().selectDate, String.format("%02d-%02d", UIMng.getIns().startTime, UIMng.getIns().endTime));
                        JOptionPane.showMessageDialog(null, "예약이 완료되었습니다..");
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "해당 시간에 이미 예약자가 있어 다른 시간대 또는 장소를 바꿔서 다시 시도하세요.");
                    }
                }
                else
                {

                }
            }
        });
    }
}
