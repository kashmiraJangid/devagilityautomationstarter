package seleniumcucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;


public class Stepdefs {
    static final String URL = "url";
    static final String PROPERTY_FILE = "config.properties";
    private String username, authkey;
    private RemoteWebDriver driver;
    private String applicationUrl;

    @Before
    public void setUp() throws Throwable {

        username = "mwalexander%40hotmail.com"; //replace with your username
        authkey = "u801581e29d7f096"; //replace with your authkey

        String browser = System.getProperty("browser");
        applicationUrl = System.getProperty("url");
        if (applicationUrl == null || applicationUrl == "")
            applicationUrl = "http://digital-away-day.scottishpower.co.uk/";

        DesiredCapabilities caps = new DesiredCapabilities();
        
        caps.setCapability("name", "tech demo");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("screenResolution", "1366x768");
        caps.setCapability("record_video", "true");
        caps.setCapability("record_network", "true");

        driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey +"@hub.crossbrowsertesting.com:80/wd/hub"), caps);
    }

    @Given("I go to my personalised greeting App")
    public void I_go_to_my_personalised_greeting_app() throws Throwable {
         System.out.println("applicationUrl : "+applicationUrl);
         driver.get(applicationUrl);
    }

    @When("I enter name (.*)")
    public void I_enter_name(String name) throws Throwable {
        driver.findElement(By.id("text-input__name")).sendKeys(name);
    }

    @Then("I click on greetings button")
    public void I_should_have_no_todos() throws Throwable {
        driver.findElement(By.id("button__get-greeting")).click();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
