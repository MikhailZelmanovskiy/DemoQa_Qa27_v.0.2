import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest extends TestBase{

    @BeforeMethod(enabled = false)
    public void preconditions(){
        app.alert().selectItemAlert();
        app.alert().selectAlerts();
    }

    @Test
    public void alertTest(){
        app.alert().selectAlerts();
        app.alert().clickToSeeAlert();
    }
    @Test
    public void alertTestConfirm(){
        app.alert().selectAlerts();
        app.alert().confirmAlert("ok");
    }
}
