package practice.ders_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Q6_A {
    /*
      ...Exercise6...
   // 1. Amazon.com'a gidelim.
   // 2. DropDown üzerinde Books secelim.(All yazan yerde)
   //    kategorilerin hepsini konsola yazdiralim
   // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
   // 4. Sonuc sayisini ekrana yazdiralim.
   // 5. Sonucların Les Miserables i icerdigini assert edelim
   */
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void afterClass() {
        driver.close();
    }
    @Test
    public void test() {

        // 1. Amazon.com'a gidelim.
        driver.get("https://amazon.com");

        // 2. DropDown üzerinde Books secelim.(All yazan yerde)
        WebElement dd = driver.findElement(By.xpath("//*[@aria-describedby='searchDropdownDescription']"));
        Select select = new Select(dd);
        select.selectByVisibleText("Books");

        //    kategorilerin hepsini konsola yazdiralim
        List<WebElement>all = select.getOptions();
        for (WebElement each:all) {
            System.out.println("karakterler : "+each.getText());
        }

        // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Les Miserables"+ Keys.ENTER);

        // 4. Sonuc sayisini ekrana yazdiralim.
        System.out.println("sonuc sayisi : "+driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"))
                .getText());

        // 5. Sonucların Les Miserables i icerdigini assert edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"))
                .getText().contains("Les Miserables"));


    }
}
