import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDragTest extends TestBase{

    @BeforeMethod
    public void preconditions(){
        app.dropDrag().selectItemInteractions();
    }

    @Test
    public void dragMeTest(){
        app.dropDrag().selectDroppable();
        app.dropDrag().actionDragMe();


    }
    @Test
    public void dragAndDropByTest(){
        app.dropDrag().selectDroppable();
        app.dropDrag().dragAndDropBy();
    }
    @Test
    public void dragAndDropBy100Test(){
        app.dropDrag().selectDroppable();
        app.dropDrag().dragAndDropBy100();
    }
}
