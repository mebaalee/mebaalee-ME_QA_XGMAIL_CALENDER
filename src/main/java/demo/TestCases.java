package demo;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.List;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestCases {
    ChromeDriver driver;

    public TestCases() throws InterruptedException {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }


    public void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        driver.get("https://calendar.google.com/");
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Thread.sleep(5000);
        String url = driver.getCurrentUrl();
        if (url.contains("calendar")) {
            System.out.println("The Home page contains calendar");
        } else
            System.out.println("The Home page doesn't contains calendar");
        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        //click on any date
        driver.findElement(By.xpath("(//div[contains(@class,'MGaLHf elYzab-cXXICe-Hjleke')])[22]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'MGaLHf elYzab-cXXICe-Hjleke')])[22]")));
        Thread.sleep(2000);
        //click on task tab
        driver.findElement(By.id("tabTask")).click();
        Thread.sleep(2000);
        //click on title
        WebElement title = driver.findElement(By.xpath("//input[@placeholder='Add title and time']"));
        Thread.sleep(2000);
        //Send title
        title.sendKeys("Crio INTV Task Automation");
        Thread.sleep(2000);
        //move to description
        WebElement description = driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
        Thread.sleep(2000);
        //Send Description
        description.sendKeys("Crio INTV Calendar Task Automation");
        Thread.sleep(2000);
        //Click on save
        driver.findElement(By.xpath("//button[@jsname='x8hlje']")).click();
        Thread.sleep(2000);
        System.out.println("end Test case: testCase02");
        Thread.sleep(2000);
    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        Thread.sleep(2000);
        //Click on the existing task
        driver.findElement(By.xpath("//span[contains(text(), 'Crio INTV Task Automation')]")).click();
        Thread.sleep(2000);
        //Click on the edit
        driver.findElement(By.xpath("//button[contains(@jsname, 'DyVDA')]")).click();
        Thread.sleep(2000);
        //move to description
        WebElement description = driver.findElement(By.xpath("//textarea[text()='Crio INTV Calendar Task Automation']"));
        Thread.sleep(2000);
        //Click on description
        description.click();
        Thread.sleep(2000);
        //clear the description
        description.clear();
        Thread.sleep(2000);
        //send updated description
        description.sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
        Thread.sleep(2000);
        //Click on save
        driver.findElement(By.xpath("//button[contains(@jsname,'x8hlje')]")).click();
        Thread.sleep(2000);
        //Click on the existing task
        driver.findElement(By.xpath("//span[contains(text(), 'Crio INTV Task Automation')]")).click();
        Thread.sleep(2000);
        //Click on the description
        String descriptionText = driver.findElement(By.xpath("//div[@class='toUqff D29CYb']")).getText();
        Thread.sleep(2000);
        if (descriptionText.contains("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application")) {
            System.out.println("Description updated");
        } else
            System.out.println("Description not updated");
        driver.findElement(By.xpath("//button[contains(@jsname,'LgbsSe')]")).click();

        System.out.println("end Test case: testCase03");
    }



    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04");
        driver.get("https://calendar.google.com/");
        Thread.sleep(10000);

        //Click on the existing task
        driver.findElement(By.xpath("//span[contains(@class,'WBi6vc') and contains(text(), 'Crio INTV Task Automation')]")).click();
        //driver.findElement(By.xpath("//div[contains (@class, 'KF4T6b KKjvXb jKgTF QGRmIf')]")).click();
//        driver.findElement(By.xpath("(//span[@class='nHqeVd'])[2]")).click();
        Thread.sleep(2000);

        //Click on the delete button
        //driver.findElement(By.xpath("//div[@id='tt-c2629' and text()='Delete task']")).click();
        driver.findElement(By.xpath("//button[@jsname='VkLyEc']")).click();
//        driver.findElement(By.id("gsc-gab-4")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.id("tt-c346")).click();
        Thread.sleep(2000);

        String message = driver.findElement(By.xpath("//div[contains(text(),'Task deleted')]")).getText();
        System.out.println(message);
        boolean result = message.equalsIgnoreCase("Task deleted");
        if(result){
            System.out.println("Task deleted message - verified");
        }else
            System.out.println("Task deleted message - Not verified");
        System.out.println("end Test case: testCase04");
    }
    }





