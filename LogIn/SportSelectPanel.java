package UI.LogIn;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UI.UIMng;

public class SportSelectPanel extends JPanel {
	private Image img;
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

	public SportSelectPanel() {
		img = new ImageIcon("./image/KGU2.jpg").getImage();
		this.img = img;
		setLayout(null);
		button1.setBounds(121, 257, 130, 50);
		button1.setFont(UIMng.getIns().menuFont);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UIMng.getIns().SelectPlaceToBooking(button1.getText());
			}
		});
		add(button1);

		button2.setBounds(438, 257, 130, 50);
		button2.setFont(UIMng.getIns().menuFont);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UIMng.getIns().SelectPlaceToBooking(button2.getText());
			}
		});
		add(button2);

		button3.setBounds(751, 257, 130, 50);
		button3.setFont(UIMng.getIns().menuFont);
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UIMng.getIns().SelectPlaceToBooking(button3.getText());
			}
		});
		add(button3);

		button4.setBounds(121, 560, 130, 50);
		button4.setFont(UIMng.getIns().menuFont);
		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UIMng.getIns().SelectPlaceToBooking(button4.getText());
			}
		});
		add(button4);

		button5.setBounds(438, 560, 130, 50);
		button5.setFont(UIMng.getIns().menuFont);
		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UIMng.getIns().SelectPlaceToBooking(button5.getText());
			}
		});
		add(button5);

		button6.setBounds(751, 560, 130, 50);
		button6.setFont(UIMng.getIns().menuFont);
		button6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UIMng.getIns().SelectPlaceToBooking(button6.getText());
			}
		});
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

		Label_5.setBounds(412, 304, 300, 300);
		Label_5.setIcon(new ImageIcon("./image/5.png"));
		add(Label_5);

		Label_6.setBounds(728, 360, 181, 187);
		Label_6.setIcon(new ImageIcon("./image/6.png"));
		add(Label_6);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}
