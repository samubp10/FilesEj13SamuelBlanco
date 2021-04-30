/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samuel.filesej13samuelblanco;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Samuel
 */
public class ServicioFicheroJSON {

    public static void crearFicheroJSON(ArrayList<App> lista, String ruta) throws JAXBException, IOException {
        
        App.crearDirectorios(ruta);
        
        ObjectMapper mapeador = new ObjectMapper();

        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        mapeador.writeValue(new File(ruta), lista);

    }
}
