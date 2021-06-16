package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowsHelper extends HelperBase{
    public WindowsHelper(WebDriver wd) {
        super(wd);
    }

    public void selectBrowserWindows() {
        click(By.xpath("//span[.='Browser Windows']"));
    }
}
