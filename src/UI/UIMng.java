package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIMng {
    JFrame mainFrame = new JFrame();
    ImageLabel kguIcon = new ImageLabel("resource/kgu_logo.png", 10, 10);


    private static UIMng instance;
    private UIMng() {
    }

    public static UIMng getInstance() {
        if (instance == null) {
            instance = new UIMng();
        }
        return instance;
    }

    public void Init()
    {
        mainFrame.setSize(1280, 720);
        mainFrame.setLocation(600,400);
        mainFrame.setTitle("학교 시설 예약 프로그램");
        mainFrame.setLayout(null);

        JButton button = new JButton("클릭하세요");
        button.setBounds(200,200,200,200);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if(command.equals("클릭하세요"))
                    JOptionPane.showMessageDialog(mainFrame, "버튼이 클릭되었습니다.");
            }
        });

        mainFrame.add(kguIcon);
        mainFrame.add(button);

        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        UIMng.getInstance().Init();
    }
}
