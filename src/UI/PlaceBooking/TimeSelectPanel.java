package UI.PlaceBooking;

import UI.DEFINE;
import UI.UIMng;

import javax.swing.*;
import java.awt.*;

public class TimeSelectPanel extends JPanel {
    JLabel startTimeLabel;
    JLabel endTimeLabel;
    JComboBox<String> startTimeComboBox;
    JComboBox<String> endTimeComboBox;

    final Point startPos = new Point(820,200);
    final Point endPos = new Point(820,300);
    final Point area = new Point(100,40);
    public TimeSelectPanel()
    {
        startTimeLabel = new JLabel(DEFINE.STARTTIME_LEBEL);
        endTimeLabel = new JLabel(DEFINE.ENDTTIME_LABEL);

        startTimeLabel.setFont(UIMng.getInstance().subFont);
        endTimeLabel.setFont(UIMng.getInstance().subFont);

        startTimeLabel.setBounds(startPos.x, startPos.y - area.y, area.x, area.y);
        endTimeLabel.setBounds(endPos.x, endPos.y - area.y, area.x, area.y);


        startTimeComboBox = new JComboBox<>();
        endTimeComboBox = new JComboBox<>();

        for(int i=0;i<24;i++)
        {
            startTimeComboBox.addItem(String.valueOf(i)+"시");
            endTimeComboBox.addItem(String.valueOf(i)+"시");
        }

        startTimeComboBox.setLayout(null);
        startTimeComboBox.setBounds(startPos.x, startPos.y, area.x, area.y);
        startTimeComboBox.setFont(UIMng.getInstance().subFont);

        endTimeComboBox.setLayout(null);
        endTimeComboBox.setBounds(endPos.x, endPos.y, area.x, area.y);
        endTimeComboBox.setFont(UIMng.getInstance().subFont);

        add(startTimeComboBox);
        add(endTimeComboBox);
        add(startTimeLabel);
        add(endTimeLabel);
    }
}
