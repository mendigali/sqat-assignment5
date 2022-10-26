package tests;

import org.testng.annotations.Test;
import java.lang.reflect.Method;

import static utils.ExtentTestManager.startTest;

public class LoginTests extends BaseTest {
    @Test(priority = 0, description = "Successful login test case.")
    public void successfulUserLogin(Method method) {
        startTest(method.getName(), "Successful login test case.");

        loginPage
                .open()
                .login("standard_user", "secret_sauce");
    }

    @Test(priority = 1, description = "Invalid login test case with wrong error message.")
    public void invalidUserLoginWithWrongErrorMsg(Method method) {
        startTest(method.getName(), "Invalid login test case.");

        loginPage
                .open()
                .login("wrong_user", "qwerty123")
                .verifyLoginUsernameAndPassword("EEEpic sadface: Username and password do not match any user in this service");
    }

    @Test(priority = 2, description = "Invalid login test case with wrong error message.")
    public void invalidUserLoginWithTrueErrorMsg(Method method) {
        startTest(method.getName(), "Invalid login test case.");

        loginPage
                .open()
                .login("wrong_user", "qwerty123")
                .verifyLoginUsernameAndPassword("Epic sadface: Username and password do not match any user in this service");
    }
}