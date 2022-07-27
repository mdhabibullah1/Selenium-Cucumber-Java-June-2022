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
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

//    @AfterStep
//    public void afterStep() {
//        new WebDriverWait(world.driver, Duration.ofSeconds(world.timeOut)).until(
//                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
//    }

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
        world.driver.manage().window().setPosition(new Point(-1900, 10));
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
        WebElement select = world.driverWait("//label[text()='Class Type']//parent::div//select");
        Select selectClassType = new Select(select);
        selectClassType.selectByIndex(1);

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
        world.driverWait("//td[contains(text(), 'CRUD')]//a[contains(text(), 'Remove')]").click();
        world.driverWait("//button[@class=\"btn btn-primary\"]").click();

        String CLASS_REMOVE = world.driverWait("//div[@class='toast-message']").getText();
        assert CLASS_REMOVE.contains("success");
    }

    @Then("I go to Health Insurance")
    public void i_go_to_health_insurance() {
        world.driverWait("//span[contains(text(),'CMS')]").click();
        world.driverWait("//a[contains(text(), 'Other Information')]").click();
    }
    @Then("I add Health Insurance")
    public void i_add_health_insurance() {
        world.driverWait("//button[contains(text(), ' Add Health Insurance ')]").click();
        world.driverWait("//input[@name='Insurance Name']").sendKeys("Automation CRUD");
        world.driverWait("//button[@class='btn btn-sm btn-primary mr-2']").click();

        JavascriptExecutor js = (JavascriptExecutor) world.driver;
        js.executeScript("window.scrollBy(0,0)");

        String HealthInsuranceAdded = world.driverWait("//div[@class='toast-message']").getText();
        assert HealthInsuranceAdded.contains("success");
    }
    @Then("I edit Health Insurance")
    public void i_edit_health_insurance() {

        world.driverWait("//span[contains(text(), 'CRUD')]//parent::td//following-sibling::td//a[contains(text(), 'Edit')]").click();
        world.driverWait("//input[@name=\"Insurance Name\"]").click();
        world.driverWait("//input[@name=\"Insurance Name\"]").clear();
        world.driverWait("//input[@name=\"Insurance Name\"]").sendKeys("Automation CRUD Edited");

        world.driverWait("//button[@class='btn btn-sm btn-primary mr-2']").click();

        JavascriptExecutor js = (JavascriptExecutor) world.driver;
        js.executeScript("window.scrollBy(0,0)");

        String HealthInsuranceUpdated = world.driverWait("//div[@class='toast-message']").getText();
        assert HealthInsuranceUpdated.contains("success");

    }
    @Then("I remove Health Insurance")
    public void i_remove_health_insurance() {

        world.driverWait("//span[contains(text(), 'CRUD')]//parent::td//following-sibling::td//a[contains(text(), 'Remove')]").click();
        world.driverWait("//button[@class='btn btn-primary']").click();

        String HealthInsuranceRemoved = world.driverWait("//div[@class='toast-message']").getText();
        assert HealthInsuranceRemoved.contains("success");
    }

    @Then("I go to Delivery Hospital")
    public void i_go_to_delivery_hospital() {
        world.driverWait("//span[contains(text(),'CMS')]").click();
        world.driverWait("//a[contains(text(), 'Other Information')]").click();
        world.driverWait("//span[@class='menu-title' and contains(text(), 'Delivery Hospital')]").click();
    }
    @Then("I add Delivery Hospital")
    public void i_add_delivery_hospital() {
        world.driverWait("//button[contains(text(), 'Add Hospital')]").click();
        world.driverWait("//input[@maxlength='500']").sendKeys("Automation CRUD");
        world.driverWait("//button[contains(text(), 'Save')]").click();

        JavascriptExecutor js = (JavascriptExecutor) world.driver;
        js.executeScript("window.scrollBy(0,0)");

        String DeliveryHospitalAdded = world.driverWait("//div[@class='toast-message']").getText();
        assert DeliveryHospitalAdded.contains("success");
    }
    @Then("I edit Delivery Hospital")
    public void i_edit_delivery_hospital() {

        world.driverWait("//span[contains(text(), 'CRUD')]//parent::td//following-sibling::td//a[contains(text(), 'Edit')]").click();
        world.driverWait("//input[@name=\"Hospital Name\"]").click();
        world.driverWait("//input[@name=\"Hospital Name\"]").clear();
        world.driverWait("//input[@name=\"Hospital Name\"]").sendKeys("Automation CRUD Edited");
        world.driverWait("//button[@class='btn btn-sm btn-primary mr-2']").click();

        JavascriptExecutor js = (JavascriptExecutor) world.driver;
        js.executeScript("window.scrollBy(0,0)");

        String DeliveryHospitalUpdated = world.driverWait("//div[@class='toast-message']").getText();
        assert DeliveryHospitalUpdated.contains("success");
        }
    @Then("I remove Delivery Hospital")
    public void i_remove_delivery_hospital() {

        world.driverWait("//span[contains(text(), 'CRUD')]//parent::td//following-sibling::td//a[contains(text(), 'Remove')]").click();
        world.driverWait("//button[@class='btn btn-primary']").click();

        String DeliveryHospitalRemoved = world.driverWait("//div[@class='toast-message']").getText();
        assert DeliveryHospitalRemoved.contains("success");
    }

    @Then("I go to Here About us")
    public void i_go_to_here_about_us() {
        world.driverWait("//span[contains(text(),'CMS')]").click();
        world.driverWait("//a[contains(text(), 'Other Information')]").click();
        world.driverWait("//span[contains(text(), 'How did you hear about us')]").click();
    }

    @Then("I add Here About us")
    public void i_add_here_about_us() {
        world.driverWait("//button[contains(text(), ' Add \"How did you hear about us?\" ')]").click();
        world.driverWait("//input[@maxlength='500']").sendKeys("Automation CRUD");
        world.driverWait("//button[contains(text(), 'Save')]").click();

        JavascriptExecutor js = (JavascriptExecutor) world.driver;
        js.executeScript("window.scrollBy(0,0)");

        String HereAboutusAdded = world.driverWait("//div[@class='toast-message']").getText();
        assert HereAboutusAdded.contains("success");
    }

    @Then("I edit Here About us")
    public void i_edit_here_about_us() {

        world.driverWait("//span[contains(text(), 'CRUD')]//parent::td//following-sibling::td//a[contains(text(), 'Edit')]").click();
        world.driverWait("//input[@maxlength='500']").click();
        world.driverWait("//input[@maxlength='500']").clear();
        world.driverWait("//input[@maxlength='500']").sendKeys("Automation CRUD Edited");
        world.driverWait("//button[@class='btn btn-sm btn-primary mr-2']").click();

        JavascriptExecutor js = (JavascriptExecutor) world.driver;
        js.executeScript("window.scrollBy(0,0)");

        String HereAboutusUpdated = world.driverWait("//div[@class='toast-message']").getText();
        assert HereAboutusUpdated.contains("success");
    }
    @Then("I remove Here About us")
    public void i_remove_here_about_us() {

        world.driverWait("//span[contains(text(), 'CRUD')]//parent::td//following-sibling::td//a[contains(text(), 'Remove')]").click();
        world.driverWait("//button[@class='btn btn-primary']").click();

        String HereAboutusRemoved = world.driverWait("//div[@class='toast-message']").getText();
        assert HereAboutusRemoved.contains("success");
    }
        //world.driverWait("").click();

}

