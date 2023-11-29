package UI.LogIn;

import UI.UIMng;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudySelectPanel extends JPanel {
    JButton buttonA = new JButton("팀 프로젝트실");
    JButton buttonB = new JButton("K-아고라");
    JButton buttonC = new JButton("K-마루");
    JLabel ALabel = new JLabel("");
    JLabel BLabel = new JLabel("");
    JLabel CLabel = new JLabel("");
    public StudySelectPanel()
    {
        setLayout(null);

        buttonA.setName("팀프로젝트실");
        buttonB.setName("아고라");
        buttonC.setName("마루");

        buttonA.setBounds(119, 463, 150, 50);
        buttonA.setFont(UIMng.getInstance().menuFont);
        buttonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIMng.getInstance().SelectPlaceToBooking(buttonA.getName());
            }
        });
        add(buttonA);

        buttonB.setBounds(418, 463, 150, 50);
        buttonB.setFont(UIMng.getInstance().menuFont);
        buttonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIMng.getInstance().SelectPlaceToBooking(buttonB.getName());
            }
        });
        add(buttonB);

        buttonC.setBounds(725, 463, 150, 50);
        buttonC.setFont(UIMng.getInstance().menuFont);
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIMng.getInstance().SelectPlaceToBooking(buttonC.getName());
            }
        });
        add(buttonC);

        ALabel.setIcon(new ImageIcon(".image/A.png"));
        ALabel.setBounds(55, 190, 271, 188);
        add(ALabel);

        BLabel.setIcon(new ImageIcon("./image/B.png"));
        BLabel.setBounds(354, 190, 271, 188);
        add(BLabel);

        CLabel.setIcon(new ImageIcon("./image/C.png"));
        CLabel.setBounds(657, 190, 276, 197);
        add(CLabel);

    }
}
