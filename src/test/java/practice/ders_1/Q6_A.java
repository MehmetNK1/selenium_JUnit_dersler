package practice.ders_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q6_A {
      /*
    // ...Exercise6...

     */

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void afterClass() {
        driver.close();
    }
    @Test
    public  void test() {
        //1.  https://id.heroku.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login");
        driver.findElement(By.xpath("//*[text()='Tüm Tanımlama Bilgilerini Kabul Et']")).click();

        //    2.  Bir mail adersi giriniz
        driver.findElement(By.xpath("//*[@class='form-control']")).sendKeys("asd123@gmail.com");

        //    3.  Bir password giriniz
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123asd");

        //    4.  Login butonuna tiklayiniz
        driver.findElement(By.xpath("//*[@class='btn btn-primary btn-lg btn-block']")).click();

        //    5.  "There was a problem with your login." texti gorunur ise
        //    6.  "kayit yapilamadi" yazdiriniz
        //    8.  eger yazi gorunur degilse "kayit yapildi" yazdiriniz
        System.out.println(driver.findElement(By.xpath("//*[text()='There was a problem with your login.']"))
                .isDisplayed() ? "kayit yapilamadi" : "kayit yapildi");

        //    9.  Tum sayfalari kapatiniz

    }
}