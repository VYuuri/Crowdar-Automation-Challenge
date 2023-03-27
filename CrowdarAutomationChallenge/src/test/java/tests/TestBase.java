package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.CarritoPage;
import pageObjects.LoginPage;
import pageObjects.TiendaPage;
import utilidad.Datos;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage login;
    protected TiendaPage tienda;
    protected CarritoPage carrito;
    protected String rutaProyecto;

    @BeforeSuite()
    public void iniciarSuite(){
        rutaProyecto = System.getProperty("user.dir");
        String rutaDriver = rutaProyecto+"\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",rutaDriver);

    }
    @BeforeClass
    public void iniciarDriver() {
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        String url = "https://www.saucedemo.com";
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void cerrarDriver(){driver.quit();

    }

    @AfterSuite
    public void cerrarSuite(){

    }
}
