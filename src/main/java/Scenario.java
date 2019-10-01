import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario {

    public static void main(String... args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

        //----------Scenario steps:----------------
        driver.navigate().to("https://www.rgs.ru/");
        driver.findElement(By.className("hidden-xs")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'dms/generalinfo')]")).click();
        System.out.println("Title Рассчитать стоимость добровольного медицинского страхования: " + driver.findElement(By.xpath("//title[text()[contains(., 'Рассчитать стоимость добровольного медицинского страхования')]]")).isEnabled());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()[contains(., 'Отправить')]]"))));
        driver.findElement(By.xpath("//a[text()[contains(., 'Отправить')]]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()[contains(., 'Заявка на добровольное медицинское страхование')]]"))));
        System.out.println("Displayed Заявка на добровольное медицинское страхование: " + driver.findElement(By.xpath("//*[text()[contains(., 'Заявка на добровольное медицинское страхование')]]")).isDisplayed());
        new Select(driver.findElement(By.tagName("select"))).selectByVisibleText("Московская область");
        driver.findElement(By.xpath("//input[contains(@name, 'FirstName')]")).sendKeys("Иван");
        driver.findElement(By.xpath("//input[contains(@name, 'LastName')]")).sendKeys("Иванов");
        driver.findElement(By.xpath("//input[contains(@name, 'MiddleName')]")).sendKeys("Иванович");
        driver.findElement(By.xpath("//input[contains(@name, 'Email')]")).sendKeys("qwertyqwerty@");
        driver.findElement(By.xpath("//input[contains(@name, 'ContactDate')]")).click();
        driver.findElement(By.xpath("//input[contains(@name, 'ContactDate')]")).sendKeys("21.12.2019");
        driver.findElement(By.xpath("//input[contains(@name, 'MiddleName')]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[contains(text(), 'Телефон')]"))));
        driver.findElement(By.xpath("//input[contains(@data-bind, 'Phone')]")).click();
        driver.findElement(By.xpath("//input[contains(@data-bind, 'Phone')]")).sendKeys("+79992002299");

        driver.findElement(By.xpath("//input[contains(@type, 'checkbox')]")).click();
        driver.findElement(By.xpath("//button[text()[contains(., 'Отправить')]]")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(), 'Введите адрес электронной почты')]"))));
        System.out.println("Displayed Введите адрес электронной почты: " + driver.findElement(By.xpath("//span[contains(text(), 'Введите адрес электронной почты')]")).isDisplayed());


    }

}
