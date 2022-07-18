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
    public void afterStep() {
        new WebDriverWait(world.driver, Duration.ofSeconds(world.timeOut)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

//    @After
//    public void after() {
//        if (world.driver != null) {
//            world.driver.close();
//        }
//    }

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
//        world.driverWait("//input[@role=\"searchbox\"]").sendKeys("user23");
//        world.driverWait("//small[@class=\"main-title\"]").click();
    }

    @Then("I Select class")
    public void i_select_class() {

        WebElement dropdown = world.driverWait("//select[@class=\"form-control\"]");
        Select POSclass = new Select(dropdown);
        dropdown.click();
        System.out.println(POSclass);
        POSclass.selectByIndex(1);

        world.driverWait("(//td)[1]").click();
        world.driverWait("//button[contains(text(), ' Add to Cart ')]").click();

        String Added_to_Cart = world.driverWait("//div[@class='toast-message']").getText();
        assert Added_to_Cart.contains("success");
    }

    @Then("I make payment")
    public void i_make_payment() {

//        JavascriptExecutor js = (JavascriptExecutor) world.driver;
//        js.executeScript("window.scrollBy(0,-1900)");
        ((JavascriptExecutor) world.driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");

        world.driverWait("//button[contains(text(), 'Checkout')]").click();
        world.driverWait("//button[contains(text(), 'Provide Payment Info')]").click();
        world.driverWait("//button[contains(text(), ' Order Preview ')]").click();
        world.driverWait("//button[contains(text(), ' Make Payment ')]").click();


        if (world.driverWait("//div[contains(text(),'Pay with card')]").isDisplayed()) {
            world.driverWait("//input[@id=\"cardNumber\"]").sendKeys("4111111111111111");
            world.driverWait("//input[@id=\"cardExpiry\"]").sendKeys("09/30");
            world.driverWait("//input[@id=\"cardCvc\"]").sendKeys("123");
            world.driverWait("//input[@id=\"billingName\"]").sendKeys("Md Habibullah Mia");
            world.driverWait("//button[@type=\"submit\"]").click();

        } else if (world.driver.findElement(By.xpath("//h4[text()='Payment Details']")).isDisplayed()) {
            world.driverWait("//input[@name='credit card no']").sendKeys("4111111111111111");
            world.driverWait("//input[@name='expiration date']").sendKeys("09/30");
            world.driverWait("//input[@name='security code']").sendKeys("123");
            world.driverWait("//input[@name='first name']").sendKeys("Md Habibullah");
            world.driverWait("//input[@name='last name']").sendKeys("Mia");
            world.driverWait("//input[@name='address']").sendKeys("44/27");
            world.driverWait("//input[@name='city']").sendKeys("San Francisco");
            world.driverWait("//input[@name='state']").sendKeys("California");
            world.driverWait("//input[@name='zip']").sendKeys("94107");
            world.driverWait("//button[contains(text(), ' Pay Now ')]").click();
        }
        String ClassOrderPlaced = world.driverWait("//div[@class='toast-message']").getText();
        assert ClassOrderPlaced.contains("success");
    }
        @Then("I Select Product")
        public void i_select_product() {
            world.driverWait("//a[contains(text(), 'Packages')]//ancestor::ul//a[contains(text(), 'Product')]").click();
            world.driverWait("(//td)[1]").click();
            world.driverWait("//button[contains(text(), ' Add to Cart ')]").click();
        }
//        @Then("I pay for Product")
//        public void i_pay_for_product() {
//            ((JavascriptExecutor) world.driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
//
//            world.driverWait("//button[contains(text(), 'Checkout')]").click();
//            world.driverWait("//button[contains(text(), 'Provide Payment Info')]").click();
//            world.driverWait("//button[contains(text(), ' Order Preview ')]").click();
//            world.driverWait("//button[contains(text(), ' Make Payment ')]").click();
//
//
//            if (world.driverWait("//div[contains(text(),'Pay with card')]").isDisplayed()) {
//                world.driverWait("//input[@id=\"cardNumber\"]").sendKeys("4111111111111111");
//                world.driverWait("//input[@id=\"cardExpiry\"]").sendKeys("09/30");
//                world.driverWait("//input[@id=\"cardCvc\"]").sendKeys("123");
//                world.driverWait("//input[@id=\"billingName\"]").sendKeys("Md Habibullah Mia");
//                world.driverWait("//button[@type=\"submit\"]").click();
//
//            } else if (world.driver.findElement(By.xpath("//h4[text()='Payment Details']")).isDisplayed()) {
//                world.driverWait("//input[@name='credit card no']").sendKeys("4111111111111111");
//                world.driverWait("//input[@name='expiration date']").sendKeys("09/30");
//                world.driverWait("//input[@name='security code']").sendKeys("123");
//                world.driverWait("//input[@name='first name']").sendKeys("Md Habibullah");
//                world.driverWait("//input[@name='last name']").sendKeys("Mia");
//                world.driverWait("//input[@name='address']").sendKeys("44/27");
//                world.driverWait("//input[@name='city']").sendKeys("San Francisco");
//                world.driverWait("//input[@name='state']").sendKeys("California");
//                world.driverWait("//input[@name='zip']").sendKeys("94107");
//                world.driverWait("//button[contains(text(), ' Pay Now ')]").click();
//            }
//            String ProductOrderPlaced = world.driverWait("//div[@class='toast-message']").getText();
//            assert ProductOrderPlaced.contains("success");
//        }

    @Then("I Select Rental")
    public void i_select_rental() {
        world.driverWait("(//a[contains(text(), 'Rental')])[2]").click();
        WebElement select = world.driverWait("//select[@name='serial']");
        Select selectPump = new Select(select);
        selectPump.selectByIndex(1);

        WebElement selectRT = world.driverWait("//select[@name='term']");
        Select selectTerm = new Select(selectRT);
        selectRT.click();
        selectTerm.selectByIndex(1);
        //selectTerm.selectByVisibleText("1 days for $20.00");

        world.driverWait("//button[@type='submit']").click();
        world.driverWait("//button[contains(text(), ' Add to Cart ')]").click();
    }
//    @Then("I pay for Rental")
//    public void i_pay_for_rental() {
//        ((JavascriptExecutor) world.driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
//
//        world.driverWait("//button[contains(text(), 'Checkout')]").click();
//        world.driverWait("//button[contains(text(), 'Provide Payment Info')]").click();
//        world.driverWait("//button[contains(text(), ' Order Preview ')]").click();
//        world.driverWait("//button[contains(text(), ' Make Payment ')]").click();
//
//
//        if (world.driverWait("//div[contains(text(),'Pay with card')]").isDisplayed()) {
//            world.driverWait("//input[@id=\"cardNumber\"]").sendKeys("4111111111111111");
//            world.driverWait("//input[@id=\"cardExpiry\"]").sendKeys("09/30");
//            world.driverWait("//input[@id=\"cardCvc\"]").sendKeys("123");
//            world.driverWait("//input[@id=\"billingName\"]").sendKeys("Md Habibullah Mia");
//            world.driverWait("//button[@type=\"submit\"]").click();
//
//        } else if (world.driver.findElement(By.xpath("//h4[text()='Payment Details']")).isDisplayed()) {
//            world.driverWait("//input[@name='credit card no']").sendKeys("4111111111111111");
//            world.driverWait("//input[@name='expiration date']").sendKeys("09/30");
//            world.driverWait("//input[@name='security code']").sendKeys("123");
//            world.driverWait("//input[@name='first name']").sendKeys("Md Habibullah");
//            world.driverWait("//input[@name='last name']").sendKeys("Mia");
//            world.driverWait("//input[@name='address']").sendKeys("44/27");
//            world.driverWait("//input[@name='city']").sendKeys("San Francisco");
//            world.driverWait("//input[@name='state']").sendKeys("California");
//            world.driverWait("//input[@name='zip']").sendKeys("94107");
//            world.driverWait("//button[contains(text(), ' Pay Now ')]").click();
//        }
//        String ProductOrderPlaced = world.driverWait("//div[@class='toast-message']").getText();
//        assert ProductOrderPlaced.contains("success");
//    }


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

        String HealthInsuranceAdded = world.driverWait("//div[@class='toast-message']").getText();
        assert HealthInsuranceAdded.contains("success");

    }
    @Then("I edit Health Insurance")
    public void i_edit_health_insurance() {
//        JavascriptExecutor js = (JavascriptExecutor) world.driverWait("//button[contains(text(), ' Add Health Insurance ')]");
//        js.executeScript("window.scrollBy(0,-1900)");

        ((JavascriptExecutor) world.driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");

        world.driverWait("//span[contains(text(), 'CRUD')]//parent::td//following-sibling::td//a[contains(text(), 'Edit')]").sendKeys("Automation CRUD Edited");
        world.driverWait("//button[@class='btn btn-sm btn-primary mr-2']").click();

        String HealthInsuranceUpdated = world.driverWait("//div[@class='toast-message']").getText();
        assert HealthInsuranceUpdated.contains("success");

    }
    @Then("I remove Health Insurance")
    public void i_remove_health_insurance() {
//        JavascriptExecutor js = (JavascriptExecutor) world.driverWait("//button[contains(text(), ' Add Health Insurance ')]");
//        js.executeScript("window.scrollBy(0,-1900)");

        ((JavascriptExecutor) world.driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
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
    }
    @Then("I edit Delivery Hospital")
    public void i_edit_delivery_hospital() {
        //((JavascriptExecutor) world.driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");

        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        world.driverWait("//span[contains(text(), 'CRUD')]//parent::td//following-sibling::td//a[contains(text(), 'Edit')]").sendKeys("Automation CRUD Edited");
        world.driverWait("//button[@class='btn btn-sm btn-primary mr-2']").click();
    }
    @Then("I remove Delivery Hospital")
    public void i_remove_delivery_hospital() {
      //  ((JavascriptExecutor) world.driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");

        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        world.driverWait("//span[contains(text(), 'CRUD')]//parent::td//following-sibling::td//a[contains(text(), 'Remove')]").click();
        world.driverWait("//button[@class='btn btn-primary']").click();
    }
        //world.driverWait("").click();

}

