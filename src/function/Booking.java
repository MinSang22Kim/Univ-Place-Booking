package function;

import Booking.BookingInfo;
import mgr.Manageable;
import mgr.ProgramMng;
import mgr.Sheet;

public class Booking {
    // user는 로그인 하면은 Manager객체에 user멤버에 저장되기에, 따로 매개변수로 안받음

    //ex)아고라A ,A1, 2023-11-29, 13-14 버튼 눌렀을 때, 예약 가능 여부
    public static boolean possibleBooking(ProgramMng programMng, String fname, String code, String reservationDate, String reservationTime) {
        String name = fname; //시설 이름
        String sheetname = code; //좌석(구역) 번호
        String date = reservationDate; //예약 날짜
        String time = reservationTime; //예약 시간

        Manageable m = programMng.find(name);
        Sheet sheet = m.getSheet(sheetname);
        String[] time_split = time.split("-");
        int startHour = Integer.parseInt(time_split[0]);
        int endHour = Integer.parseInt(time_split[1]);
        if (m == null)
            return false;
        if (sheet == null)
            return false;
        if (!programMng.checkValid(date))
            return false;
        if (startHour > 24 || endHour > 24)
            return false;
        if (programMng.user.check(date, startHour, endHour))
            return false;
        if (!m.IsBooking(sheet, programMng.user, date, startHour, endHour))
            return false;
        return true; //true면 예약 가능한 자리 , true, false여부로 좌석 색깔(ex 예약 가능하면 주황, 불가능하면 회색) 사용하시면 될 거 같아요
    }

    //예약하기 버튼 눌렀을 때 이벤트 처리
    public static String booking(ProgramMng programMng, String fname, String code, String reservationDate, String reservationTime) {
        String name = fname; //시설 이름
        String sheetname = code; //좌석번호
        String date = reservationDate; //예약 날짜
        String time = reservationTime; //예약 시간
        Manageable m = programMng.find(name);
        Sheet sheet = m.getSheet(sheetname);
        String[] time_split = time.split("-");
        int startHour = Integer.parseInt(time_split[0]);
        int endHour = Integer.parseInt(time_split[1]);
        if (Booking.possibleBooking(programMng, name, code, reservationDate, reservationTime)) {
            m.addBooking(sheet, programMng.user, date, startHour, endHour);
            programMng.user.bookingList.add(new BookingInfo(programMng.user, date, startHour, endHour));
            String rt = String.format("(%s) - 예약되었습니다.\n예약 시간 : %s %d:00~%d:00 (예약자 : %s(%s))", sheetname, date
                    , startHour, endHour, programMng.user.name, programMng.user.code);
            return rt;
        }
        return null;
    }

    //삭제 버튼 눌렀을때 예약 삭제하는 이벤트 처리
    public static void deleteBooking(ProgramMng programMng, String fname, String code, String reservationDate, String reservationTime) {
        String name = fname; //시설 이름
        String sheetname = code; //좌석번호
        String date = reservationDate; //예약 날짜
        String time = reservationTime; //예약 시간
        Manageable m = programMng.find(name);
        Sheet sheet = m.getSheet(sheetname);
        String[] time_split = time.split("-");
        int startHour = Integer.parseInt(time_split[0]);
        int endHour = Integer.parseInt(time_split[1]);

        BookingInfo removeBookingInfo = sheet.findBookigInfo(programMng.user, date, startHour, endHour);
        sheet.bookingInfo.remove(removeBookingInfo);
        programMng.user.bookingList.remove(removeBookingInfo);

    }
}

