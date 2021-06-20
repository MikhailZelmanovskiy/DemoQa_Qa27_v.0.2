package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.nio.charset.Charset;

public class WindowsHelper extends HelperBase{
    public WindowsHelper(WebDriver wd) {
        super(wd);
    }

    public void selectBrowserWindows() {
        click(By.xpath("//span[.='Browser Windows']"));
    }

    public String getTextNewTab() {
        return wd.findElement(By.id("SampleHeading")).getText();
    }
}
