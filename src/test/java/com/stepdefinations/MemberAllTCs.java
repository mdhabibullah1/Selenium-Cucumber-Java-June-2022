//package com.stepdefinations;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.cucumber.java.lu.a;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//public class MemberAllTCs extends World {
//
//    private World world;
//
//    public MemberAllTCs(World world) {
//        this.world = world;
//    }
//
//
//    @Given("I go to this url {string}")
//    public void i_go_to_this_url(String url) {
//        world.driver.get(url);
//    }
//
//    @When("I Login using user name {string} and password {string}")
//    public void i_login_using_user_name_and_password(String userName, String password) {
//        //world.driver.manage().window().maximize();
//        world.driverWait("//input[@placeholder=\"Enter Email\"]").sendKeys(userName);
//        world.driverWait("//input[@id='login-password']").sendKeys(password);
//        world.driverWait("//button[@id='btn-login']").click();
//
//    }
//
//    @Then("I Select class & section")
//    public void i_select_class_section() {
//        world.driverWait("//a[@onclick=\"router.navigate('classes', {trigger: true});\"]").click();
//        world.driverWait("(//button[contains(text(), 'Sign Up')])[1]").click();
//
//// To locate table
//        WebElement table = driver.findElement(By.xpath("//div[@id=\"section-table\"]/table/tbody[2]"));
//
//// To locate rows of table it will capture all the rows available in the table
//        WebElement[] rowsInTable = ((table.findElements(By.tagName("tr"))) a WebElement[]);
//
//// To calculate number of rows in the table
//        int rowsCount = rowsInTable.length;
//
//       // WebUI.comment("rowsCount=$rowsCount")
//
//// Iterate over all the rows of the table
//        for (int r = 0; r < rowsCount; r++) {
//            // To locate columns(cells) of that specific row
//            WebElement[] columnsInRow = (((rowsInTable[r]).findElements(By.tagName("label"))) as WebElement[]);
//
//            // To calculate number of columns in that specific row
//            int columnsCount = columnsInRow.length;
//            //WebUI.comment("Number of cells in row ${r} are ${columnsCount}")
//
//            String columnText = (columnsInRow[3]).getText()
//
//            if (columnText != "0") {
//                (columnsInRow[3]).click();
//                break;
//            }
//        }
//
//        world.driverWait("//button[@id='add-to-cart-btn']").click();
//
//        if (world.driverWait("//div[contains(text(),'Pay with card')]").isDisplayed()){
//            world.driverWait("").click();
//        }
//
//
//    }
//
//    @Then("I add to cart & proceed")
//    public void i_add_to_cart_proceed() {
//        world.driverWait("").click();
//    }
//
//
//
//
//}
