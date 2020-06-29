package step_definitions.step_impl;


import Pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.Driver;
import util.SeleniumUtils;

import java.util.List;

public class HomePage_impl {
    public static void accountList() {
        HomePage homePage = new HomePage();
        WebDriver driver = Driver.getDriver();
        SeleniumUtils.click(homePage.AccountList);
    }
    public static void singInPage() {
        HomePage homePage = new HomePage();
        WebDriver driver = Driver.getDriver();
        SeleniumUtils.click(homePage.selectClass);
        SeleniumUtils.click(homePage.price);
        WebElement click = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for(int i = 0; i < 18; i ++){
            click.click();
        }



    }
    public static void CartPage() {
        HomePage homePage = new HomePage();
        WebDriver driver = Driver.getDriver();
        List<WebElement> delete = driver.findElements(By.className("added-manually"));
        for (WebElement d : delete){
            d.click();
        }
        driver.navigate().back();
        SeleniumUtils.click(homePage.print);
        SeleniumUtils.click(homePage.country);
        SeleniumUtils.sendKeys(homePage.CountContey,"United States of America");
        SeleniumUtils.click(homePage.key);
        SeleniumUtils.click(homePage.button);
        Assert.assertEquals("You selected: United States of America",homePage.selected.getText());
        driver.navigate().back();
        SeleniumUtils.click(homePage.drop);
        SeleniumUtils.sleep(500);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(homePage.columA,homePage.columB).perform();
        driver.navigate().back();

    }
}
