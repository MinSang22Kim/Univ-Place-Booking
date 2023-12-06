package function;

import Booking.BookingInfo;
import mgr.Manageable;
import mgr.ProgramMng;
import mgr.Sheet;

public class Booking {
    // user는 로그인 하면은 Manager객체에 user멤버에 저장되기에, 따로 매개변수로 안받음

    //ex)아고라A ,A1, 2023-11-29, 13-14 버튼 눌렀을 때, 예약 가능 여부
    public static boolean possibleBooking(String fname, String code, String reservationDate, String reservationTime) {
        String name = fname; //시설 이름
        String sheetname = code; //좌석(구역) 번호
        String date = reservationDate; //예약 날짜
        String time = reservationTime; //예약 시간

        Manageable m = ProgramMng.getIns().find(name);
        Sheet sheet = m.getSheet(sheetname);
        String[] time_split = time.split("-");
        int startHour = Integer.parseInt(time_split[0]);
        int endHour = Integer.parseInt(time_split[1]);


        if (m == null) {
            System.out.println(1);
            return false;
        }
        if (sheet == null) {
            System.out.println(2);
            return false;
        }
        if (!ProgramMng.getIns().checkValid(date)) {
            System.out.println(3);
            return false;
        }
        if (startHour > 24 || endHour > 24) {
            System.out.println(4);
            return false;
        }
        if (startHour >= endHour) {
            System.out.println(5);
            return false;
        }
        if (ProgramMng.getIns().user.check(date, startHour, endHour)){
            System.out.println(6);
            return false;}
        if (!m.IsBooking(sheet, ProgramMng.getIns().user, date, startHour, endHour)) {
            System.out.println(7);
            return false;

        }
        return true; //true면 예약 가능한 자리 , true, false여부로 좌석 색깔(ex 예약 가능하면 주황, 불가능하면 회색) 사용하시면 될 거 같아요
    }

    //예약하기 버튼 눌렀을 때 이벤트 처리
    public static String booking(String fname, String code, String reservationDate, String reservationTime) {
        String name = fname; //시설 이름
        String sheetname = code; //좌석번호
        String date = reservationDate; //예약 날짜
        String time = reservationTime; //예약 시간
        Manageable m = ProgramMng.getIns().find(name);
        Sheet sheet = m.getSheet(sheetname);
        System.out.println(time);
        String[] time_split = time.split("-");
        int startHour = Integer.parseInt(time_split[0]);
        int endHour = Integer.parseInt(time_split[1]);
        if (Booking.possibleBooking(name, code, reservationDate, reservationTime)) {
            m.addBooking(sheet, ProgramMng.getIns().user, date, startHour, endHour);
            ProgramMng.getIns().user.bookingList.add(new BookingInfo(ProgramMng.getIns().user, date, startHour, endHour));
            String rt = String.format("(%s) - 예약되었습니다.\n예약 시간 : %s %d:00~%d:00 (예약자 : %s(%s))", sheetname, date
                    , startHour, endHour, ProgramMng.getIns().user.name, ProgramMng.getIns().user.code);
            return rt;
        }
        return null;
    }

    //삭제 버튼 눌렀을때 예약 삭제하는 이벤트 처리
    public static void deleteBooking(String fname, String code, String reservationDate, String reservationTime) {
        String name = fname; //시설 이름
        String sheetname = code; //좌석번호
        String date = reservationDate; //예약 날짜
        String time = reservationTime; //예약 시간
        Manageable m = ProgramMng.getIns().find(name);
        Sheet sheet = m.getSheet(sheetname);
        String[] time_split = time.split("-");
        int startHour = Integer.parseInt(time_split[0]);
        int endHour = Integer.parseInt(time_split[1]);

        BookingInfo removeBookingInfo = sheet.findBookigInfo(ProgramMng.getIns().user, date, startHour, endHour);
        sheet.bookingInfo.remove(removeBookingInfo);
        BookingInfo removeBookingInfo2 = ProgramMng.getIns().user.findBookigInfo(ProgramMng.getIns().user, date, startHour, endHour);
        ProgramMng.getIns().user.bookingList.remove(removeBookingInfo2);
        System.out.println("--");
        for(BookingInfo b : ProgramMng.getIns().user.bookingList){
            System.out.println(b);
        }
    }
}

