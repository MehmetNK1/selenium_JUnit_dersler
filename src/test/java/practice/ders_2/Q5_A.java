package practice.ders_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q5_A {

    /*
       ...Exercise5...
      @BeforeClass ın icerisinde driver i kuralim
      maximize edip tum web elementler yuklenene kadar 10 sn bekletelim
      Google 'a gidelim ve sayfa basliginin "Google" icerdigini dogrulayalim
      Amazon'a gidelim ve url in "www.amazon.com" icerip icermedigini dogrulayalim
      @AfterClass ta driver ı kapatalim
       */

    static WebDriver driver;
    //@BeforeClass ın icerisinde driver i kuralim
    //maximize edip tum web elementler yuklenene kadar 10 sn bekletelim
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() {
        // Google 'a gidelim ve
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//*[text()='Kabul ediyorum']")).click();

        //sayfa basliginin "Google" icerdigini dogrulayalim
        System.out.println(driver.getTitle().contains("Google")?"Google : passed":"google : failled");
        Assert.assertTrue(driver.getTitle().contains("Google"));

        //Amazon'a gidelim ve url in "www.amazon.com" icerip icermedigini dogrulayalim
        driver.findElement(By.xpath("//*[@title='Ara']")).sendKeys("amazon"+ Keys.ENTER);

        //aramada gek´len sonuca tikladim
        driver.findElement(By.xpath("(//*[@class='LC20lb MBeuO DKV0Md'])[1]")).click();
        //cookies e tikladim
        driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).click();
        // urle dogrulama
        System.out.println(driver.getCurrentUrl().contains("www.amazon.com") ? "url : passed" : "url : failled");
        Assert.assertTrue(driver.getCurrentUrl().equals("www.amazon.com"));

    }
    //@AfterClass ta driver ı kapatalim
    @AfterClass
    public static void afterClass() {
        driver.close();
    }
}