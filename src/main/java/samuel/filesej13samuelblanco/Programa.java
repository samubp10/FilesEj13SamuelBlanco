/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samuel.filesej13samuelblanco;

import java.io.IOException;

import java.util.ArrayList;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Samuel
 */
public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JAXBException, IOException {

        ArrayList<App> aplicaciones = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            aplicaciones.add(App.crearApp());

        }
        ServicioFicheroJSON.crearFicheroJSON(aplicaciones, "appsjson/ficheros.json");
        ServicioFicheroTSV.generarFicheroTSV(aplicaciones, "appstsv/ficheros.tsv");
        ServicioFicheroXML.crearFicheroXML(aplicaciones, "appsxml/fichero.xml");

        for (App aplicacion : aplicaciones) {

            System.out.println(aplicacion);

        }
    }

}
