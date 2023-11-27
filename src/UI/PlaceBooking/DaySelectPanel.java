package UI.PlaceBooking;

import UI.UIMng;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class DaySelectPanel extends JPanel {
    ArrayList<JRadioButton> weekRadios = new ArrayList<>();
    ButtonGroup weekGroup = new ButtonGroup();
    public DaySelectPanel()
    {
        setLayout(new GridLayout(1,7));
        setSize(700,40);
        setLocation(150,70);
        for (int i = 0; i < 7; i++)
        {
            JRadioButton btn = new JRadioButton(String.valueOf(i+1));
            btn.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange() == ItemEvent.DESELECTED)
                        btn.setBackground(Color.gray);
                    else if(e.getStateChange() == ItemEvent.SELECTED)
                        btn.setBackground(Color.orange);
                }

            });
            btn.setFont(UIMng.getInstance().subFont);
            btn.setBackground(Color.gray);
            add(btn);
            weekRadios.add(btn);
            weekGroup.add(btn);
        }
        weekRadios.get(0).setSelected(true);
    }
}
