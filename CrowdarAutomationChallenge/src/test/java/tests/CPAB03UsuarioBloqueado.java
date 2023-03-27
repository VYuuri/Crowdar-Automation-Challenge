package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utilidad.Datos;

import java.io.IOException;

public class CPAB03UsuarioBloqueado extends TestBase{
    @Test
    public void CPAB03UsuarioBloqueado() throws IOException {
        Datos datos = new Datos("CPAB03");
        login = new LoginPage(driver);
        login.setearDatosLogeo(datos.getUser(),datos.getPass());
        login.loginClick();
        login.verificarMensajeError(datos.getMensajeErrorEsperado());


    }
}
