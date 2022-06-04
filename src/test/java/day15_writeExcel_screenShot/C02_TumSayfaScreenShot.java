package day15_writeExcel_screenShot;
import com.github.javafaker.DateAndTime;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class C02_TumSayfaScreenShot extends TestBase {
    @Test
    public void tumSayfa() throws IOException {
        // amazon sayfasina gidip tum sayfanin fotografini cekelim
        driver.get("https://www.amazon.com");
        TakesScreenshot ts = (TakesScreenshot) driver;             // 1. adim
        LocalDateTime date=LocalDateTime.now();                     // 5. adim
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYMMddHHmmss");     //6.adim
        String tarih = date.format(dtf);                        // 7.adim

        // dinamik yapmak icin tarih eklendi

        File tumSayfaResim= new File("target/ekranGoruntuleri/tumSayfa"+tarih+".jpeg"); // 2. adim
        File geciciDosya= ts.getScreenshotAs(OutputType.FILE);                                  // 3 . adim
        FileUtils.copyFile(geciciDosya,tumSayfaResim);                                        // 4. adim
    }
}