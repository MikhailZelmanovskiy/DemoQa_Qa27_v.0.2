import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDragTests extends TestBase{
    @BeforeMethod
    public void preconditions(){
        app.dropDrag().selectItemInteractions();
    }

    @Test
    public void dropDragTest(){

    }
}
