package UI.LogIn;

import UI.DEFINE;
import UI.Framework.PanelBase;
import UI.UIMng;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends PanelBase {
    JLabel welcomeLabel = new JLabel(new ImageIcon("./image/Welcome.jpg"));
    JButton reservationButton = new JButton("예약하기");
    JButton searchButton = new JButton("조회하기");
    public MenuPanel()
    {
        super();
        setLayout(null);

        welcomeLabel.setBounds(150, 100, 700, 200);
        add(welcomeLabel);


        reservationButton.setBounds(250, 520, 150, 50);
        reservationButton.setFont(UIMng.getInstance().menuFont);
        reservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIMng.getInstance().showPanel(DEFINE.PLACE_SELECT_PANEL);
            }
        });
        add(reservationButton);


        searchButton.setBounds(643, 520, 150, 50);
        searchButton.setFont(UIMng.getInstance().menuFont);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("검색 버튼 클릭");
            }
        });
        add(searchButton);
    }

}
