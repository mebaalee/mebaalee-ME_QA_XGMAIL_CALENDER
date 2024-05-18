package demo;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
        
        // This is to remove unnecessary warnings from your console
        System.setProperty("java.util.logging.config.file", "logging.properties");
        
        TestCases tests = new TestCases(); // Initialize your test class

        //TODO: call your test case functions one after other here
        //Before run these Test cases,
        //In the Terminal, Type "python chrome-run.py" and hit Enter
        //It ll open a new chrome window
        //Now we can run the Test cases
        tests.testCase01();
        tests.testCase02();
        tests.testCase03();
        tests.testCase04();

        //END Tests


        tests.endTest(); // End your test by clearning connections and closing browser
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}
