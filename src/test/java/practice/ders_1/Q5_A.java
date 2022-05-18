package practice.ders_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q5_A {
     /*
       // ...Exercise5...
       // Navigate to website  https://testpages.herokuapp.com/styled/index.html
       // Under the  ORIGINAL CONTENTS
       // click on Alerts
       // print the URL
       // navigate back
       // print the URL
       // Click on Basic Ajax
       // print the URL
       // enter value-> 20 and Enter
       // and then verify Submitted Values is displayed open page
       // close driver

        */
    WebDriver driver;
    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void after() {
        driver.close();
    }
    @Test
    public void test() {
        // "https://testpages.herokuapp.com/styled/index.html" web sitesine gidin
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // ORJİNAL İÇERİKLER altında
        // Uyarılar'a tıklayın
        driver.findElement(By.xpath("//*[text()='Alerts']")).click();

        // URL'yi yazdır
        System.out.println(driver.getCurrentUrl());

        // geri git
        driver.navigate().back();

        // URL'yi yazdır
        System.out.println(driver.getCurrentUrl());

        // Temel Ajax'a tıklayın
        driver.findElement(By.xpath("//*[text()='Basic Ajax']")).click();

        // URL'yi yazdır
        System.out.println(driver.getCurrentUrl());

        // değeri girin-> 20 ve Enter
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("20"+Keys.ENTER);

        // ve ardından Gönderilen Değerlerin açık sayfada görüntülendiğini doğrulayın
        System.out.println(driver.findElement(By.xpath("//*[text()='Submitted Values']")).isDisplayed()?"passed":"failled");


        // sürücüyü kapat
    }

}