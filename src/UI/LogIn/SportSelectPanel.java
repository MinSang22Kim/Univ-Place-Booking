package UI.LogIn;

import UI.Framework.PanelBase;
import UI.UIMng;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SportSelectPanel extends PanelBase {
    JButton button1 = new JButton("풋살장");
    JButton button2 = new JButton("축구장");
    JButton button3 = new JButton("농구장");
    JButton button4 = new JButton("족구장");
    JButton button5 = new JButton("테니스장");
    JButton button6 = new JButton("탁구장");
    JLabel Label_1 = new JLabel("");
    JLabel Label_2 = new JLabel("");
    JLabel Label_3 = new JLabel("");
    JLabel Label_4 = new JLabel("");
    JLabel Label_5 = new JLabel("");
    JLabel Label_6 = new JLabel("");
    public SportSelectPanel()
    {
        super();
        setLayout(null);
        button1.setBounds(121, 257, 130, 50);
        button1.setFont(UIMng.getInstance().menuFont);
        add(button1);

        button2.setBounds(438, 257, 130, 50);
        button2.setFont(UIMng.getInstance().menuFont);
        add(button2);

        button3.setBounds(751, 257, 130, 50);
        button3.setFont(UIMng.getInstance().menuFont);
        add(button3);

        button4.setBounds(121, 560, 130, 50);
        button4.setFont(UIMng.getInstance().menuFont);
        add(button4);

        button5.setBounds(438, 560, 130, 50);
        button5.setFont(UIMng.getInstance().menuFont);
        add(button5);

        button6.setBounds(751, 560, 130, 50);
        button6.setFont(UIMng.getInstance().menuFont);
        add(button6);


        Label_1.setBounds(101, 63, 181, 181);
        Label_1.setIcon(new ImageIcon("./image/1.png"));
        add(Label_1);

        Label_2.setBounds(412, 63, 175, 181);
        Label_2.setIcon(new ImageIcon("./image/2.png"));
        add(Label_2);

        Label_3.setBounds(728, 67, 181, 177);
        Label_3.setIcon(new ImageIcon("./image/3.png"));
        add(Label_3);

        Label_4.setBounds(101, 360, 181, 187);
        Label_4.setIcon(new ImageIcon("./image/4.png"));
        add(Label_4);

        Label_5.setBounds(412, 360, 300, 300);
        Label_5.setIcon(new ImageIcon("./image/5.png"));
        add(Label_5);

        Label_6.setBounds(728, 360, 181, 187);
        Label_6.setIcon(new ImageIcon("./image/6.png"));
        add(Label_6);
    }
}
