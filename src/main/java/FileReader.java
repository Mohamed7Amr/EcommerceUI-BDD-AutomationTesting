import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileReader {

    public static void main (String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver.get("http://magento-demo.lexiconn.com/");
        driver.manage().window().maximize();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//span[contains(text(),'Subscribe')]")));

        WebElement imageElement = driver.findElement(By.xpath("//img[@src='http://cdn.magento-demo.lexiconn.com/skin/frontend/rwd/default/images/media/logo.png'"));
        File src = imageElement.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("./target/captcha.png"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ITesseract image = new Tesseract();
        try {
            String str = image.doOCR(new File("./target/captcha.png"));
        } catch (TesseractException e) {
            throw new RuntimeException(e);
        }
    }

//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(scrFile, new File("./target/HomePage.png"));
//
//        File f = new File("trial.txt");
//        try {
//            f.createNewFile();
//            FileWriter fw = new FileWriter(f);
//            fw.write("hello from the other world");
//            fw.flush();
//            fw.close();
//
//            BufferedReader reader = new BufferedReader(new java.io.FileReader(f));
//
//            String line;
//            while((line = reader.readLine()) != null)
//            {
//                System.out.println(line);
//            }
//            reader.close();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
