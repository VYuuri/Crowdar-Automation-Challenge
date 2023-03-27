package tests;

import org.testng.annotations.Test;
import pageObjects.CarritoPage;
import pageObjects.LoginPage;
import pageObjects.TiendaPage;
import utilidad.Datos;

import java.io.IOException;

public class CPAB04AgregarItemAlCarrito extends TestBase{
    @Test
    public void CPAB04AgregarItemAlCarrito() throws IOException {
        Datos datos = new Datos("CPAB04");
        login = new LoginPage(driver);
        login.setearDatosLogeo(datos.getUser(),datos.getPass());
        login.loginClick();

        tienda = new TiendaPage(driver);
        tienda.agregarBackPackItemAlCarrito();
        tienda.irAlCarrito();

        carrito = new CarritoPage(driver);
        carrito.verificarBackPackEnCarrito();
        carrito.volverALaTienda();

        tienda.desloguear();


    }
}
