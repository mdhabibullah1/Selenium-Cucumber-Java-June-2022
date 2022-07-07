//package com.stepdefinations;
//
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class POSAllTCs extends World{
//
//    private World world;
//
//    public POSAllTCs(World world) {
//        this.world = world;
//    }
//
//    @Before
//    public void before_all() {
//        WebDriverManager.chromedriver().setup();
//        world.driver = new ChromeDriver();
//
//    }
//    @AfterStep
//    public void afterStep(){
//        new WebDriverWait(world.driver, Duration.ofSeconds(world.timeOut)).until(
//                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
//    }
//
//
//    @Given("I go to this url {string}")
//    public void i_go_to_this_url(String url) {
//        world.driver.get(url);
//    }
//    @When("I Login using user name {string} and password {string}")
//    public void i_login_using_user_name_and_password(String userName, String password) {
//        world.driver.manage().window().maximize();
//        world.driverWait("//input[@id='email']").sendKeys(userName);
//        world.driverWait("//input[@name='password']").sendKeys(password);
//        world.driverWait("//button[@class=\"btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn\"]").click();
//
//        world.driverWait("//button[contains(text(), 'Skip')]").click();
//
//        world.driverWait("(//span[@class=\"zmdi zmdi-menu\"])[1]").click();
//    }
//
//    @Then("I go to POS")
//    public void i_go_to_pos() {
//        world.driverWait("(//div[@data-v-step=\"3\"]//li)[1]").click();
//        world.driverWait("//button[contains(text(), 'Walk-in Client')]").click();
//    }
//    @Then("Select & Pay for class")
//    public void select_pay_for_class() {
//
//
//    }
//}
