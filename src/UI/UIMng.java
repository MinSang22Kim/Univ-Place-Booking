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

    public KGULogo kguIcon;

    public final Font mainFont = new Font(DEFINE.NATURE_GOTHIC, Font.BOLD, 28);
    public final Font subFont = new Font(DEFINE.NATURE_GOTHIC, Font.PLAIN, 22);
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
            UIManager.setLookAndFeel("javax.swing.plaf.metal");
        }catch (Exception e)
        {
            System.out.println(e);
        }

        mainFrame = new JFrame("학교 시설 예약 프로그램");
        mainFrame.setBounds(300,300, SCREEN_SIZE.x, SCREEN_SIZE.y);
        cardLayout = new CardLayout();
        cardPanel= new JPanel(cardLayout);
        cardPanel.setSize(SCREEN_SIZE.x,SCREEN_SIZE.y);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setResizable(false);

        kguIcon = new KGULogo("image/kgu_logo.png", 10, 10);

        mainFrame.getContentPane().add(cardPanel, BorderLayout.CENTER);

        InitPlaceBooking();

        cardLayout.show(cardPanel, DEFINE.SHEET_SELECT_PANEL);
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
        kguIcon.setText("예약-"+name);
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
