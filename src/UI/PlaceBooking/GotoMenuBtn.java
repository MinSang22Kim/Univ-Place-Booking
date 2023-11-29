package UI.PlaceBooking;

import UI.DEFINE;
import UI.UIMng;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GotoMenuBtn extends JButton {
    final Point bookingPos = new Point(850,550);
    final Point area = new Point(100,50);
    public GotoMenuBtn()
    {
        setText("메뉴화면");
        setBounds(bookingPos.x, bookingPos.y, area.x, area.y);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIMng.getIns().showPanel(DEFINE.MENU_PANEL);
            }
        });
    }
}
