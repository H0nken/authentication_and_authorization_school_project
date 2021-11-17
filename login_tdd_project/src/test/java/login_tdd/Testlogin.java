package login_tdd;

import com.login_tdd.Login;
import com.login_tdd.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Testlogin {

    @BeforeEach
    void setUp() {

    }


    List<User> users = new ArrayList<User>();
    User user = new User("testUser", "password");


    Login login = new Login();


    @Test
    void create_user_success() {
        assertNotNull(user);
    }

    @Test
    void user_name_not_null() {

        assertNotNull(user.getUserName());
    }

    @Test
    void user_password_not_null() {

        assertNotNull(user.getPassword());
    }

    @Test
    void user_login_success() {

       assertTrue(login.loginCheck("anna", "losen"));
    }

    @Test
    void check_if_all_users_are_valid() {
        users = login.getValidUsers();
        assertTrue(login.loginCheck(users.get(0).getUserName(), users.get(0).getPassword()));
        assertTrue(login.loginCheck(users.get(1).getUserName(), users.get(1).getPassword()));
        assertTrue(login.loginCheck(users.get(2).getUserName(), users.get(2).getPassword()));
    }
}













