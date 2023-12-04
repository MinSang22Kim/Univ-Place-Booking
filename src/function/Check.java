package function;

import mgr.Manageable;
import mgr.ProgramMng;
import mgr.Sheet;

import javax.swing.*;

public class Check {
    public static String fieldInputText(JTextField fieldName) { //텍스트필드의 텍스트를 가져오는 메소드
        return fieldName.getText();
    }
    public static String checkList(String loginId, ProgramMng mgr) { //로그인 정보에 따라 예약 정보를 보여주는 메소드
        StringBuffer sb = new StringBuffer();
        String s = null;
        for (Manageable m : mgr.mList)
            sb.append(m.bookingMatchesUser(loginId));
        s = sb.toString();
        return s;
    }
    public static String search(String field1, String field2, ProgramMng mgr) { //검색 기능
        if(!(field1.contentEquals("ALL") || field1.contains("팀프A")
                || field1.contains("팀프B") || field1.contains("팀프C")
                || field1.contains("팀프D") || field1.contains("팀프E")
                || field1.contains("팀프F") || field1.contains("팀프G")
                || field1.contains("팀프H") ||field1.contentEquals("아고라A")
                || field1.contentEquals("아고라B") || field1.contentEquals("아고라C")
                || field1.contentEquals("아고라D") || field1.contentEquals("아고라E")
                || field1.contentEquals("아고라F") || field1.contentEquals("아고라G")
                || field1.contentEquals("아고라H") || field1.contentEquals("마루A")
                || field1.contentEquals("마루B") || field1.contentEquals("마루C")
                || field1.contentEquals("마루D") || field1.contentEquals("마루E")
                || field1.contentEquals("마루F") || field1.contentEquals("마루G")
                || field1.contentEquals("마루H") || field1.contentEquals("풋살장A")
                || field1.contentEquals("풋살장B") || field1.contentEquals("축구장A")
                || field1.contentEquals("농구장A") || field1.contentEquals("농구장B")
                || field1.contentEquals("농구장C") || field1.contentEquals("족구장A")
                || field1.contentEquals("족구장B") || field1.contentEquals("테니스장A")
                || field1.contentEquals("탁구장A"))) {
            StringBuffer sb = new StringBuffer();
            String s = null;
            sb.append("잘못된 입력입니다.\n아래 정보를 참고하세요.\n\n");
            sb.append("[팀프실(A~H), 아고라(A~H), 마루(A~H)\n" +
                    "풋살장(A,B), 축구장A, 농구장(A~C), 족구장(A,B), 테니스장A, 탁구장A]");
            s = sb.toString();
            return s;
        }
        if(field1.equals("ALL")) {
            StringBuffer sb = new StringBuffer();
            String s = null;
            for(Manageable m : mgr.mList)
                sb.append(m.bookingPrint());
            s = sb.toString();
            return s;
        } else {
            Manageable m = mgr.find(field1);
            if(!m.IsNotSheet()) {
                if(field2.equals("ALL")) {
                    return m.bookingPrint();
                }
                else if(field2.equals("")) {
                    return ("조회할 좌석 또는 구역을 입력해주세요!");
                }
                else {
                    Sheet s = null;
                    s = m.getSheet(field2);
                    if(mgr.isRooms(m) && s == null) {
                        StringBuffer sb = new StringBuffer();
                        String st = null;
                        sb.append("존재하지 않는 좌석입니다!\n아래 정보를 참고하세요.\n\n");
                        sb.append("[아고라A(A1~A10), 아고라B(B1~B10), 아고라C(C1~C10), 아고라D(D1~D10)\n" +
                                "아고라E(E1~E10), 아고라F(F1~F10), 아고라G(G1~G10), 아고라H(H1~H10)]\n" +
                                "[마루A(A1~A5), 마루B(B1~B5), 마루C(C1~C5), 마루D(D1~D5)\n" +
                                "마루E(E1~E5), 마루F(F1~F5), 마루G(G1~G10), 마루H(H1~H10)]\n");
                        st = sb.toString();
                        return st;
                    }
                    else if(!mgr.isRooms(m) && s == null) {
                        StringBuffer sb = new StringBuffer();
                        String st = null;
                        sb.append("존재하지 않는 구역입니다!\n아래 정보를 참고하세요.\n\n");
                        sb.append("[풋살장A(A1,A2), 풋살장B(B1) 축구장A(A1)\n농구장A(A1,A2), 농구장B(B1,B2), 농구장C(C1)\n" +
                                "족구장A(A1,A2), 족구장B(B1,B2)\n테니스장A(A1,A2,A3,A4), 탁구장(A1,A2,A3,A4,A5,A6)]");
                        st = sb.toString();
                        return st;
                    }
                    else
                        return s.print();
                }

            } else {
                return m.bookingPrint();
            }
        }
    }
}
