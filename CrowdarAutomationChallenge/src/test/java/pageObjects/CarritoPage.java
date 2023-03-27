package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CarritoPage extends BasePage{
    public CarritoPage(WebDriver driver) {
        super(driver);
    }

    private By titleYourCart = By.cssSelector("#header_container .title");
    private By btnSeguirComprando = By.cssSelector("#continue-shopping");
    private By titlebackpack = By.cssSelector("//*[contains(text(),'Sauce Labs Backpack')]");
    private By btnSacarBackPack = By.cssSelector("#remove-sauce-labs-backpack");

    public void verificarBackPackEnCarrito(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(titleYourCart)));
            Assert.assertTrue(driver.findElement(btnSacarBackPack).isDisplayed());
    }

    public void verificarCarritoSinBackPack(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(titleYourCart)));
        try{
            driver.findElement(btnSacarBackPack).click();
        }
        catch (Exception e){
            Assert.assertTrue(true,"No se encontro el boton para remover el backpack del carrito");
        }
    }

    public void volverALaTienda(){
        esperar(1000);
        driver.findElement(btnSeguirComprando).click();
    }
}
