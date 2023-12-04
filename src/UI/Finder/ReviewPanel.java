package UI.Finder;

import UI.DEFINE;
import UI.NonEditableTableModel;
import UI.UIMng;
import function.Booking;
import mgr.ProgramMng;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReviewPanel extends JPanel {
    JTable table;
    NonEditableTableModel model;

    JButton menuButton = new JButton("메뉴화면");

    JTextField contentField = new JTextField();
    JButton okButton = new JButton("확인");
    JComboBox<String> reviewCombo;
    JComboBox<String> scoreCombo;
    public ReviewPanel() {

        model = new NonEditableTableModel();
        model.addColumn("이름");
        model.addColumn("장소명");
        model.addColumn("별점");
        model.addColumn("후기");
        model.addColumn("작성일시");

        table = new JTable(model);

        table.setCellSelectionEnabled(true);
        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        JScrollPane sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(980, 500));
        add(sp);

        menuButton.setBounds(625, 520, 150, 50);
        menuButton.setFont(UIMng.getIns().menuFont);
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIMng.getIns().showPanel(DEFINE.MENU_PANEL);
            }
        });
        add(menuButton);


        reviewCombo = new JComboBox<>();

        reviewCombo.setOpaque(true);

        reviewCombo.setLayout(null);
        reviewCombo.setSize(300, 50);
        reviewCombo.setLocation(100, 600);
        reviewCombo.setFont(UIMng.getIns().subFont);

        reviewCombo.addItem("탁구장");
        reviewCombo.addItem("축구장");
        reviewCombo.addItem("족구장");
        reviewCombo.addItem("풋살장");
        reviewCombo.addItem("농구장");
        reviewCombo.addItem("테니스장");
        reviewCombo.addItem("K-마루");
        reviewCombo.addItem("K-아고라");
        reviewCombo.addItem("팀프로젝트실");

        scoreCombo = new JComboBox<>();

        scoreCombo.setOpaque(true);

        scoreCombo.setLayout(null);
        scoreCombo.setSize(300, 50);
        scoreCombo.setLocation(100, 600);
        scoreCombo.setFont(UIMng.getIns().subFont);

        scoreCombo.addItem("0");
        scoreCombo.addItem("1");
        scoreCombo.addItem("2");
        scoreCombo.addItem("3");
        scoreCombo.addItem("4");
        scoreCombo.addItem("5");

        contentField.setPreferredSize(new Dimension(500,100));
        okButton.setPreferredSize(new Dimension(100,100));
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addReview(ProgramMng.getIns().user.name, reviewCombo.getSelectedItem().toString(), reviewCombo.getSelectedItem().toString(), null, contentField.getText());
            }
        });
        okButton.setLayout(null);

        add(reviewCombo);
        add(scoreCombo);
        add(contentField);
        add(okButton);

        addReview("조영서", "K-마루", "4", "2023-11-06-16:25:55", "친구들과 모이기 좋은 곳입니다.");
        addReview("김승민", "축구장", "5", "2023-11-05-17:20:30", "축구장이 항상 깨끗하게 관리되어서 좋습니다.");
        addReview("오승현", "풋살장", "4", "2023-11-04-18:10:18", "시설이 깨끗해요. 풋살장이 항상 청결하게 유지되어서 좋아요.");
        addReview("나현우", "K-아고라", "3", "2023-11-03 19:01:40", "좀 더 정비가 필요해요. 시설이 조금 더 관리되면 좋겠습니다.");
        addReview("정다빈", "농구장", "5", "2023-11-02-20:30:12", "서비스가 좋아요! 농구장이 항상 청결하게 관리되어서 좋아요.");
        addReview("이정훈", "테니스장", "4", "2023-11-01 21:20:05", "편리해요.");
        addReview("신승호", "K-마루", "4", "2023-10-25-14:25:55", "시설이 깨끗해요. K-마루가 항상 청결하게 관리되어서 좋아요.");
        addReview("황예은", "농구장", "3", "2023-10-24-15:01:40", "좀 더 정비가 필요해요. 농구장이 조금 더 관리되면 좋겠습니다.");
        addReview("김태원", "족구장", "4", "2023-10-22-17:15:22", "편리해요. 족구장이 항상 깨끗하게 관리되어서 좋아요.");
        addReview("조성민", "테니스장", "4", "2023-10-21-18:10:18", "시설은 좋은데, 테니스공 잃어버렸어요ㅠ");
        addReview("박승호", "족구장", "3", "2023-11-19-17:20:10", "시끄러워서 조금 더 조용했으면 좋겠어요.");
        addReview("김다빈", "축구장", "5", "2023-11-18-18:12:55", "깨끗하고 넓어서 좋아요.");
        addReview("송지은", "K-마루", "4", "2023-11-17-19:40:30", "분위기가 좋아서 자주 이용합니다.");
        addReview("강현우", "풋살장", "2", "2023-11-16-20:15:18", "시설이 낡아서 아쉬워요. 좀 더 투자가 필요해 보입니다.");
        addReview("임다솔", "K-아고라", "5", "2023-11-15-21:01:40", "조용하고 좋아요. 주말에도 붐비지 않아서 좋습니다.");
        addReview("신지은", "팀프로젝트실", "4", "2023-11-14-22:30:12", "시설이 깨끗해요. 항상 깨끗하게 유지되어서 좋습니다.");
        addReview("황예은", "풋살장", "3", "2023-11-13-23:20:05", "풋살장의 표면이 다소 부드럽지 않아서 미끄러워요.");
        addReview("백주원", "탁구장", "5", "2023-11-12-10:10:10", "좋아요!");
        addReview("정승민", "K-마루", "4", "2023-11-11-11:45:30", "편리해요. 위치가 좋아서 자주 이용합니다.");
        addReview("최성민", "족구장", "5", "2023-11-10-12:33:18", "깨끗해요. 족구장이 청결하게 유지되어서 좋아요.");
        addReview("김태원", "팀프로젝트실", "3", "2023-11-09-13:22:45", "의자가 불편해서 좀 더 편안한 의자가 있으면 좋겠어요.");
        addReview("임세은", "탁구장", "5", "2023-11-08-14:15:22", "좋아요! 친구들과 함께 재미있게 사용하고 있습니다.");
        addReview("박시현", "농구장", "2", "2023-11-07-15:40:10", "불편했습니다.");

    }

    public void addReview(String name, String placename, String score,String date, String content)
    {
        String formattedDateTime;
        if(date != null)
            formattedDateTime = date;
        else
        {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            formattedDateTime = now.format(formatter);
        }
        model.addRow(new Object[]{name, placename, score, content, formattedDateTime});
    }
}
