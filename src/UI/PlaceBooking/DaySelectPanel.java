package UI.PlaceBooking;

import UI.UIMng;
import mgr.ProgramMng;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class DaySelectPanel extends JPanel {
    ArrayList<JRadioButton> weekRadios = new ArrayList<>();
    ButtonGroup weekGroup = new ButtonGroup();
    public DaySelectPanel()
    {
        GridLayout gridLayout = new GridLayout(1,7);
        gridLayout.setHgap(5);
        setLayout(gridLayout);
        setSize(900,40);
        setLocation(50,90);
        UIMng.getInstance().selectDate = ProgramMng.getInstance().weekDates.get(0);
        for (int i = 0; i < 7; i++)
        {
            //날짜 선택 버튼 내용 텍스트 넣는 곳
            JRadioButton btn = new JRadioButton(ProgramMng.getInstance().weekDates.get(i));
            btn.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange() == ItemEvent.DESELECTED)
                        btn.setBackground(Color.gray);
                    else if(e.getStateChange() == ItemEvent.SELECTED)
                        btn.setBackground(Color.orange);
                }

            });

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    UIMng.getInstance().selectDate = command;
                }
            });
            btn.setFont(UIMng.getInstance().smallfont);
            btn.setBackground(Color.gray);
            btn.setOpaque(true);
            add(btn);
            weekRadios.add(btn);
            weekGroup.add(btn);
        }
        weekRadios.get(0).setSelected(true);
    }
}
