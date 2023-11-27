package UI;

import UI.PlaceBooking.BookingBtn;
import UI.PlaceBooking.DaySelectPanel;
import UI.PlaceBooking.SheetSelectPanel;
import UI.PlaceBooking.TimeSelectPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageConsumer;
import java.sql.Time;

public class UIMng {
    JFrame mainFrame;
    JPanel cardPanel;   //cardPanel
    CardLayout cardLayout;

    JPanel placeBookingPanel;

    SheetSelectPanel sheetSelectPanel;
    DaySelectPanel daySelectPanel;
    TimeSelectPanel timeSelectPanel;
    BookingBtn bookingBtn;

    KGULogo kguIcon;

    public final Font mainFont = new Font(DEFINE.NATURE_GOTHIC, Font.BOLD, 28);
    public final Font subFont = new Font(DEFINE.NATURE_GOTHIC, Font.PLAIN, 22);

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
        mainFrame = new JFrame("학교 시설 예약 프로그램");
        mainFrame.setBounds(300,300, SCREEN_SIZE.x, SCREEN_SIZE.y);
        cardLayout = new CardLayout();
        cardPanel= new JPanel(cardLayout);
        cardPanel.setSize(SCREEN_SIZE.x,SCREEN_SIZE.y);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setResizable(false);

        mainFrame.add(new KGULogo("resource/kgu_logo.png", 10, 10));
        mainFrame.getContentPane().add(cardPanel, BorderLayout.CENTER);

        InitPlaceBooking();
        cardLayout.show(cardPanel, DEFINE.SHEET_SELECT_PANEL);
        mainFrame.setVisible(true);
    }

    void InitPlaceBooking()
    {
        placeBookingPanel = new JPanel();
        placeBookingPanel.setLayout(null);
        placeBookingPanel.setSize(SCREEN_SIZE.x,SCREEN_SIZE.y);

        sheetSelectPanel = new SheetSelectPanel();
        timeSelectPanel = new TimeSelectPanel();
        daySelectPanel = new DaySelectPanel();
        bookingBtn = new BookingBtn();

        placeBookingPanel.add(daySelectPanel);
        placeBookingPanel.add(sheetSelectPanel);
        placeBookingPanel.add(timeSelectPanel);
        placeBookingPanel.add(bookingBtn);

        cardPanel.add(placeBookingPanel, DEFINE.SHEET_SELECT_PANEL);
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
        UIMng.getInstance().Init();
    }
}
