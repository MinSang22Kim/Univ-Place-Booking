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

public class PlaceSelectPanel extends JPanel {
	private Image img;
	JButton studyRoomButton = new JButton("스터디룸 예약");
	JLabel studyRoomImageLabel = new JLabel(new ImageIcon("./image/StudyRoom.jpg"));
	JButton sportsButton = new JButton("체육시설 예약");

	public PlaceSelectPanel() {
		img = new ImageIcon("./image/KGU2.jpg").getImage();
		this.img = img;
		setLayout(null);
		studyRoomButton.setBounds(177, 524, 200, 50);
		studyRoomButton.setFont(UIMng.getIns().menuFont);
		studyRoomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("스터디룸 예약 버튼 클릭");
				UIMng.getIns().showPanel(DEFINE.STUDY_SELECT_PANEL); // 스터디룸 예약 판넬로 전환
			}
		});

		add(studyRoomButton);

		studyRoomImageLabel.setBounds(127, 156, 300, 300);
		add(studyRoomImageLabel);

		// 체육시설 예약 버튼
		sportsButton.setBounds(615, 524, 200, 50);
		sportsButton.setFont(UIMng.getIns().menuFont);
		sportsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("체육시설 예약 버튼 클릭");
				UIMng.getIns().showPanel(DEFINE.SPORT_SELECT_PANEL); // 체육시설 예약 판넬로 전환
			}
		});
		add(sportsButton);

		JLabel sportsFacilityImageLabel = new JLabel(new ImageIcon("./image/SportsFacility.jpg"));
		sportsFacilityImageLabel.setBounds(508, 156, 400, 300);
		add(sportsFacilityImageLabel);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}
