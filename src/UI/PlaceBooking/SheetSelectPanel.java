package UI.PlaceBooking;

import UI.UIMng;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SheetSelectPanel extends JPanel {
    ArrayList<JButton> sheets = new ArrayList<>();
    public SheetSelectPanel()
    {
        GridLayout layout = new GridLayout(4, 6);
        layout.setHgap(5);
        layout.setVgap(5);
        setLayout(layout);
        setSize(700,450);
        setLocation(80,150);

        int total = layout.getColumns() * layout.getRows();
        for(int i=0;i<total;i++)
        {
            JButton btn = new JButton("A"+String.valueOf(+i+1));

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    selectSheet(command);
                    selectSheetToColorChange(command);
                }
            });

            btn.setFont(UIMng.getInstance().subFont);
            btn.setBackground(Color.gray);
            btn.setOpaque(true);
            btn.setBorderPainted(false);
            add(btn);
            sheets.add(btn);
        }
    }
    void selectSheetToColorChange(String code)
    {
        for(var sheet : sheets)
        {
            if(sheet.getActionCommand().equals(code))
                sheet.setBackground(Color.orange);
            else
                sheet.setBackground(Color.gray);
        }
    }

    void selectSheet(String code)
    {
        System.out.println(code);
    }
}
