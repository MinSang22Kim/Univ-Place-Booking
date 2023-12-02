package UI.LogIn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import UI.DEFINE;
import UI.UIMng;
import mgr.ProgramMng;

public class LogInPanel extends JPanel {
	private Image img;
	JLabel idLabel = new JLabel("학번");
	JTextField idField = new JTextField();
	JLabel passLabel = new JLabel("비밀번호");
	JPasswordField passField = new JPasswordField();
	JButton loginButton = new JButton("Login");

	public LogInPanel() {
		img = new ImageIcon("./image/KGU2.jpg").getImage();
		this.img = img;
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);

		idLabel.setBounds(122, 270, 80, 43);
		idLabel.setForeground(Color.WHITE);
		idLabel.setFont(UIMng.getIns().logInFont);
		add(idLabel);

		idField.setBounds(122, 311, 296, 43);
		idField.setFont(UIMng.getIns().logInFont);
		idField.setColumns(10);
		idField.setBorder(null);
		add(idField);

		passLabel.setBounds(122, 350, 120, 43);
		passLabel.setForeground(Color.WHITE);
		passLabel.setFont(UIMng.getIns().logInFont);
		add(passLabel);

		passField.setBounds(122, 391, 296, 43);
		passField.setFont(UIMng.getIns().logInFont);
		passField.setBorder(null);
		add(passField);

		loginButton.setBounds(122, 461, 296, 43);
		loginButton.setFont(UIMng.getIns().logInFont);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (IsLogIn())
					UIMng.getIns().showPanel(DEFINE.MENU_PANEL);
				else {
					JOptionPane.showMessageDialog(null, "아이디 또는 패스워드를 다시 확인하세요.");
				}
			}
		});
		add(loginButton);
	}

	boolean IsLogIn() {
		boolean result = ProgramMng.getIns().login(idField.getText(), passField.getText());
		System.out.println(result);
		return result;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}
