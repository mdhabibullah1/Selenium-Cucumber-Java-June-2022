package StepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class firstClass extends World {

    private World world;

    public firstClass(World world){
        this.world = world;
    }

    @Before
    public void before_all(){
        WebDriverManager.chromedriver().setup();
        world.driver = new ChromeDriver();

    }
//    @After
//    public void after(){
//        if(world.driver != null){
//            world.driver.close();
//        }
//    }



    @Given("today is Sunday")
    public void today_is_sunday() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Hello Cucumber");

        world.Habibullah = "1234";
    }
    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_friday_yet() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println( world.Habibullah);

    }
    @Then("I should be told {string}")
    public void i_should_be_told(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Hello Cucumber");
    }

    @Given("I go to this url {string}")
    public void i_go_to_this_url(String url) {
        world.driver.get(url);
    }
    @When("I Login using user name {string} and password {string}")
    public void i_login_using_user_name_and_password(String userName, String password) throws InterruptedException {
        world.driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userName);
        world.driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        world.driver.findElement(By.xpath("//button[@class=\"btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn\"]")).click();

        Thread.sleep(5000L);
        By toolTip = By.xpath("//h4[@class=\"modal-title text-info\"]");
        if (world.driver.findElement(toolTip).getText().contains("Welcome")){
            world.driver.findElement(By.xpath("//button[contains(text(), 'Skip')]")).click();
        }

        world.driver.findElement(By.xpath("(//span[@class=\"zmdi zmdi-menu\"])[1]")).click();
        //world.driver.findElement(By.xpath("")).click();

    }


    @Given("I go to class type")
    public void i_go_to_class_type() throws InterruptedException {
        world.driver.findElement(By.xpath("(//span[@class=\"zmdi zmdi-menu\"])[1]")).click();
        world.driver.findElement(By.xpath("//span[contains(text(),\"Shopping Services\")]")).click();
        world.driver.findElement(By.xpath("//a[contains(text(), 'Class')]")).click();
        Thread.sleep(5000L);
        world.driver.findElement(By.xpath("//a[@id='navbarDropdown']")).click();
        world.driver.findElement(By.xpath("//div[@class=\"submenu\"]//descendant::a[contains(text(), 'Manage Class Type')]")).click();
        Thread.sleep(5000L);
    }
    @When("I add class type")
    public void i_add_class_type() throws InterruptedException {
        world.driver.findElement(By.xpath("//input[@name='type name']")).sendKeys(new CharSequence[]{"Automation Test CRUD"});
        world.driver.findElement(By.xpath("//button[contains(text(), 'Save')]")).click();
        String TM_ADD = world.driver.findElement(By.xpath("//div[@class='toast-message']")).getText();

        assert TM_ADD == "success";

        System.out.println(TM_ADD);
        Thread.sleep(3000L);
    }

    @Then("I edit class type")
    public void i_edit_class_type() throws InterruptedException {
        world.driver.findElement(By.xpath("//td[contains(text(), 'CRUD')]//following-sibling::td//a[contains(text(), 'Edit')]")).click();
        Thread.sleep(2000L);
        world.driver.findElement(By.xpath("//input[@name='type name']")).clear();
        world.driver.findElement(By.xpath("//input[@name='type name']")).sendKeys(new CharSequence[]{"Automation Test Edited CRUD"});
        world.driver.findElement(By.xpath("//button[contains(text(), 'Save')]")).click();
        String TM_EDIT = world.driver.findElement(By.xpath("//div[@class='toast-message']")).getText();

        assert TM_EDIT == "success";

        System.out.println(TM_EDIT);
        Thread.sleep(2000L);
    }

    @Then("I remove class type")
    public void i_remove_class_type() throws InterruptedException {
        world.driver.findElement(By.xpath("//td[contains(text(), 'CRUD')]//following-sibling::td//a[contains(text(), 'Remove')]")).click();
        world.driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
        String TM_REMOVE = world.driver.findElement(By.xpath("//div[@class='toast-message']")).getText();

        assert TM_REMOVE == "success";

        System.out.println(TM_REMOVE);

    }

}
