package tests;

import org.testng.annotations.Test;
import pageObjects.CarritoPage;
import pageObjects.LoginPage;
import pageObjects.TiendaPage;
import utilidad.Datos;

import java.io.IOException;

public class CPAB05SacarItemDelCarrito extends TestBase{
    @Test
    public void CPAB05SacarItemDelCarrito() throws IOException {
        Datos datos = new Datos("CPAB05");
        login = new LoginPage(driver);
        login.setearDatosLogeo(datos.getUser(),datos.getPass());
        login.loginClick();

        tienda = new TiendaPage(driver);
        tienda.agregarBackPackItemAlCarrito();
        tienda.irAlCarrito();

        carrito = new CarritoPage(driver);
        carrito.verificarBackPackEnCarrito();
        carrito.volverALaTienda();

        tienda.sacarBackPackDelCarrito();
        tienda.irAlCarrito();

        carrito.verificarCarritoSinBackPack();
        carrito.volverALaTienda();

        tienda.desloguear();
    }
}
