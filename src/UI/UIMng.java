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
    JPanel mainPanel;   //cardPanel
    CardLayout cardLayout;

    JPanel placeBookingPanel;

    SheetSelectPanel sheetSelectPanel;
    DaySelectPanel daySelectPanel;
    TimeSelectPanel timeSelectPanel;
    BookingBtn bookingBtn;

    ImageLabel kguIcon;

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
        mainFrame = new JFrame();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setSize(SCREEN_SIZE.x,SCREEN_SIZE.y);
        mainFrame.setSize(SCREEN_SIZE.x,SCREEN_SIZE.y);
        mainFrame.setLocation(300,300);
        mainFrame.setTitle("학교 시설 예약 프로그램");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.getContentPane().add(mainPanel);

        sheetSelectPanel = new SheetSelectPanel();
        timeSelectPanel = new TimeSelectPanel();
        daySelectPanel = new DaySelectPanel();
        bookingBtn = new BookingBtn();

        InitPlaceBooking();
        IconLoad();
    }

    void InitPlaceBooking()
    {
        placeBookingPanel = new JPanel();
        placeBookingPanel.setLayout(null);
        placeBookingPanel.setSize(SCREEN_SIZE.x,SCREEN_SIZE.y);

        placeBookingPanel.add(daySelectPanel);
        placeBookingPanel.add(sheetSelectPanel);
        placeBookingPanel.add(timeSelectPanel);
        placeBookingPanel.add(bookingBtn);
        mainPanel.add(placeBookingPanel, DEFINE.SHEET_SELECT_PANEL);
    }

    void IconLoad()
    {
        kguIcon = new ImageLabel("resource/kgu_logo.png", 10, 10);
        kguIcon.setFontAndText(mainFont, "예약 - K-AGORA");

        mainPanel.add(kguIcon);
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
