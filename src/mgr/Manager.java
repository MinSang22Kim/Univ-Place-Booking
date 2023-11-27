package mgr;

import Booking.BookingInfo;
import Booking.User;
import Fields.*;
import UI.Rooms.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    ArrayList<String> weekDates = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    Scanner scanner = new Scanner(System.in);
    ArrayList<Manageable> mList = new ArrayList<>();

    static ArrayList<User> userList = new ArrayList<>();

    private static Manager instance = new Manager();

    private Manager() {
    }

    public static Manager getInstance() {
        return instance;
    }

    Scanner openFile(String filename) {
        Scanner filein = null;
        try {
            filein = new Scanner(new File(filename));
        } catch (IOException e) {
            System.out.println("파일 입력 오류");
            System.exit(0);
        }
        return filein;
    }


    void printAllRooms() {
        for (Manageable m : mList)
            m.print();
    }

    void readRData() {
        Scanner file = openFile("InputData/study_input.txt");
        while (file.hasNext()) {
            Manageable m = null;
            switch (file.nextInt()) {
                case 1:
                    m = new TeamProjectRoom(1);
                    break;
                case 2:
                    m = new AgoraRoom(2);
                    break;
                case 3:
                    m = new KMaruRoom(3);
                    break;
            }
            m.read(file);
            mList.add(m);
        }
    }

    void readFData() {
        Scanner file = openFile("InputData/sport_input.txt");
        while (file.hasNext()) {
            Manageable m = null;
            switch (file.nextInt()) {
                case 1:
                    m = new FutsalField(1);
                    break;
                case 2:
                    m = new SoccerField(2);
                    break;
                case 3:
                    m = new BasketballField(3);
                    break;
                case 4:
                    m = new FootVolleyballField(4);
                    break;
                case 5:
                    m = new TennisField(5);
                    break;
                case 6:
                    m = new TableTennisField(6);
                    break;
            }
            m.read(file);
            mList.add(m);
        }
    }

    Manageable find(String name) {
        for (Manageable m : mList) {
            if (m.matches(name))
                return m;
        }
        return null;
    }

    void Search() {
        System.out.println("검색 방법을 선택하세요.");
        System.out.print("(1) 장소(좌석) 검색 (2) 예약검색 (기타) 나가기 : ");
        int select = scanner.nextInt();
        String name;
        switch (select) {
            case 1:
                System.out.print("장소명 또는 코드, 좌석 번호를 입력하세요 : ");
                name = scanner.next();
                for (Manageable m : mList)
                    if (m.matches(name))
                        m.bookingPrint();
                break;
            case 2:
                System.out.print("예약자의 학번 또는 이름을 입력하세요 : ");
                name = scanner.next();
                for (Manageable m : mList) {
                    m.bookingMatchesUser(name);
                }
                break;
        }

    }

    void Booking() {
        User user = null;
        String date = null;
        String time = null;
        System.out.print("예약할 장소의 이름 또는 코드를 입력해 주세요 : ");
        Manageable m = null;
        while (true) {
            String name = scanner.next();
            m = find(name);

            if (m != null)
                break;
            else {
                System.out.print("해당 장소의 이름 또는 코드를 가진 곳이 없습니다. 다시 입력해 주세요 : ");
            }
        }

        Sheet sheet = null;
        if (m.IsNotSheet() == false) {
            m.print();
            System.out.print("좌석(구역)을 입력해 주세요 : ");
            while (true) {
                String sheetname = scanner.next();

                sheet = m.getSheet(sheetname);

                if (sheet != null)
                    break;
                else {
                    System.out.print("해당되는 좌석(구역)이 없습니다. 다시 입력해 주세요 : ");
                }
            }
        }
        while (true) {
            System.out.print("예약자의 학번을 입력해주세요. : ");
            String code = scanner.next();
            System.out.print("예약자의 이름을 입력해주세요. : ");
            String name = scanner.next();

            user = findUser(code, name);
            if (user != null) {
                break;
            }
        }
        while (true) {
            System.out.print("예약 날짜를 입력해 주세요.(예시 2023-10-10) : ");
            date = scanner.next();
            if (!checkValid(date)) {
                System.out.println("예약할 수 없는 날짜입니다. 다른 날짜를 선택해주세요.");
                continue;
            }
            System.out.print("예약 시간을 입력해 주세요.(예시 10-12) : ");
            time = scanner.next();
            String[] time_split = time.split("-");
            int starttime = Integer.parseInt(time_split[0]);
            int endtime = Integer.parseInt(time_split[1]);
            if (starttime > 24 || endtime > 24) {
                System.out.println("유효하지 않은 시간대입니다. 다시 입력해주세요.");
                continue;
            }
            if (user.check(date, starttime, endtime)) {
                System.out.println("동일 시간에 다른 곳을 예약 했으므로 예약할 수 없습니다!");
                continue;
            }
            if (m.IsBooking(sheet, user, date, starttime, endtime)) {
                System.out.println("예약이 성공적으로 이루어졌습니다!\n");
                user.bookingList.add(new BookingInfo(user, date, starttime, endtime));
                break;
            } else {
                System.out.println("해당 시간에 이미 예약이 있습니다. 다른 날짜를 선택해 주세요.\n");
                continue;
            }
        }
    }

    void Check() {
        System.out.print("조회할 장소의 이름 또는 코드를 입력해 주세요.(전체를 조회하려면 \"ALL\"을 입력하세요) : ");
        String name = scanner.next();
        if (name.equals("ALL")) {
            for (Manageable m : mList)
                m.bookingPrint();
        } else {
            Manageable m = find(name);

            if (m.IsNotSheet() == false) {
                System.out.print("조회할 좌석번호를 입력해 주세요.(전체를 조회하려면 \"ALL\"을 입력하세요) : ");
                String sheetname = scanner.next();
                if (sheetname.equals("ALL"))
                    m.bookingPrint();
                else
                    m.getSheet(sheetname).print();
            } else {
                m.bookingPrint();
            }
        }


    }

    public boolean checkValid(String date) {
        return weekDates.contains(date);
    }

    public void getWeekDateAndDay() {
        LocalDate currentDate = LocalDate.now();
        for (int i = 1; i <= 7; i++) {
            LocalDate date = currentDate.plusDays(i);
            String dateOfWeek = date.format(formatter);
            weekDates.add(dateOfWeek);
        }

    }

    User findUser(String code, String name) {
        for (User u : userList) {
            if (u.matches(code, name))
                return u;
            else if (u.matches(code)) {
                System.out.println("동일한 학번의 다른 유저가 이미 존재합니다!");
                return null;
            }
        }
        User u = new User(code, name);
        userList.add(u);
        return u;
    }

    public void run() {
        int num = 0;
        getWeekDateAndDay();
        readRData();
        readFData();
        while (true) {
            System.out.println("(1)예약 (2)검색 (3)조회 (기타)종료 : ");
            num = scanner.nextInt();
            switch (num) {
                case 1:
                    Booking();
                    break;
                case 2:
                    Search();
                    break;
                case 3:
                    Check();
                    break;
                default:
                    return;
            }
        }
    }
}

