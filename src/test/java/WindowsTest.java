import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTest extends TestBase{

    @BeforeMethod
    public void preconditions(){
        app.alert().selectItemAlert();
        app.windows().selectBrowserWindows();
    }

    @Test
    public void fromToWindowsTest(){
        app.alert().clickNewWindow();
        Assert.assertTrue(app.windows().getTextNewTab().contains("sample"));
    }
}
