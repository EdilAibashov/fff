package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Driver;

public class HomePage {
    private static WebDriver driver = Driver.getDriver();

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
        @FindBy(xpath = "//a[.='A/B Testing']")
        public WebElement AccountList;
    @FindBy(className = "nav-link")
    public WebElement selectClass;
    @FindBy(xpath = "//a[starts-with(.,'Add/Remove')]")
    public WebElement price;
    @FindBy (xpath = "//a[.='Autocomplete']")
    public WebElement print;
    @FindBy(id = "myCountry")
    public WebElement country;
    @FindBy(id = "myCountry")
    public WebElement CountContey;
    @FindBy(id = "myCountryautocomplete-list")
    public WebElement key;
    @FindBy(xpath = "//input[@type='button']")
    public WebElement button;
    @FindBy(xpath = "//p[@id='result']")
    public WebElement selected;
    @FindBy(xpath = "//a[.='Drag and Drop']")
    public WebElement drop;
    @FindBy(id = "column-a")
    public WebElement columA;
    @FindBy(id = "column-b")
    public WebElement columB;




}

