package mgr;

import Booking.User;
import Fields.*;
import Rooms.*;
import UI.UIMng;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ProgramMng {

    ArrayList<String> weekDates = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    Scanner scanner = new Scanner(System.in);
    public ArrayList<Manageable> mList = new ArrayList<>();

    public User user = null;

    static ArrayList<User> userList = new ArrayList<>();

    private static ProgramMng instance = new ProgramMng();

    private ProgramMng() {
    }

    public static ProgramMng getInstance() {
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

    public boolean login(String code, String password) {
        for (User u : userList) {
            if (u.login(code, password)) {
                this.user = u;
                return true;
            }
        }
        return false;
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

    //유저정보 추가하는 메소드
    void readUData() {
        Scanner file = openFile("InputData/user_input.txt");
        User u = null;
        while (file.hasNext()) {
            u = new User();
            u.read(file);
            userList.add(u);
        }
    }

    //예약정보 읽어와서 추가하는 메소드
    void readRSData() {
        Scanner file = openFile("InputData/reservation_input.txt"); //예약 날짜는 발표 날짜에 따라 수정해야 함
        Manageable m = null;
        Sheet s = null;
        User u = null;
        while (file.hasNext()) {
            String name = file.next();
            String sheetname = file.next();
            String date = file.next();
            String time = file.next();
            String userCode = file.next();
            m = find(name);
            if (!m.IsNotSheet())
                s = m.getSheet(sheetname);
            u = findUser(userCode);
            String[] time_split = time.split("-");
            int starttime = Integer.parseInt(time_split[0]);
            int endtime = Integer.parseInt(time_split[1]);
            m.IsBooking(s, u, date, starttime, endtime);

        }
    }

    public Manageable find(String name) {
        for (Manageable m : mList) {
            if (m.matches(name))
                return m;
        }
        return null;
    }

    //날짜가 유효한지 검사하는 메소드 (익일로부터 7일)
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

    User findUser(String code) {
        for (User u : userList) {
            if (u.matches(code))
                return u;
        }
        return null;
    }

    public boolean isRooms(Manageable m) {
        if (m instanceof AgoraRoom || m instanceof KMaruRoom || m instanceof TeamProjectRoom)
            return true;
        return false;
    }

    public void run() {
        getWeekDateAndDay();
        readRData();
        readFData();
        readUData();
        readRSData();
        //function 패키지에 이벤트 처리 메소드 있습니다. (static 선언 해놓음)
    }

    public static void Main(String[] args)
    {
        ProgramMng.getInstance().run();
    }
}