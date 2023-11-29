package UI.PlaceBooking;

import UI.UIMng;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SheetSelectPanel extends JPanel {
    ArrayList<JButton> sheets = new ArrayList<>();
    GridLayout layout;
    public SheetSelectPanel()
    {
        //UpdateGrid(4, 6);
        //UpdateSheet("아고라");
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

    public void AllRemoveSheet()
    {
        sheets.clear();
        removeAll();

        revalidate();
        repaint();
    }

    public void UpdateGrid(int row, int col)
    {
        layout = new GridLayout(row, col);
        layout.setHgap(5);
        layout.setVgap(5);
        setLayout(layout);
        setSize(780,500);
        setLocation(50,140);
    }

    public void AddSheet(String sheet, String placename, boolean IsNull)
    {
        if(IsNull)
        {
            JLabel label = new JLabel();
            add(label);
        }else {
            JButton btn = new JButton(sheet);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    selectSheet(command, btn.getName(), e);
                }
            });

            btn.setName(placename);
            btn.setFont(UIMng.getIns().subFont);
            btn.setBackground(Color.gray);
            btn.setOpaque(true);
            btn.setBorderPainted(false);
            add(btn);
            sheets.add(btn);
        }
    }

    void selectSheet(String sheet, String placename, ActionEvent cmd)
    {
        selectSheetToColorChange(sheet);
        UIMng.getIns().selectPlaceName = placename;
        UIMng.getIns().selectSheetName = sheet;
    }
}
