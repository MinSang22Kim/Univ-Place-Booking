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

class ImagePanel extends JPanel {
	private Image img;

	public ImagePanel(Image img) {
		this.img = img;
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}

public class SchoolReservation {
	private JFrame frame;
	private JTextField idField;
	private JPasswordField passField;
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
		ImagePanel loginPanel = new ImagePanel(new ImageIcon("./image/KGU2.jpg").getImage());
		loginPanel.setLayout(null);

		JLabel idLabel = new JLabel("학번");
		idLabel.setBounds(122, 270, 80, 43);
		idLabel.setForeground(Color.WHITE);
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		loginPanel.add(idLabel);

		idField = new JTextField();
		idField.setBounds(122, 311, 296, 43);
		idField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		idField.setColumns(10);
		idField.setBorder(null);
		loginPanel.add(idField);

		JLabel passLabel = new JLabel("비밀번호");
		passLabel.setBounds(122, 350, 120, 43);
		passLabel.setForeground(Color.WHITE);
		passLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		loginPanel.add(passLabel);

		passField = new JPasswordField();
		passField.setBounds(122, 391, 296, 43);
		passField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		passField.setBorder(null);
		loginPanel.add(passField);

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(122, 461, 296, 43);
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "welcomePanel");
			}
		});
		loginPanel.add(loginButton);

		// 로그인 성공 화면 판넬
		JPanel welcomePanel = new JPanel();
		welcomePanel.setLayout(null);

		JLabel welcomeLabel = new JLabel(new ImageIcon("./image/Welcome.jpg"));
		welcomeLabel.setBounds(150, 100, 700, 200);
		welcomePanel.add(welcomeLabel);

		JButton reservationButton = new JButton("예약하기");
		reservationButton.setBounds(250, 520, 150, 50);
		reservationButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		reservationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "reservationPanel");
			}
		});
		welcomePanel.add(reservationButton);

		JButton searchButton = new JButton("검색하기");
		searchButton.setBounds(643, 520, 150, 50);
		searchButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("검색 버튼 클릭");
			}
		});
		welcomePanel.add(searchButton);

		JPanel reservationPanel = new JPanel();

		// 스터디룸 예약 버튼
		JButton studyRoomButton = new JButton("스터디룸 예약");
		studyRoomButton.setBounds(177, 524, 200, 50);
		studyRoomButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		studyRoomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("스터디룸 예약 버튼 클릭");
				cardLayout.show(cardPanel, "studyRoomReservationPanel"); // 스터디룸 예약 판넬로 전환
			}
		});
		reservationPanel.setLayout(null);
		reservationPanel.add(studyRoomButton);

		// JLabel studyRoomImageLabel = new JLabel(new
		// ImageIcon("./Users/kms/eclipse-workspace/OOP_TeamProject/image/StudyRoom.jpg"));
		JLabel studyRoomImageLabel = new JLabel(new ImageIcon("./image/StudyRoom.jpg"));
		studyRoomImageLabel.setBounds(127, 156, 300, 300);
		reservationPanel.add(studyRoomImageLabel);

		// 체육시설 예약 버튼
		JButton sportsButton = new JButton("체육시설 예약");
		sportsButton.setBounds(615, 524, 200, 50);
		sportsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sportsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("체육시설 예약 버튼 클릭");
				cardLayout.show(cardPanel, "sportsFacilityReservationPanel"); // 체육시설 예약 판넬로 전환
			}
		});
		reservationPanel.add(sportsButton);

		// JLabel gymImageLabel = new JLabel(new
		// ImageIcon("/Users/kms/eclipse-workspace/OOP_TeamProject/image/SportFacility.jpg"));
		JLabel sportsFacilityImageLabel = new JLabel(new ImageIcon("./image/SportsFacility.jpg"));
		sportsFacilityImageLabel.setBounds(508, 156, 400, 300);
		reservationPanel.add(sportsFacilityImageLabel);

		// 3개의 스터디룸 예약 페이지
		JPanel studyRoomReservationPanel = new JPanel();
		studyRoomReservationPanel.setLayout(null);

		JButton buttonA = new JButton("팀 프로젝트실");
		buttonA.setBounds(119, 463, 150, 50);
		buttonA.setFont(new Font("Tahoma", Font.PLAIN, 20));
		studyRoomReservationPanel.add(buttonA);

		JButton buttonB = new JButton("K-아고라");
		buttonB.setBounds(418, 463, 150, 50);
		buttonB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		studyRoomReservationPanel.add(buttonB);

		JButton buttonC = new JButton("K-마루");
		buttonC.setBounds(725, 463, 150, 50);
		buttonC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		studyRoomReservationPanel.add(buttonC);

		// 체육시설 예약 페이지
		JPanel sportsFacilityReservationPanel = new JPanel();
		sportsFacilityReservationPanel.setLayout(null);

		// 체육시설 예약 (버튼 6개)
		JButton button1 = new JButton("풋살장");
		button1.setBounds(121, 257, 130, 50);
		button1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sportsFacilityReservationPanel.add(button1);

		JButton button2 = new JButton("축구장");
		button2.setBounds(438, 257, 130, 50);
		button2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sportsFacilityReservationPanel.add(button2);

		JButton button3 = new JButton("농구장");
		button3.setBounds(751, 257, 130, 50);
		button3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sportsFacilityReservationPanel.add(button3);

		JButton button4 = new JButton("족구장");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button4.setBounds(121, 560, 130, 50);
		button4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sportsFacilityReservationPanel.add(button4);

		JButton button5 = new JButton("테니스장");
		button5.setBounds(438, 560, 130, 50);
		button5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sportsFacilityReservationPanel.add(button5);

		JButton button6 = new JButton("탁구장");
		button6.setBounds(751, 560, 130, 50);
		button6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sportsFacilityReservationPanel.add(button6);

		// 카드 레이아웃 설정
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);
		cardPanel.add(loginPanel, "loginPanel");
		cardPanel.add(welcomePanel, "welcomePanel");
		cardPanel.add(reservationPanel, "reservationPanel");
		cardPanel.add(studyRoomReservationPanel, "studyRoomReservationPanel");

		// 절대 경로로 이미지 파일 편집이 쉬워서 지우지 않고 주석처리
		JLabel ALabel = new JLabel("");
		// ALabel.setIcon(new
		// ImageIcon("/Users/kms/eclipse-workspace/OOP_TeamProject/image/A.png"));
		ALabel.setIcon(new ImageIcon(".image/A.png"));
		ALabel.setBounds(55, 190, 271, 188);
		studyRoomReservationPanel.add(ALabel);

		JLabel BLabel = new JLabel("");
		// BLabel.setIcon(new
		// ImageIcon("/Users/kms/eclipse-workspace/OOP_TeamProject/image/B.png"));
		BLabel.setIcon(new ImageIcon("./image/B.png"));
		BLabel.setBounds(354, 190, 271, 188);
		studyRoomReservationPanel.add(BLabel);

		JLabel CLabel = new JLabel("");
		// CLabel.setIcon(new
		// ImageIcon("/Users/kms/eclipse-workspace/OOP_TeamProject/image/C.png"));
		CLabel.setIcon(new ImageIcon("./image/C.png"));
		CLabel.setBounds(657, 190, 276, 197);
		studyRoomReservationPanel.add(CLabel);
		cardPanel.add(sportsFacilityReservationPanel, "sportsFacilityReservationPanel");

		JLabel Label_1 = new JLabel("");
		Label_1.setBounds(101, 63, 181, 181);
		// Label_1.setIcon(new
		// ImageIcon("/Users/kms/eclipse-workspace/OOP_TeamProject/image/1.png"));
		Label_1.setIcon(new ImageIcon("./image/1.png"));
		sportsFacilityReservationPanel.add(Label_1);

		JLabel Label_2 = new JLabel("");
		Label_2.setBounds(412, 63, 175, 181);
		// Label_2.setIcon(new
		// ImageIcon("/Users/kms/eclipse-workspace/OOP_TeamProject/image/2.png"));
		Label_2.setIcon(new ImageIcon("./image/2.png"));
		sportsFacilityReservationPanel.add(Label_2);

		JLabel Label_3 = new JLabel("");
		Label_3.setBounds(728, 67, 181, 177);
		// Label_3.setIcon(new
		// ImageIcon("/Users/kms/eclipse-workspace/OOP_TeamProject/image/3.png"));
		Label_3.setIcon(new ImageIcon("./image/3.png"));
		sportsFacilityReservationPanel.add(Label_3);

		JLabel Label_4 = new JLabel("");
		Label_4.setBounds(101, 360, 181, 187);
		// Label_4.setIcon(new
		// ImageIcon("/Users/kms/eclipse-workspace/OOP_TeamProject/image/4.png"));
		Label_4.setIcon(new ImageIcon("./image/4.png"));
		sportsFacilityReservationPanel.add(Label_4);

		JLabel Label_5 = new JLabel("");
		ImageIcon icon = new ImageIcon("/Users/kms/eclipse-workspace/OOP_TeamProject/image/5.png");
		Label_5.setBounds(412, 360, 300, 300);
		// Label_5.setIcon(new
		// ImageIcon("/Users/kms/eclipse-workspace/OOP_TeamProject/image/5.png"));
		Label_5.setIcon(icon);
		sportsFacilityReservationPanel.add(Label_5);

		JLabel Label_6 = new JLabel("");
		Label_6.setBounds(728, 360, 181, 187);
		// Label_6.setIcon(new
		// ImageIcon("/Users/kms/eclipse-workspace/OOP_TeamProject/image/6.png"));
		Label_6.setIcon(new ImageIcon("./image/6.png"));
		sportsFacilityReservationPanel.add(Label_6);

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