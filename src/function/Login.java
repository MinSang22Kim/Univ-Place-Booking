package function;

import mgr.Manager;

public class Login {

    public static String login(Manager manager, String code, String password) {
        if (manager.login(code, password))
            return "로그인에 성공했습니다!";
        return "로그인에 실패했습니다!";
    }
}
