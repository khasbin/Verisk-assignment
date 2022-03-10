
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class seleniumClass {
    public static void main(String [] args){
        System.setProperty("webdriver.chrome.driver", "/home/asbinkhatiwada/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement user_name =  driver.findElement(By.name("user-name"));
        user_name.sendKeys("standard_user");

        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        driver.findElement(By.name("login-button")).click();
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();

        WebElement cart = driver.findElement(By.className("shopping_cart_link"));
        cart.click();

        WebElement quantity = driver.findElement(By.xpath("//span[@class = 'shopping_cart_badge']"));
        WebElement description = driver.findElement(By.xpath("//div[@class='inventory_item_desc']"));
        String desc = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

        Assert.assertEquals(description.getText(), desc);
        Assert.assertEquals(quantity.getText() , "1");


        driver.findElement(By.name("continue-shopping")).click();
        driver.findElement(By.name("remove-sauce-labs-backpack")).click();
        driver.findElement(By.name("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.name("checkout")).click();
        driver.findElement(By.name("continue")).click();
        String errormsg = "Error: First Name is required";
        String actualMsg =driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(errormsg, actualMsg);


        driver.findElement(By.name("firstName")).sendKeys("Ram");
        driver.findElement(By.name("lastName")).sendKeys("Sharma");
        driver.findElement(By.name("postalCode")).sendKeys("567543");
        driver.findElement(By.name("continue")).click();

        driver.findElement(By.name("finish")).click();
        driver.findElement(By.name("back-to-products")).click();

        WebElement menubar = driver.findElement(By.id("react-burger-menu-btn"));
        menubar.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(menubar));
        driver.findElement(By.id("logout_sidebar_link")).click();

    }
}
