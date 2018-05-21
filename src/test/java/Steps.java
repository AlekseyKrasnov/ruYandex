import org.apache.http.util.Asserts;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Steps {
    static WebDriver  driver;
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://yandex.ru/");

// Заходим в маркет
        WebElement market;
        market = driver.findElement(By.xpath("//a[@data-id='market']"));
        market.click();

        WebElement Computer;
        Computer = driver.findElement(By.xpath("//a[@class='link topmenu__link'][text()='Компьютеры']"));
        Computer.click();

        WebElement Notebook;
        Notebook = driver.findElement(By.xpath("//a[@class='link catalog-menu__list-item metrika i-bem metrika_js_inited'][text()='Ноутбуки']"));
        Notebook.click();

        WebElement Price;
        Price = driver.findElement(By.xpath("//input[@name='Цена до']"));
        Price.sendKeys("30000");
//input[@id='7893318_152722']
        //input[@name='Производитель HP']
        //span[@data-reactid='115']
        WebElement HP;
        HP = driver.findElement(By.xpath("//span[@class='NVoaOvqe58'][text()='HP']"));
//        Thread.sleep(2000);
       waitClickable(HP,2);
        HP.click();
//input[@name='Производитель Lenovo']
        WebElement Lenovo;
        Lenovo = driver.findElement(By.xpath("//span[@class='NVoaOvqe58'][text()='Lenovo']"));
        waitClickable(Lenovo,2000);
        Lenovo.click();

        String expectedTitle;
        String actualTitle;


        WebElement Elements;
        Elements = driver.findElement(By.xpath("//span[text()='Показывать по 48']"));

        waitVisible(Elements, 10);

        Thread.sleep(8000);
        WebElement FirstElement;
       String firstElement = driver.findElement(By.xpath("//div[@class='n-snippet-card2__title']")).getText();



        WebElement FindElement;
        FindElement = driver.findElement(By.xpath("//input[@id='header-search']"));
        FindElement.sendKeys(firstElement);
        FindElement = driver.findElement(By.xpath("//button[@type='submit']"));
        FindElement.click();

        WebElement asertElement;
//        String nameElement = driver.findElement(By.xpath("//h1[@class='title title_size_28 title_bold_yes']")).getText();
        asertElement = driver.findElement(By.xpath("//*[text()='"+firstElement+"']"));

        waitVisible(asertElement, 10);
//
//        waitClickable(AsertElement, 10);
        driver.close();


// FireFox
        System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://yandex.ru/");
        market.click();
        Computer.click();

        WebElement Laptop;
        Laptop = driver.findElement(By.xpath("//a[@class='link catalog-menu__list-item metrika i-bem metrika_js_inited'][text()='Планшеты']"));
        Laptop.click();
        Price.sendKeys("25000");

        WebElement Price2;
        Price2 = driver.findElement(By.xpath("//input[@name='Цена от']"));
        Price2.sendKeys("20000");


        WebElement Acer;
        Acer = driver.findElement(By.xpath("//span[contains(@class,'NVoaOvqe58')][text()='Acer']"));
//        Thread.sleep(2000);
        waitClickable(Acer,2);
        Acer.click();
//input[@name='Производитель Dell']
        WebElement Dell;
        Dell = driver.findElement(By.xpath("//span[contains(@class,'NVoaOvqe58')][text()='DELL']"));
        waitClickable(Dell,2000);
        Dell.click();
        waitVisible(Elements, 10);

        WebElement FirstLaptop;
        String firstLaptop = driver.findElement(By.xpath("//div[@class='n-snippet-card2__title']")).getText();
        FirstLaptop = driver.findElement(By.xpath("//input[@id='header-search']"));
        FirstLaptop.sendKeys(firstLaptop);
        FirstLaptop = driver.findElement(By.xpath("//button[@type='submit']"));
        FirstLaptop.click();

        WebElement asertLaptop;
//        String nameElement = driver.findElement(By.xpath("//h1[@class='title title_size_28 title_bold_yes']")).getText();
        asertLaptop = driver.findElement(By.xpath("//*[text()='"+firstLaptop+"']"));

        waitVisible(asertElement, 10);
//
//        waitClickable(AsertElement, 10);
        driver.close();
    }

   public static void waitVisible(WebElement element, int timeout) {
        element = (new WebDriverWait(driver, timeout, 500))
                .until(ExpectedConditions.visibilityOf(element));

    }

    public static void waitClickable(WebElement element, int timeout) {
        element = (new WebDriverWait(driver, timeout, 500))
                .until(ExpectedConditions.elementToBeClickable(element));

    }
}



