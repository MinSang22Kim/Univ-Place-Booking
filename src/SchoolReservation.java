import UI.UIMng;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SchoolReservation {
	private JFrame frame;
	private JPanel cardPanel;
	private CardLayout cardLayout;

	public SchoolReservation() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("KGU RESERVATION");
		frame.setSize(1000, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 로그인 화면

		// 로그인 성공 화면 판넬
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(null);

		JPanel welcomePanel = new JPanel();
		welcomePanel.setLayout(null);

		JPanel reservationPanel = new JPanel();

		// 3개의 스터디룸 예약 페이지
		JPanel studyRoomReservationPanel = new JPanel();
		studyRoomReservationPanel.setLayout(null);

		// 체육시설 예약 페이지
		JPanel sportsFacilityReservationPanel = new JPanel();
		sportsFacilityReservationPanel.setLayout(null);

		// 카드 레이아웃 설정
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);

		frame.getContentPane().add(cardPanel);

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new SchoolReservation();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}