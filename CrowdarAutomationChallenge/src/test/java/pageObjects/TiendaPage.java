package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TiendaPage extends BasePage{
    public TiendaPage(WebDriver driver) {
        super(driver);
    }

    private By carrito = By.cssSelector("h3[data-test='error']");
    private By btnMenu = By.cssSelector("#react-burger-menu-btn");
    private By btnLogout = By.cssSelector("#logout_sidebar_link");
    private By btnAddBackpackAlCarrito = By.cssSelector("#add-to-cart-sauce-labs-backpack");
    private By btnRemoveBackpackDelCarrito = By.cssSelector("#remove-sauce-labs-backpack");
    private By btnResetPage = By.cssSelector("#reset_sidebar_link");
    private By btnIrAlCarrito = By.cssSelector(".shopping_cart_link");


    public void agregarBackPackItemAlCarrito(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnMenu)));
        driver.findElement(btnAddBackpackAlCarrito).click();
    }

    public void sacarBackPackDelCarrito(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnRemoveBackpackDelCarrito))).click();
    }

    public void irAlCarrito(){
        driver.findElement(btnIrAlCarrito).click();
    }
    public void desloguear(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnMenu))).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(btnResetPage))).click();
        driver.findElement(btnLogout).click();
    }

    public void VerificarLogeo() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnMenu)));
        Assert.assertTrue(driver.findElement(btnMenu).isDisplayed());
    }
}
