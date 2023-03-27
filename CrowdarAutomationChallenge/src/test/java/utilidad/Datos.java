package utilidad;

import java.io.IOException;

public class Datos {
    protected String user;
    protected String pass;
    protected String url;

    protected String mensajeErrorEsperado;
    public Datos(String cpab) throws IOException {
        DataDriven dataDriven = new DataDriven();
        this.user = dataDriven.getDato(cpab,"username");
        this.pass = dataDriven.getDato(cpab, "password");
        this.url = dataDriven.getDato(cpab,"url");
        this.mensajeErrorEsperado = dataDriven.getDato(cpab,"errorMsg");
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getUrl() {
        return url;
    }

    public String getMensajeErrorEsperado() {
        return mensajeErrorEsperado;
    }

    public static void main(String[] args) throws IOException {
        DataDriven dataDriven = new DataDriven();
        String dato = dataDriven.getDato("cpab02","Caso de Prueba");
        System.out.println(dato);
    }

}
