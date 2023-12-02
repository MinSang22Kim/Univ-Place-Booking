package UI.LogIn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import UI.UIMng;

public class CommentPanel extends JPanel {
	private Image img;
	private JLabel nameLabel;
	private JLabel placeLabel;
	private JLabel gradeLabel;
	private JLabel commentLabel;
	private JTextField nameField;
	private JComboBox<String> placeComboBox;
	private int selectedRating = -1;
	private JTextArea commentArea;

	public CommentPanel() {
		img = new ImageIcon("./image/KGU2.jpg").getImage();
		setLayout(null);

		// 각 레이블 및 텍스트 필드 초기화
		nameLabel = new JLabel("이름:");
		placeLabel = new JLabel("장소:");
		gradeLabel = new JLabel("평점:");
		commentLabel = new JLabel("코멘트:");

		nameField = new JTextField();
		placeComboBox = new JComboBox<>(
				new String[] { "팀 프로젝트실", "K-아고라", "K-마루", "풋살장", "축구장", "농구장", "족구장", "테니스장", "탁구장" });

		// 버튼 이벤트 리스너 등록
		JButton writeBtn = new JButton("평점 남기기");
		writeBtn.setBounds(700, 500, 200, 45);
		writeBtn.setFont(new Font(UIMng.getIns().mainFont.getFontName(), Font.PLAIN, 24));
		writeBtn.addActionListener(e -> showPopUp());
		add(writeBtn);
	}

	private void showPopUp() {
		// 팝업 창 크기 조절
		JPanel p = new JPanel(new BorderLayout());
		p.setPreferredSize(new Dimension(800, 500));

		// 입력 패널
		JPanel inputPanel = new JPanel(new GridLayout(4, 2));
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(placeLabel);
		inputPanel.add(placeComboBox);
		inputPanel.add(gradeLabel);
		JPanel ratingPanel = createRatingPanel();
		inputPanel.add(ratingPanel);
		inputPanel.add(commentLabel);

		commentArea = new JTextArea(5, 30);
		JScrollPane scrollPane = new JScrollPane(commentArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		inputPanel.add(scrollPane);

		p.add(inputPanel, BorderLayout.NORTH);

		// 테이블 생성 및 모델 설정
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("이름");
		model.addColumn("장소");
		model.addColumn("평점");
		model.addColumn("코멘트");
		model.addColumn("작성시간");

		JTable infoTable = new JTable(model);
		JScrollPane tableScrollPane = new JScrollPane(infoTable);
		p.add(tableScrollPane, BorderLayout.CENTER);

		int result = JOptionPane.showConfirmDialog(this, p, "시설 평가", JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			String name = nameField.getText();
			String place = (String) placeComboBox.getSelectedItem();
			int rating = selectedRating;
			String comment = commentArea.getText();
			String currentTime = getCurrentTime();

			// 모델에 행 추가
			model.addRow(new Object[] { name, place, rating, comment, currentTime, "" });
			saveToFile(name, place, rating, comment, currentTime);
		} else {
			System.out.println("입력이 취소되었습니다.");
		}
	}

	private void saveToFile(String name, String place, int rating, String comment, String currentTime) {
		try {
			// user_input.txt 파일에 추가
			FileWriter writer = new FileWriter("comment_input.txt", true);
			writer.write(name + "," + place + "," + rating + "," + comment + "," + currentTime + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private JPanel createRatingPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 5));

		for (int i = 1; i <= 5; i++) {
			JButton starButton = new JButton(Integer.toString(i));
			starButton.setContentAreaFilled(false);
			starButton.setBorderPainted(false);
			starButton.setForeground(Color.BLACK);
			starButton.addActionListener(new StarButtonActionListener(i));
			panel.add(starButton);
		}

		return panel;
	}

	private class StarButtonActionListener implements ActionListener {
		private int rating;

		public StarButtonActionListener(int rating) {
			this.rating = rating;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			selectedRating = rating;
			JPanel panel = (JPanel) e.getSource();
			Component[] components = panel.getComponents();
			for (Component component : components) {
				JButton button = (JButton) component;
				int buttonRating = Integer.parseInt(button.getText());
				if (buttonRating <= selectedRating) {
					button.setForeground(Color.YELLOW);
				} else {
					button.setForeground(Color.BLACK);
				}
			}
		}
	}

	private String getCurrentTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}
