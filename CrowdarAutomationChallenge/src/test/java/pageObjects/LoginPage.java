package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By inputUserName = By.cssSelector("#user-name");
    private By imputPassword = By.cssSelector("#password");
    private By btnLogin = By.cssSelector("#login-button");
    private By msgError = By.cssSelector("h3[data-test='error']");

    public void setearUsuario(String usuario){
        driver.findElement(inputUserName).clear();
        driver.findElement(inputUserName).sendKeys(usuario);
    }

    public void setearPassword(String pass){
        driver.findElement(imputPassword).clear();
        driver.findElement(imputPassword).sendKeys(pass);
    }

    public void setearDatosLogeo(String user, String pass){
        setearUsuario(user);
        setearPassword(pass);
    }
    public void loginClick() {
        driver.findElement(btnLogin).click();
    }

    public void verificarMensajeError(String errorEsperado){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(msgError)));
        Assert.assertEquals(driver.findElement(msgError).getText(),errorEsperado);
    }

}
