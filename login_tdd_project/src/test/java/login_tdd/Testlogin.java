package login_tdd;

import com.login_tdd.Game;
import com.login_tdd.Login;
import com.login_tdd.LoginFail;
import com.login_tdd.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Testlogin {
    List<User> users = new ArrayList<User>();
    User user = new User("testUser", "password");
    Login login = new Login();
    String token = login.loginCheck("anna", "losen");
    Game game = new Game();

    public Testlogin() throws LoginFail {
    }

    @BeforeEach
    void setUp() {

        users = login.getValidUsers();

    }

    @Test
    void create_user_success() {
        assertNotNull(user);
    }

    @Test
    void test_login_fail() {

        LoginFail loginFail =
                assertThrows(LoginFail.class, () -> login.loginCheck("Fail", users.get(0).getPassword()));

        assertEquals("You are not a valid user", loginFail.getMessage());
    }

    @Test
    void test_login_success() throws LoginFail {
        assertEquals(36, login.loginCheck("anna", "losen").length());
        System.out.println(login.loginCheck("anna", "losen"));

    }

    @Test
    void test_bad_token() throws LoginFail {

        assertEquals("Not valid", token);
    }

    @Test
    void test_good_token() throws LoginFail {

        assertEquals(36, token.length());
    }

    @Test
    void test_game() throws LoginFail {
        System.out.println("Token: " + token);
        assertEquals(false, game.playGame(token));
    }

}













