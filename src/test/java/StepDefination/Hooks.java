package StepDefination;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks extends World {
    private World world;
    Hooks(World world){
        this.world = world;
    }

    @Before
    public void before_all(){
        WebDriverManager.chromedriver().setup();
        world.driver = new ChromeDriver();

    }

}
