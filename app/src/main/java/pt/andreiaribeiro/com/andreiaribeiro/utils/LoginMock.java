package pt.andreiaribeiro.com.andreiaribeiro.utils;

public class LoginMock {

    public static boolean doLogin(String username, String password) {
        return username.equalsIgnoreCase("userfixe@gmail.com") & password.equalsIgnoreCase("pass");
    }

}
