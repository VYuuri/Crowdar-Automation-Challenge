package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.TiendaPage;
import utilidad.Datos;

import java.io.IOException;

@Test
public class TestsLogIn extends TestBase {

    public void CPAB00Login(String user, String pass){
        login = new LoginPage(driver);
        login.setearUsuario(user);
        login.setearPassword(pass);
        login.loginClick();
    }

    public void CPAB01PassYUserVacios() throws IOException {
        Datos datos = new Datos("CPAB01");
        CPAB00Login(datos.getUser(), datos.getPass());
        login = new LoginPage(driver);
        login.verificarMensajeError(datos.getMensajeErrorEsperado());

    }
    public void CPAB02PassYUserCorrectos() throws IOException {
        Datos datos = new Datos("CPAB02");
        CPAB00Login(datos.getUser(), datos.getPass());
        tienda = new TiendaPage(driver);
        tienda.desloguear();

    }

    public void CPAB03UsuarioBloqueado() throws IOException {
        Datos datos = new Datos("CPAB03");
        CPAB00Login(datos.getUser(), datos.getPass());
        login = new LoginPage(driver);
        login.verificarMensajeError(datos.getMensajeErrorEsperado());
    }

    public void CPAB02PassYUserCorrectosFalloIntencional() throws IOException {
        Datos datos = new Datos("CPAB03");
        CPAB00Login(datos.getUser(), datos.getPass());
        tienda = new TiendaPage(driver);
        tienda.desloguear();
    }



}
