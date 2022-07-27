package com.stepdefinations;


import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class POSAllTCs extends World{

    private World world;

    public POSAllTCs(World world) {
        this.world = world;
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

        JavascriptExecutor js = (JavascriptExecutor) world.driver;
        js.executeScript("window.scrollBy(0,0)");
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

}
