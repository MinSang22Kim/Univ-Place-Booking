package UI;

import UI.Framework.KGULogo;
import UI.LogIn.*;
import UI.PlaceBooking.*;
import mgr.ProgramMng;

import javax.swing.*;
import java.awt.*;

public class UIMng  implements Runnable{
    JFrame mainFrame;
    JPanel cardPanel;
    CardLayout cardLayout;

    PlaceBookingPanel placeBookingPanel;
    LogInPanel logInPanel;
    MenuPanel menuPanel;
    PlaceSelectPanel placeSelectPanel;
    SportSelectPanel sportSelectPanel;
    StudySelectPanel studySelectPanel;

    public String selectPlaceName;
    public String selectSheetName;
    public String selectDate;
    public int startTime = 0;
    public int endTime = 0;

    public KGULogo kguIcon;

    public final Font mainFont = new Font(DEFINE.NATURE_GOTHIC, Font.BOLD, 28);
    public final Font subFont = new Font(DEFINE.NATURE_GOTHIC, Font.PLAIN, 22);
    public final Font smallfont = new Font(DEFINE.NATURE_GOTHIC, Font.PLAIN, 15);
    public final Font logInFont = new Font(DEFINE.NATURE_GOTHIC, Font.PLAIN, 26);
    public final Font menuFont = new Font(DEFINE.NATURE_GOTHIC, Font.PLAIN, 18);

    public final Point SCREEN_SIZE = new Point(1000,700);

    private static UIMng instance;
    private UIMng() {
        ProgramMng.getInstance().run();
    }

    public static UIMng getInstance() {
        if (instance == null) {
            instance = new UIMng();
        }
        return instance;
    }

    public void Init()
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        mainFrame = new JFrame("학교 시설 예약 프로그램");
        mainFrame.setBounds(300,300, SCREEN_SIZE.x, SCREEN_SIZE.y);
        cardLayout = new CardLayout();
        cardPanel= new JPanel(cardLayout);
        cardPanel.setSize(SCREEN_SIZE.x,SCREEN_SIZE.y);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setResizable(false);

        mainFrame.getContentPane().add(cardPanel, BorderLayout.CENTER);
        kguIcon = new KGULogo("image/kgu_logo.png", 10, 10);

        InitPlaceBooking();
//        SheetSet("마루");
        cardLayout.show(cardPanel, DEFINE.LOGIN_PANEL);
        mainFrame.setVisible(true);
    }

    void InitPlaceBooking()
    {
        placeBookingPanel = new PlaceBookingPanel();
        logInPanel = new LogInPanel();
        menuPanel = new MenuPanel();
        placeSelectPanel = new PlaceSelectPanel();
        sportSelectPanel = new SportSelectPanel();
        studySelectPanel = new StudySelectPanel();

        cardPanel.add(logInPanel, DEFINE.LOGIN_PANEL);
        cardPanel.add(menuPanel, DEFINE.MENU_PANEL);
        cardPanel.add(placeSelectPanel, DEFINE.PLACE_SELECT_PANEL);
        cardPanel.add(sportSelectPanel, DEFINE.SPORT_SELECT_PANEL);
        cardPanel.add(studySelectPanel, DEFINE.STUDY_SELECT_PANEL);
        cardPanel.add(placeBookingPanel, DEFINE.SHEET_SELECT_PANEL);
    }

    public void showPanel(String name)
    {
        cardLayout.show(cardPanel, name);
    }

    public void SelectPlaceToBooking(String name)
    {
        showPanel(DEFINE.SHEET_SELECT_PANEL);
        SheetSet(name);
        kguIcon.setText("예약-"+name);
        selectPlaceName = name;
        System.out.println(name);
    }
    void SheetSet(String name)
    {
        placeBookingPanel.sheetSelectPanel.AllRemoveSheet();
        switch (name)
        {
            case "풋살장":
                placeBookingPanel.sheetSelectPanel.UpdateGrid(1,3);
                placeBookingPanel.sheetSelectPanel.AddSheet("A1", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("A2", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("B1", false);
                break;
            case "농구장":
                placeBookingPanel.sheetSelectPanel.UpdateGrid(3,2);
                placeBookingPanel.sheetSelectPanel.AddSheet("A1", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("A2", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("B1", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("B2", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("C1", false);
                break;
            case "축구장":
                placeBookingPanel.sheetSelectPanel.UpdateGrid(2,2);
                placeBookingPanel.sheetSelectPanel.AddSheet("A1", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("A2", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("B1", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("B2", false);
                break;
            case "족구장":
                placeBookingPanel.sheetSelectPanel.UpdateGrid(2,2);
                placeBookingPanel.sheetSelectPanel.AddSheet("A1", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("A2", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("B1", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("B2", false);
                break;
            case "테니스장":
                placeBookingPanel.sheetSelectPanel.UpdateGrid(2,2);
                placeBookingPanel.sheetSelectPanel.AddSheet("A1", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("A2", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("A3", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("A4", false);
                break;
            case "탁구장":
                placeBookingPanel.sheetSelectPanel.UpdateGrid(2,3);
                placeBookingPanel.sheetSelectPanel.AddSheet("A1", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("A2", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("A3", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("A4", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("A5", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("A6", false);
                break;
            case "팀프로젝트실":
                placeBookingPanel.sheetSelectPanel.UpdateGrid(4,4);
                placeBookingPanel.sheetSelectPanel.AddSheet("팀프A실", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("팀프B실", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("팀프C실", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("팀프D실", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("팀프E실", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("팀프F실", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("팀프G실", false);
                placeBookingPanel.sheetSelectPanel.AddSheet("팀프H실", false);
                break;
            case "아고라":
                placeBookingPanel.sheetSelectPanel.UpdateGrid(8,10);
                for(int i=0;i<8;i++)
                    for(int j=0;j<10;j++)
                        placeBookingPanel.sheetSelectPanel.AddSheet(String.format("%c%d",'A'+i,j+1), false);
                break;
            case "마루":
                placeBookingPanel.sheetSelectPanel.UpdateGrid(8,10);
                for(int i=0;i<8;i++)
                {
                    for(int j=0;j<10;j++)
                    {
                        if(i<5 && j>=5)
                            placeBookingPanel.sheetSelectPanel.AddSheet(String.format("%c%d",'A'+i,j+1), true);
                        else
                            placeBookingPanel.sheetSelectPanel.AddSheet(String.format("%c%d",'A'+i,j+1), false);
                    }
                }
                break;
        }
    }

    public Point getFontSize(FontMetrics font, String text)
    {
        FontMetrics metrics = font;
        String labelText = text;
        int textWidth = metrics.stringWidth(labelText) + 5;
        int textHeight = metrics.getHeight();

        return new Point(textWidth, textHeight);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new UIMng());
    }
    @Override
    public void run() {
        UIMng.getInstance().Init();
    }
}
