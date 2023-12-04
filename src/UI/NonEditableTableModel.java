package UI;

import javax.swing.table.DefaultTableModel;

public class NonEditableTableModel extends DefaultTableModel {

    public NonEditableTableModel(Object[] columnNames, int rowcunt) {
        super(columnNames, rowcunt);
    }
    public NonEditableTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    public NonEditableTableModel() {
        super();
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        // 모든 셀을 편집 불가능하게 설정
        return column == getColumnCount() - 1;
    }
}
