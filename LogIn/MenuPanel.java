package UI.LogIn;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UI.DEFINE;
import UI.UIMng;

public class MenuPanel extends JPanel {
	private Image img;
	JLabel welcomeLabel = new JLabel(new ImageIcon("./image/Welcome.jpg"));
	JButton reservationButton = new JButton("예약하기");
	JButton searchButton = new JButton("조회하기");
	JButton commentButton = new JButton("평점보기");

	public MenuPanel() {
		img = new ImageIcon("./image/KGU2.jpg").getImage();
		this.img = img;
		setLayout(null);

		welcomeLabel.setBounds(150, 100, 700, 200);
		add(welcomeLabel);

		reservationButton.setBounds(150, 520, 150, 50);
		reservationButton.setFont(UIMng.getIns().menuFont);
		reservationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("예약 버튼 클릭");
				UIMng.getIns().showPanel(DEFINE.PLACE_SELECT_PANEL);
			}
		});
		add(reservationButton);

		searchButton.setBounds(430, 520, 150, 50);
		searchButton.setFont(UIMng.getIns().menuFont);
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("검색 버튼 클릭");
			}
		});
		add(searchButton);

		commentButton.setBounds(700, 520, 150, 50);
		commentButton.setFont(UIMng.getIns().menuFont);
		commentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("평점 버튼 클릭");
				CommentPanel.showPopUp();
				// UIMng.getIns().showPanel(DEFINE.COMMENT_PANEL);
			}
		});
		add(commentButton);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}
