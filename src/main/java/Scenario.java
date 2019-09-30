import com.sun.deploy.util.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario {

    public static void main(String... args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

        WebElement element;

        //----------Scenario steps:----------------
        driver.navigate().to("https://www.rgs.ru/");
        driver.findElement(By.className("hidden-xs")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'dms/generalinfo')]")).click();
        System.out.println("Title Рассчитать стоимость добровольного медицинского страхования: " + driver.findElement(By.xpath("//title[text()[contains(., 'Рассчитать стоимость добровольного медицинского страхования')]]")).isEnabled());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()[contains(., 'Отправить')]]"))));
        driver.findElement(By.xpath("//a[text()[contains(., 'Отправить')]]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()[contains(., 'Заявка на добровольное медицинское страхование')]]"))));
        System.out.println("Displayed Заявка на добровольное медицинское страхование: " + driver.findElement(By.xpath("//*[text()[contains(., 'Заявка на добровольное медицинское страхование')]]")).isDisplayed());
        driver.findElement(By.xpath("//input[contains(@name, 'FirstName')]")).sendKeys("Иван");
        driver.findElement(By.xpath("//input[contains(@name, 'LastName')]")).sendKeys("Иванов");
        driver.findElement(By.xpath("//input[contains(@name, 'MiddleName')]")).sendKeys("Иванович");
        driver.findElement(By.xpath("//input[contains(@name, 'Email')]")).sendKeys("qwertyqwerty");
        driver.findElement(By.xpath("//input[contains(@name, 'ContactDate')]")).clear();
        driver.findElement(By.xpath("//input[contains(@name, 'ContactDate')]")).sendKeys("21.12.2019");
//        driver.findElement(By.xpath("//input[contains(@data-bind, 'Phone')]")).clear();
//        driver.findElement(By.xpath("//input[contains(@data-bind, 'Phone')]")).sendKeys("1111111111");
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("arguments[0].value='111111111';", driver.findElement(By.xpath("//input[contains(@data-bind, 'Phone')]")));
//        jse.executeScript("arguments[0].value='21122019';", driver.findElement(By.xpath("//input[contains(@name, 'ContactDate')]")));

        new Actions(driver).moveToElement(driver.findElement(By.xpath("//input[contains(@data-bind, 'Phone')]"))).click().sendKeys(driver.findElement(By.xpath("//input[contains(@data-bind, 'Phone')]")),"1111111111").build().perform();

        new Select(driver.findElement(By.tagName("select"))).selectByVisibleText("Московская область");

        driver.findElement(By.xpath("//input[contains(@type, 'checkbox')]")).click();
        driver.findElement(By.xpath("//button[text()[contains(., 'Отправить')]]")).click();


    }

}
