package UI.LogIn;

import UI.DEFINE;
import UI.UIMng;
import mgr.ProgramMng;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        idLabel.setFont(UIMng.getInstance().logInFont);
        add(idLabel);

        idField.setBounds(122, 311, 296, 43);
        idField.setFont(UIMng.getInstance().logInFont);
        idField.setColumns(10);
        idField.setBorder(null);
        add(idField);

        passLabel.setBounds(122, 350, 120, 43);
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(UIMng.getInstance().logInFont);
        add(passLabel);

        passField.setBounds(122, 391, 296, 43);
        passField.setFont(UIMng.getInstance().logInFont);
        passField.setBorder(null);
        add(passField);

        loginButton.setBounds(122, 461, 296, 43);
        loginButton.setFont(UIMng.getInstance().logInFont);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(IsLogIn())
                    UIMng.getInstance().showPanel(DEFINE.MENU_PANEL);
                else {
                    JOptionPane.showMessageDialog(null, "아이디 또는 패스워드를 다시 확인하세요.");
                }
            }
        });
        add(loginButton);
    }

    boolean IsLogIn()
    {
        boolean result = ProgramMng.getInstance().login(idField.getText(), passField.getText());
        System.out.println(result);
        return result;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}
