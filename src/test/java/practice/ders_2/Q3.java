package practice.ders_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q3 {

    /*
     ...Exercise3...
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted
    1.method : createButtons(100)
    2.deleteButtonsAndValidate()

    ..
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
        //driver.close();
    }
    @Test
    public void test() {
        // .Alıştırma3...
        //     // http://the-internet.herokuapp.com/add_remove_elements/ adresine git
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        //     // "Eleman Ekle" düğmesine 100 kez tıklayın
        driver.findElement(By.xpath("//*[@onclick='addElement()']")).click();

        //     // sayı alan ve "Sil" düğmesini tıklayan bir fonksiyon yazın


        //     // verilen sayıda ve ardından verilen sayıyı doğrular
        //     // butonlar silindi
        //     1.yöntem : createButtons(100)
        //     2.deleteButtonsAndValidate()

    }





}