package application;

import models.StudentForm;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class HelperForm extends HelperBase {
    public HelperForm(WebDriver wd) {
        super(wd);
    }

    public void selectItemForms() {
        click(By.xpath("//div[@class='category-cards']/div[2]"));
        pause(500);
    }

    public void selectPracticeForm() {
        click(By.xpath("//span[.='Practice Form']"));
    }

    public void fillForm(StudentForm form) {
        type(By.id("firstName"), form.getFirstName());
        type(By.id("lastName"), form.getLastName());
        type(By.id("userEmail"), form.getEmail());
        selectGender(form.getGender());
        type(By.id("userNumber"), form.getPhone());
        //typeBDay(form.getBirthday());
        selectBDay(form.getBirthday());
        selectSubject(form.getSubject());
        selectHobbies(form.getHobbies());
        type(By.id("currentAddress"), form.getAddress());
        selectState(form.getState());
        selectCity(form.getCity());

    }

    private void selectCity(String city) {
        WebElement el =wd.findElement(By.id("react-select-4-input"));
        new Actions(wd).sendKeys(el,city).perform();
        el.sendKeys(Keys.ENTER);
    }

    private void selectState(String state) {
//        type(By.id("react-select-3-input"),state);
//        wd.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
        WebElement el = wd.findElement(By.id("react-select-3-input"));
        new Actions(wd).sendKeys(el,state).perform();
        el.sendKeys(Keys.ENTER);

    }

    private void selectSubject(String subject) {
        type(By.id("subjectsInput"),subject);
        wd.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
    }

    private void selectHobbies(String hobbies) {
        if(hobbies.equals("Sport")){
            click(By.xpath("//label[@for='hobbies-checkbox-1']"));
        }else if(hobbies.equals("Reading")){
            click(By.xpath("//label[@for='hobbies-checkbox-2']"));
        }else if(hobbies.equals("Music")){
            click(By.xpath("//label[@for='hobbies-checkbox-3']"));
        }
    }

    private void typeBDay(String birthday) {
        WebElement bday = wd.findElement(By.id("dateOfBirthInput"));
        bday.click();
        //click(By.id("dateOfBirthInput"));

        String os = System.getProperty("os.name");
        System.out.println(os);
        if (os.startsWith("Mac")) {
            bday.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            bday.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        bday.sendKeys(birthday);
        bday.sendKeys(Keys.ENTER);
    }

    private void selectGender(String gender) {
        if(gender.equals("Male")){
            click(By.xpath("//label[@for='gender-radio-1']"));
        }else if(gender.equals("Female")){
            click(By.xpath("//label[@for='gender-radio-2']"));
        }else{
            click(By.xpath("//label[@for='gender-radio-3']"));
        }
    }


    public void savenewStudent() {
        click(By.id("submit"));
    }

    public boolean isDialogDispleyed() {
        return wd.findElement(By.id("example-modal-sizes-title-lg")).getText().contains("Thanks");
    }

    public void closeDialog(){
        click(By.id("closeLargeModal"));
    }
    private void selectBDay (String bday){
        // click by textbox bday
        //select month [aprel]
        //select year [1990]
        //select day [26]

    }
    public void uploadPicture() {
        wd.findElement(By.id("uploadPicture"))
                .sendKeys("/Users/tayahatum/QA27/DemoQa_Qa27_v.0.2/girl.jpeg");
    }


    private void selectBDay5(String bDay){
        List<String> date= Arrays.asList(bDay.split(" "));

        click(By.id("dateOfBirthInput"));

        new Select(wd.findElement(By.xpath("//select[@class='react-datepicker__month-select']"))).selectByVisibleText(date.get(1));
        new Select(wd.findElement(By.xpath("//select[@class='react-datepicker__year-select']"))).selectByVisibleText(date.get(2));


        //String locator = "//div[text()='\"+date.get(0)+\"']";
        String locator = "//div[text()='3']";
        int a=3;
        String locator1 = "//div[text()='"+date.get(0)+"']";
        List<WebElement> ar = wd.findElements(By.xpath(locator));

        for (WebElement el:ar) {
            if(el.getAttribute("aria-label").contains(date.get(1))){
                el.click();
            }
        }
    }
    private void selectBDay6(String bday){

        String [] data=bday.split(" ");
        click(By.id("dateOfBirthInput"));
        new Select(wd.findElement(By.xpath("//select[@class='react-datepicker__month-select']"))).selectByVisibleText(data[1]);
        new Select(wd.findElement(By.xpath("//select[@class='react-datepicker__year-select']"))).selectByVisibleText(data[2]);

        int day= Integer.parseInt(data[0]);

         List<WebElement> list =wd.findElements(By.xpath(String.format("//div[text()='%s']",data[0])));

         WebElement element;
         if(list.size()>1 && day>15){
             element=list.get(1);
         }else {
             element=list.get(0);
         }

        element.click();
    }

}
