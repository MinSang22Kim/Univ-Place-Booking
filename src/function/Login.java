package function;

import mgr.ProgramMng;

public class Login {

    public static String login(ProgramMng programMng, String code, String password) {
        if (programMng.login(code, password))
            return "로그인에 성공했습니다!";
        return "로그인에 실패했습니다!";
    }
}
