package UI.Finder;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class BookingFinderPanel extends JPanel {
    JTable table;
    String[] columnNames = {"이름", "학번", "장소명","좌석번호", "대여시간"};

    public BookingFinderPanel()
    {
        Object[][] data = {
                {"김철수", "123456", "도서관","A1", "09:00 - 10:00"},
                {"이영희", "654321", "체육관","A1", "10:00 - 11:00"}};

        table = new JTable(data, columnNames);
        //table.setSize(1000,700);
        table.setCellSelectionEnabled(true);
        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        select.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String Data = null;
                int[] row = table.getSelectedRows();
                int[] col = table.getSelectedColumns();

                for(int i=0;i<row.length;i++)
                {
                    for(int j=0;j<col.length;j++)
                    {
                        Data = (String)table.getValueAt(row[i], col[j]);
                    }
                }
                //JOptionPane.showMessageDialog("선택된 테이블은 " + Data + "입니다.");
            }
        });

        JScrollPane sp = new JScrollPane(table);
        add(sp);
    }

}
