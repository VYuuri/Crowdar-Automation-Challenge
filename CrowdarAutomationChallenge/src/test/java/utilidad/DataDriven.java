package utilidad;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class DataDriven {
    public String getDato(String CPAB, String dato) throws IOException {
        String datoPedido = "no se encontro dato";
        String rutaProyecto = System.getProperty("user.dir");
        String rutaDatos = rutaProyecto+"\\src\\test\\resources\\datos\\DatosChallenge.xlsx";

        FileInputStream file = new FileInputStream(rutaDatos);
        XSSFWorkbook excel = new XSSFWorkbook(file);

        int cantidadHojasExcel = excel.getNumberOfSheets();
        System.out.println(cantidadHojasExcel);

        XSSFSheet hojaExcel = excel.getSheetAt(0);
        Iterator<Row> filas =hojaExcel.iterator();
        Row fila1 = filas.next();
        Iterator<Cell> celda = fila1.cellIterator();
        int k = 0;
        int columna = 0;
        while(celda.hasNext()){
            Cell celdaSeleccionada = celda.next();
            if(celdaSeleccionada.getStringCellValue().equalsIgnoreCase(dato)){
                columna = k;
                break;
            }
            k++;
        }
        while(filas.hasNext()){
            Row r = filas.next();
            if(r.getCell(0).getStringCellValue().equalsIgnoreCase(CPAB)){
                datoPedido = String.valueOf(r.getCell(columna));
                break;
            }
        }
        return datoPedido;
    }
}
