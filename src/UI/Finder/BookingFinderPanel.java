package UI.Finder;

import UI.DEFINE;
import UI.NonEditableTableModel;
import UI.UIMng;
import function.Check;
import mgr.ProgramMng;
import function.Booking;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookingFinderPanel extends JPanel {
    public static JTable table;
    NonEditableTableModel model;

    JButton menuButton = new JButton("메뉴화면");
    public BookingFinderPanel()
    {
        model = new NonEditableTableModel(new Object[]{"이름", "학번", "장소명", "좌석번호", "대여시간", "취소"}, 0);

        table = new JTable(model);

        table.getColumn("취소").setCellRenderer(new ButtonRenderer());
        table.getColumn("취소").setCellEditor(new ButtonEditor(new JCheckBox()));
        table.setLayout(null);
        table.setCellSelectionEnabled(true);
        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        JScrollPane sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(980,500));
        add(sp);


        menuButton.setBounds(625, 520, 150, 50);
        menuButton.setFont(UIMng.getIns().menuFont);
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIMng.getIns().showPanel(DEFINE.MENU_PANEL);
            }
        });
        add(menuButton);
    }

    public void UpdateTable()
    {
        ClearModel();
        ArrayList<String> s = Check.checkList(ProgramMng.getIns().user);
        for(var it : s)
            AddRow(it);
    }

    public void AddRow(String content)
    {
        String split[] = content.split("/");
        String name = split[2];
        String code = split[3];
        String placename = split[0];
        String sheetname = split[1];
        String time = split[4] + "/" + split[5];
        System.out.println(content);

        model.addRow(new Object[]{name, code, placename, sheetname, time, "취소"});
    }

    public void ClearModel()
    {
        model.setRowCount(0);
    }

    static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    static class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(e -> fireEditingStopped());
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                int response = JOptionPane.showConfirmDialog(null, "예약을 취소하시겠습니까?", "예약 취소", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    // 현재 편집 중인 셀의 행 인덱스를 가져옵니다.
                    int selectedRow = table.getEditingRow();
                    // 버튼 클릭 시 행 삭제
                    if (selectedRow >= 0) {
                        Object[] rowData = new Object[table.getColumnCount()];
                        for (int i = 0; i < table.getColumnCount(); i++) {
                            rowData[i] = table.getModel().getValueAt(selectedRow, i);
                        }

                        String date = rowData[4].toString().split("/")[0];
                        String time = rowData[4].toString().split("/")[1].replace('~', '-');

                        System.out.println(rowData[2].toString());
                        System.out.println(rowData[3].toString());
                        System.out.println(date);
                        System.out.println(time);

                        Booking.deleteBooking(rowData[2].toString(), rowData[3].toString(), date, time);
                    }
                    ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
                }
            }
            isPushed = false;
            return label;
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

}
