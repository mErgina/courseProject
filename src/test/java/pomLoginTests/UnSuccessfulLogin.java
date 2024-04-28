package pomLoginTests;

import baseTestCase.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pomPages.LoginPage;


public class UnSuccessfulLogin extends TestUtil {


        @Test
        public void unsuccessfulLogin(){
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("wrong_user", "secret_sauce");

            Assert.assertTrue(loginPage.isAt());
        }

    }

