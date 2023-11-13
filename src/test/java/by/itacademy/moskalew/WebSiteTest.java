package by.itacademy.moskalew;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebSiteTest {
    @Test
    public void testOnlinerLoginButton() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.onliner.by/");
        OnlinerbyPage onlinerbyPage = new OnlinerbyPage();
        driver.findElement(By.xpath(onlinerbyPage.buttonLogin)).click();
        Assertions.assertEquals("Вход", driver.findElement(By.xpath(onlinerbyPage.enterTitleAuthForm)).getText());
        driver.close();
    }

    @Test
    public void devBy() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://devby.io/");
        DevbyioPage devbyioPage = new DevbyioPage();
        driver.findElement(By.xpath(devbyioPage.buttonLogin)).click();
        Thread.sleep(1000);
        Assertions.assertEquals("Вход", driver.findElement(By.xpath(devbyioPage.enterTitleAuthForm)).getText());
        driver.close();
    }

    @Test
    public void testJavaRush() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://javarush.com/");
        JavarushruPage javarushruPage = new JavarushruPage();
        driver.findElement(By.xpath(javarushruPage.enterButton)).click();
        Assertions.assertEquals("НАЧАТЬ", driver.findElement(By.xpath(javarushruPage.enterTitleAuthForm)).getText());
        driver.close();
    }

    @Test
    public void testOnliner() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.onliner.by/");
        OnlinerbyPage onlinerbyPage = new OnlinerbyPage();
        driver.findElement(By.xpath(onlinerbyPage.buttonLogin)).click();
        driver.findElement(By.xpath(onlinerbyPage.buttonEnter)).click();
        Assertions.assertEquals("Укажите ник или e-mail", driver.findElement(By.xpath(onlinerbyPage.errorMassageLogin)).getText());
        Assertions.assertEquals("Укажите пароль", driver.findElement(By.xpath(onlinerbyPage.errorMassagePassword)).getText());
        driver.close();
    }

    @Test
    public void testOnlinerx() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.onliner.by/");
        OnlinerbyPage onlinerbyPage = new OnlinerbyPage();
        driver.findElement(By.xpath(onlinerbyPage.buttonLogin)).click();
        driver.findElement(By.xpath(onlinerbyPage.inputLogin)).sendKeys("test");
        driver.findElement(By.xpath(onlinerbyPage.buttonEnter)).click();
        Thread.sleep(1000);
        Assertions.assertEquals("Укажите пароль", driver.findElement(By.xpath(onlinerbyPage.errorMassagePassword)).getText());
        driver.close();
    }

    @Test
    public void testDevByLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://devby.io/");
        DevbyioPage devbyioPage = new DevbyioPage();
        driver.findElement(By.xpath(devbyioPage.buttonLogin)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(devbyioPage.inputLogin)).sendKeys("test");
        driver.findElement(By.xpath(devbyioPage.inputPassword)).sendKeys("test");
        driver.findElement(By.xpath(devbyioPage.buttonEnter)).click();
        Thread.sleep(1000);
        Assertions.assertEquals("Неверный логин или пароль.", driver.findElement(By.xpath(devbyioPage.errorMassage)).getText());
        driver.close();
    }

    @Test
    public void testAvBy() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://av.by/");
        AvByPage avPage = new AvByPage();
        Thread.sleep(1000);
        driver.findElement(By.xpath(avPage.buttonEnter)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(avPage.buttonLoginOption)).click();
        driver.findElement(By.xpath(avPage.inputEmail)).sendKeys("test@test.by");
        driver.findElement(By.xpath(avPage.inputPassword)).sendKeys("testpassword");
        driver.findElement(By.xpath(avPage.buttonSubmit)).click();
        Thread.sleep(1000);
        Assertions.assertEquals("Неверный логин или пароль. Если забыли пароль, восстановите его", driver.findElement(By.xpath(avPage.errorMassage)).getText());
        driver.close();
    }
}
