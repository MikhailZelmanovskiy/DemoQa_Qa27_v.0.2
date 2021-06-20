import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest extends TestBase{

    @BeforeMethod
    public void preconditions(){
        app.alert().selectItemAlert();
        app.alert().selectAlerts();
    }

    @Test
    public void alertTest(){
        app.alert().pause(2000);

    }
}
