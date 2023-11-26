package UI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class UIMng {
    JFrame mainFrame;
    JPanel mainPanel;   //cardPanel
    CardLayout cardLayout;

    JPanel sheetSelectPanel;
    JPanel daySelectionPanel; // 1행 5열의 그리드 레이아웃 패널
    JPanel sheetPanel; // 1행 5열의 그리드 레이아웃 패널

    JLabel startTimeLabel;
    JLabel endTimeLabel;
    JComboBox<String> startTimeComboBox;
    JComboBox<String> endTimeComboBox;

    JButton bookingBtn;

    ArrayList<JRadioButton> weekRadios = new ArrayList<>();
    ButtonGroup weekGroup = new ButtonGroup();

    ArrayList<JButton> sheets = new ArrayList<>();

    ImageLabel kguIcon;

    Font mainFont = new Font(DEFINE.NATURE_GOTHIC, Font.BOLD, 28);
    Font subFont = new Font(DEFINE.NATURE_GOTHIC, Font.PLAIN, 22);

    final Point startPos = new Point(820,200);
    final Point endPos = new Point(820,300);
    final Point bookingPos = new Point(820,350);
    final Point area = new Point(100,40);
    public final Point SCREEN_SIZE = new Point(1000,700);

    private static UIMng instance;
    private UIMng() {
    }

    public static UIMng getInstance() {
        if (instance == null) {
            instance = new UIMng();
        }
        return instance;
    }

    public void Init()
    {
        mainFrame = new JFrame();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setSize(SCREEN_SIZE.x,SCREEN_SIZE.y);

        sheetSelectPanel = new JPanel();
        sheetSelectPanel.setLayout(null);
        sheetSelectPanel.setSize(SCREEN_SIZE.x,SCREEN_SIZE.y);

        weekSelectInit();
        TimeComboBoxInit();
        sheetInit();

        bookingBtn = new JButton(DEFINE.BOOKING_BTN);
        bookingBtn.setBounds(bookingPos.x, bookingPos.y, area.x, area.y);

        mainPanel.add(sheetSelectPanel, DEFINE.SHEET_SELECT_PANEL);
        kguIcon = new ImageLabel("resource/kgu_logo.png", 10, 10);

        kguIcon.setFontAndText(mainFont, "예약 - K-AGORA");
        /////////////////////////////////////////////////////////////////////////

        sheetSelectPanel.add(kguIcon);
        sheetSelectPanel.add(daySelectionPanel);
        sheetSelectPanel.add(sheetPanel);
        sheetSelectPanel.add(bookingBtn);

        mainFrame.setSize(SCREEN_SIZE.x,SCREEN_SIZE.y);
        mainFrame.setLocation(300,300);
        mainFrame.setTitle("학교 시설 예약 프로그램");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);

        mainFrame.getContentPane().add(mainPanel);
    }

    void weekSelectInit() {
        daySelectionPanel = new JPanel(new GridLayout(1, 7));
        daySelectionPanel.setSize(700,40);
        daySelectionPanel.setLocation(150,65);

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
            btn.setFont(subFont);
            btn.setBackground(Color.gray);
            daySelectionPanel.add(btn);
            weekRadios.add(btn);
            weekGroup.add(btn);
        }
        weekRadios.get(0).setSelected(true);
    }

    void TimeComboBoxInit()
    {
        startTimeLabel = new JLabel(DEFINE.STARTTIME_LEBEL);
        endTimeLabel = new JLabel(DEFINE.ENDTTIME_LABEL);

        startTimeLabel.setFont(subFont);
        endTimeLabel.setFont(subFont);

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
        startTimeComboBox.setFont(subFont);

        endTimeComboBox.setLayout(null);
        endTimeComboBox.setBounds(endPos.x, endPos.y, area.x, area.y);
        endTimeComboBox.setFont(subFont);

        sheetSelectPanel.add(startTimeComboBox);
        sheetSelectPanel.add(endTimeComboBox);
        sheetSelectPanel.add(startTimeLabel);
        sheetSelectPanel.add(endTimeLabel);
    }

    void sheetInit()
    {
        GridLayout layout = new GridLayout(4, 6);
        sheetPanel = new JPanel(layout);
        sheetPanel.setSize(700,450);
        sheetPanel.setLocation(80,150);


        for(int i=0;i<layout.getColumns() * layout.getRows();i++)
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

            btn.setFont(subFont);
            btn.setBackground(Color.gray);
            sheetPanel.add(btn);
            sheets.add(btn);
        }

        //sheetPanel.setBackground(Color.black);
    }

    public Point getFontSize(FontMetrics font, String text)
    {
        FontMetrics metrics = font;
        String labelText = text;
        int textWidth = metrics.stringWidth(labelText) + 5;
        int textHeight = metrics.getHeight();

        return new Point(textWidth, textHeight);
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

    public static void main(String[] args) {
        UIMng.getInstance().Init();
    }
}
