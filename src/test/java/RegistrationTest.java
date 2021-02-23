import org.testng.annotations.Test;
import pages.Registration;

public class RegistrationTest extends BaseTest {

    @Test
    public void verifySignUpValidationMessage(){
        Registration.goTo();
        Registration.signUp("test", "test");

        Registration.verifyValidationMessage("This field is required", "No error message appeared under date of birth box");
    }

}

