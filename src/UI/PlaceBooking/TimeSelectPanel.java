package UI.PlaceBooking;

import UI.DEFINE;
import UI.UIMng;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBounds(850,200, 80,160);

        startTimeLabel = new JLabel(DEFINE.STARTTIME_LEBEL);
        endTimeLabel = new JLabel(DEFINE.ENDTTIME_LABEL);

        startTimeLabel.setFont(UIMng.getIns().subFont);
        endTimeLabel.setFont(UIMng.getIns().subFont);

//        startTimeLabel.setBounds(startPos.x, startPos.y - area.y, area.x, area.y);
//        endTimeLabel.setBounds(endPos.x, endPos.y - area.y, area.x, area.y);


        startTimeComboBox = new JComboBox<>();
        endTimeComboBox = new JComboBox<>();

        startTimeComboBox.setOpaque(true);

        startTimeComboBox.setLayout(null);
        startTimeComboBox.setSize(area.x, area.y);
        startTimeComboBox.setFont(UIMng.getIns().subFont);

        endTimeComboBox.setLayout(null);
        endTimeComboBox.setSize(area.x, area.y);
        endTimeComboBox.setFont(UIMng.getIns().subFont);

        for(int i=0;i<24;i++)
        {
            startTimeComboBox.addItem(String.valueOf(i)+"시");
            endTimeComboBox.addItem(String.valueOf(i)+"시");
        }

        startTimeComboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox)e.getSource();
            String selectedItem = (String)cb.getSelectedItem();
            UIMng.getIns().startTime = Integer.valueOf(selectedItem.replace('시', ' ').trim());
            System.out.println(UIMng.getIns().startTime);
        }

    });

        endTimeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String selectedItem = (String)cb.getSelectedItem();
                UIMng.getIns().endTime = Integer.valueOf(selectedItem.replace('시', ' ').trim());
                System.out.println(UIMng.getIns().endTime);
            }

        });

        startTimeComboBox.setVisible(true);
        endTimeComboBox.setVisible(true);

        add(startTimeLabel);
        add(startTimeComboBox);
        add(endTimeLabel);
        add(endTimeComboBox);

    }
}
