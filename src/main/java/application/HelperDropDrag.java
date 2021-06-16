package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperDropDrag extends HelperBase{
    public HelperDropDrag(WebDriver wd) {
        super(wd);
    }

    public void selectItemInteractions() {
        hideFooter();
        click(By.xpath("//h5[.='Interactions']"));
    }
}
