package com.stepdefinations;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class firstClass extends World {

    private World world;

    public firstClass(World world) {
        this.world = world;
    }

    @Before
    public void before_all() {
        WebDriverManager.chromedriver().setup();
        world.driver = new ChromeDriver();

    }
    @AfterStep
    public void afterStep(){
        new WebDriverWait(world.driver, Duration.ofSeconds(world.timeOut)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    @After
    public void after() {
        if (world.driver != null) {
            world.driver.close();
        }
    }

    @Given("I go to this url {string}")
    public void i_go_to_this_url(String url) {
        world.driver.get(url);
    }
    @When("I Login using user name {string} and password {string}")
    public void i_login_using_user_name_and_password(String userName, String password) {
        world.driver.manage().window().maximize();
        world.driverWait("//input[@id='email']").sendKeys(userName);
        world.driverWait("//input[@name='password']").sendKeys(password);
        world.driverWait("//button[@class=\"btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn\"]").click();

        world.driverWait("//button[contains(text(), 'Skip')]").click();

        world.driverWait("(//span[@class=\"zmdi zmdi-menu\"])[1]").click();
    }

    @Then("I go to class type")
    public void i_go_to_class_type() {
        world.driverWait("//span[contains(text(),\"Shopping Services\")]").click();
        world.driverWait("//a[contains(text(), 'Class')]").click();
        world.driverWait("//a[@id='navbarDropdown']").click();
        world.driverWait("//div[@class=\"submenu\"]//descendant::a[contains(text(), 'Manage Class Type')]").click();

    }
    @Then("I add class type")
    public void i_add_class_type() {
        world.driverWait("//input[@name='type name']").sendKeys(new CharSequence[]{"Automation Test CRUD"});
        world.driverWait("//button[contains(text(), 'Save')]").click();

        String classType_ADD = world.driverWait("//div[@class='toast-message']").getText();
        assert classType_ADD.contains("success");

    }
    @Then("I edit class type")
    public void i_edit_class_type() {
        world.driverWait("//td[contains(text(), 'CRUD')]//following-sibling::td//a[contains(text(), 'Edit')]").click();
        world.driverWait("//input[@name='type name']").click();
        world.driverWait("//input[@name='type name']").clear();
        world.driverWait("//input[@name='type name']").sendKeys(new CharSequence[]{"Automation Test Edited CRUD"});
        world.driverWait("//button[contains(text(), 'Save')]").click();

        String classType_EDIT = world.driverWait("//div[@class='toast-message']").getText();
        assert classType_EDIT.contains("success");

    }
    @Then("I remove class type")
    public void i_remove_class_type() {
        world.driverWait("//td[contains(text(), 'CRUD')]//following-sibling::td//a[contains(text(), 'Remove')]").click();
        world.driverWait("//button[@class=\"btn btn-primary\"]").click();

        String classType_REMOVE = world.driverWait("//div[@class='toast-message']").getText();
        assert classType_REMOVE.contains("success");

    }
    @Then("I go to class")
    public void i_go_to_class() {
        world.driverWait("//span[contains(text(),\"Shopping Services\")]").click();
        world.driverWait("//a[contains(text(), 'Class')]").click();
        world.driverWait("//a[@id='navbarDropdown']").click();
        world.driverWait("(//div[@class=\"submenu\"]//descendant::a[contains(text(), 'Add Class')])[1]").click();

    }
    @Then("I add class")
    public void i_add_class() {
        world.driverWait("//input[@name='title']").sendKeys("Automation Test CRUD");
        WebElement dropdown = world.driverWait("//label[text()='Class Type']//parent::div//select");
        Select classType = new Select(dropdown);
        System.out.println(classType);
        classType.selectByIndex(1);

        world.driverWait("//input[@name='year']").sendKeys("2022");
        world.driverWait("//input[@name='fee']").sendKeys("200");
        world.driverWait("//textarea").sendKeys("Lorem ipsum is simply dummy text");
        world.driverWait("//input[@type='checkbox']").click();
        world.driverWait("//button[contains(text(), 'Save')]").click();

        String CLASS_ADD = world.driverWait("//div[@class='toast-message']").getText();
        assert CLASS_ADD.contains("success");
    }
    @Then("I edit class")
    public void i_edit_class() {
//        world.driverWait("//input[@placeholder=\"Search Classes\"]").sendKeys("CRUD");
//        world.driverWait("//button[contains(text(), 'Search')]").click();

//        //to perform Scroll on application using Selenium
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,-1900)", "");

        world.driverWait("//td[contains(text(), 'CRUD')]//a[contains(text(), 'Edit')]").click();
        world.driverWait("//input[@name='title']").click();
        world.driverWait("//input[@name='title']").clear();
        world.driverWait("//input[@name='title']").sendKeys("Automation Test Edited CRUD");
        world.driverWait("//button[contains(text(), 'Save')]").click();

        String CLASS_EDIT = world.driverWait("//div[@class='toast-message']").getText();
        assert CLASS_EDIT.contains("success");
    }
    @Then("I remove class")
    public void i_remove_class() {
//        world.driverWait("//input[@placeholder=\"Search Classes\"]").sendKeys("CRUD");
//        world.driverWait("//button[contains(text(), 'Search')]").click();

//        //to perform Scroll on application using Selenium
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,-1900)", "");

        world.driverWait("//td[contains(text(), 'CRUD')]//a[contains(text(), 'Remove')]").click();
        world.driverWait("//button[@class=\"btn btn-primary\"]").click();

        String CLASS_REMOVE = world.driverWait("//div[@class='toast-message']").getText();
        assert CLASS_REMOVE.contains("success");
    }


    @Then("I go to POS")
    public void i_go_to_pos() {
        world.driverWait("(//div[@data-v-step=\"3\"]//li)[1]").click();
        world.driverWait("//button[contains(text(), 'Walk-in Client')]").click();
        //world.driverWait("//input[@placeholder=\"Search User\"]").sendKeys("user");

    }
    @Then("Select & Pay for class")
    public void select_pay_for_class() {

        WebElement dropdown = world.driverWait("//select[@class=\"form-control\"]");
        Select POSclass = new Select(dropdown);
        dropdown.click();
        System.out.println(POSclass);
        POSclass.selectByIndex(1);

        world.driverWait("(//td)[1]").click();
        world.driverWait("//button[contains(text(), ' Add to Cart ')]").click();

        String Added_to_Cart = world.driverWait("//div[@class='toast-message']").getText();
        assert Added_to_Cart.contains("success");


//        JavascriptExecutor js = (JavascriptExecutor) world.driver;
//        js.executeScript("window.scrollBy(0,-1900)");
        ((JavascriptExecutor) world.driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");

        world.driverWait("//button[contains(text(), 'Checkout')]").click();
        world.driverWait("//button[contains(text(), 'Provide Payment Info')]").click();
        world.driverWait("//button[contains(text(), ' Order Preview ')]").click();
        world.driverWait("//button[contains(text(), ' Make Payment ')]").click();
        world.driverWait("//input[@id=\"cardNumber\"]").sendKeys("4111111111111111");
        world.driverWait("//input[@id=\"cardExpiry\"]").sendKeys("09/30");
        world.driverWait("//input[@id=\"cardCvc\"]").sendKeys("123");
        world.driverWait("//input[@id=\"billingName\"]").sendKeys("Md Habibullah Mia");
        world.driverWait("//button[@type=\"submit\"]").click();

//        String POS_Class = world.driverWait("//div[@class='toast-message']").getText();
//        assert POS_Class.contains("success");


        //world.driverWait("").click();
    }
}
