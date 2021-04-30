/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samuel.filesej13samuelblanco;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;

/**
 *
 * @author Samuel
 */
public class ServicioFicheroTSV {
    

    public static void generarFicheroTSV(ArrayList<App> lista, String ruta) {

        // Estructura try-with-resources. Inicializa un objeto de tipo ObjectOutputStream
        // en función de un flujo FileOutputStream, identificado por "idFichero"
        
        App.crearDirectorios(ruta);
        
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))) {
            for (App aplicacion : lista) {

                flujo.write(aplicacion.toString());
                flujo.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
