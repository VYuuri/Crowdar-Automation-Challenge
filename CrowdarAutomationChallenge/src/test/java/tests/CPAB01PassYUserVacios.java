package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utilidad.Datos;

import java.io.IOException;

public class CPAB01PassYUserVacios extends TestBase{
    @Test
    public void CPAB01PassYUserVacios() throws IOException {
        Datos datos = new Datos("CPAB01");
        login = new LoginPage(driver);
        login.setearDatosLogeo(datos.getUser(),datos.getPass());
        login.loginClick();
        login.verificarMensajeError(datos.getMensajeErrorEsperado());
    }
}
