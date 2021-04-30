/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samuel.filesej13samuelblanco;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Samuel
 */
public class ServicioFicheroXML {

    
    //Genera un fichero XML con todas las Apps de un lista en una ruta dada
    public static void crearFicheroXML(ArrayList<App> lista, String ruta) throws JAXBException {

        App.crearDirectorios(ruta);

        App aplicacion = new App();
        GrupoAplicaciones aplicaciones = new GrupoAplicaciones();
        aplicaciones.setAplicaciones(lista);

        // Crea el contexto JAXB. Se encarga de definir los objetos 
        // que vamos a guardar. En nuestro caso sólo el tipo CatalogoMuebles
        JAXBContext contexto = JAXBContext.newInstance(GrupoAplicaciones.class);

        // El contexto JAXB permite crear un objeto Marshaller, que sirve para
        // generar la estructura del fichero XML 
        // El proceso de pasar objetos Java (CatalogoMuebles) a ficheros XML 
        // se conoce como "marshalling" o "serialización"
        Marshaller serializador = contexto.createMarshaller();

        // Especificamos que la propiedad del formato de salida
        // del serializador sea true, lo que implica que el formato se 
        // realiza con indentación y saltos de línea
        serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Llamando al método de serialización marshal (sobrecargado) se pueden
        // serializar objetos java en formato XML y volcarlos donde necesitemos:
        // consola, ficheros. El proceso consiste en que el contexto es el 
        // encargo de leer los objetos java, pasarlos al serializador y éste 
        // crear la salida de serialización
        // Serialización y salida por consola
        //  serializador.marshal(lista, System.out);
        // Volcado al fichero xml
        serializador.marshal(aplicaciones, System.out);
        serializador.marshal(aplicaciones, new File(ruta));

    }

    
    //Lee el fichero XML dado una ruta y lo muestra por pantalla
    public static void leerFicheroXML(String ruta) throws JAXBException {

        // Crea el contexto JAXB 
        JAXBContext contexto = JAXBContext.newInstance(GrupoAplicaciones.class);
        // Crea el objeto Unmarshaller
        Unmarshaller um = contexto.createUnmarshaller();

        // Llama al método de unmarshalling
        GrupoAplicaciones aplicaciones = (GrupoAplicaciones) um.unmarshal(new File(ruta));

        ArrayList<App> listaAplicaciones = aplicaciones.getAplicaciones();

        listaAplicaciones.forEach(System.out::println);
    }

}
