package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.TiendaPage;
import utilidad.Datos;

import java.io.IOException;

public class CPAB02PassYUserCorrectos extends TestBase{

    @Test
    public void CPAB02PassYUserCorrectos() throws IOException {
        Datos datos = new Datos("CPAB02");
        login = new LoginPage(driver);
        login.setearDatosLogeo(datos.getUser(),datos.getPass());
        login.loginClick();

        tienda = new TiendaPage(driver);
        tienda.VerificarLogeo();
        tienda.desloguear();
    }
}
