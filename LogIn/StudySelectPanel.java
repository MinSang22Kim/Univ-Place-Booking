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

public class StudySelectPanel extends JPanel {
	private Image img;
	JButton buttonA = new JButton("팀 프로젝트실");
	JButton buttonB = new JButton("K-아고라");
	JButton buttonC = new JButton("K-마루");
	JLabel ALabel = new JLabel("");
	JLabel BLabel = new JLabel("");
	JLabel CLabel = new JLabel("");

	public StudySelectPanel() {
		img = new ImageIcon("./image/KGU2.jpg").getImage();
		this.img = img;
		setLayout(null);

		buttonA.setName("팀프로젝트실");
		buttonB.setName("아고라");
		buttonC.setName("마루");

		buttonA.setBounds(119, 463, 150, 50);
		buttonA.setFont(UIMng.getIns().menuFont);
		buttonA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UIMng.getIns().SelectPlaceToBooking(buttonA.getName());
			}
		});
		add(buttonA);

		buttonB.setBounds(418, 463, 150, 50);
		buttonB.setFont(UIMng.getIns().menuFont);
		buttonB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UIMng.getIns().SelectPlaceToBooking(buttonB.getName());
			}
		});
		add(buttonB);

		buttonC.setBounds(725, 463, 150, 50);
		buttonC.setFont(UIMng.getIns().menuFont);
		buttonC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UIMng.getIns().SelectPlaceToBooking(buttonC.getName());
			}
		});
		add(buttonC);

		ALabel.setIcon(new ImageIcon("./image/A.png"));
		ALabel.setBounds(55, 190, 271, 188);
		add(ALabel);

		BLabel.setIcon(new ImageIcon("./image/B.png"));
		BLabel.setBounds(354, 190, 271, 188);
		add(BLabel);

		CLabel.setIcon(new ImageIcon("./image/C.png"));
		CLabel.setBounds(657, 190, 276, 197);
		add(CLabel);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}
