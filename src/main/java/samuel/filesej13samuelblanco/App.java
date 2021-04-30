/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samuel.filesej13samuelblanco;


import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Samuel
 */
@XmlRootElement(name = "apli")
@XmlAccessorType(XmlAccessType.FIELD)

public class App {
    
 

    public static void crearDirectorios(String ruta) {
        
        
        String finalidad[] = ruta.split("/", 2);
        
        Path directory = Paths.get(finalidad[0]);
        try {
            Files.createDirectories(directory);
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + finalidad[0]);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + finalidad[0]);
            System.out.println("Seguramente la ruta está mal escrita o no existe");
        }

    }

    private int codigo;
    private String nombre;
    private String descripcion;
    private double tamanio;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate fechaCreacion;
    private static int cantidad = 0;
    private final static Random random = new Random();

    public App() {
    }

    public App(int codigo, String nombre, String descripcion, double tamanio, LocalDate fechaCreacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamanio = tamanio;
        this.fechaCreacion = fechaCreacion;
        cantidad++;
    }

    public static App crearApp() {

        App aplicacion = new App(getCantidad(), crearNombre(), generarDescripcion(), generarTamanio(), generarFecha());

        return aplicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return codigo + "\t" + nombre + "\t" + descripcion + "\t" + tamanio + "\t" + fechaCreacion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.codigo;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.descripcion);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.tamanio) ^ (Double.doubleToLongBits(this.tamanio) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.fechaCreacion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final App other = (App) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Double.doubleToLongBits(this.tamanio) != Double.doubleToLongBits(other.tamanio)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.fechaCreacion, other.fechaCreacion)) {
            return false;
        }
        return true;
    }

    private static char generarLetraAleatoria() {

        char letraMinus = (char) (random.nextInt(26) + 'a');

        return letraMinus;
    }

    private static String crearNombre() {

        return "app" + getCantidad() + generarLetraAleatoria();
    }

    private static String generarDescripcion() {

        ArrayList<String> listaDescripciones = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {

            listaDescripciones.add("Descripcion numero " + i);
        };
        int numeroaleatorio = random.nextInt(listaDescripciones.size() - 1) + 1;
        String descripcion = listaDescripciones.get(numeroaleatorio);

        return descripcion;
    }

    private static double generarTamanio() {

        return random.doubles(1, 100.0, 1024.0).sum();

    }

    private static LocalDate generarFecha() {

        int diaAleatorio = random.nextInt(31) + 1;

        int mesAleatorio = random.nextInt(12) + 1;
        if (mesAleatorio == 2) {
            diaAleatorio = random.nextInt(28) + 1;
        } else if (mesAleatorio == 4 || mesAleatorio == 6 || mesAleatorio == 9
                || mesAleatorio == 11) {
            diaAleatorio = random.nextInt(30) + 1;
        }
        int anio = random.nextInt(2021 - 1999 + 1) + 1999;
        return LocalDate.of(anio, mesAleatorio, diaAleatorio);
    }

}
