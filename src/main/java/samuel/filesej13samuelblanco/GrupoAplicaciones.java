/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samuel.filesej13samuelblanco;


import java.util.ArrayList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author samuel
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GrupoAplicaciones {
    
        // XmLElementWrapper define un contenedor para la lista 
    // de muebles
    @XmlElementWrapper(name = "aplicacion")

    // XmlElement establece el nombre de los elementos
    // Cada elemento de la lista llevará esta etiqueta en el fichero xml
    @XmlElement(name = "caracteristicas")
   private ArrayList<App> aplicaciones;
   
   

    public GrupoAplicaciones() {
        this.aplicaciones = new ArrayList<App>();
    }
   
   

    public ArrayList<App> getAplicaciones() {
        return aplicaciones;
    }

    public void setAplicaciones(ArrayList<App> aplicaciones) {
        this.aplicaciones = aplicaciones;
    }

    @Override
    public String toString() {
        return "GrupoAplicaciones{" + "aplicaciones=" + aplicaciones + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.aplicaciones);
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
        final GrupoAplicaciones other = (GrupoAplicaciones) obj;
        if (!Objects.equals(this.aplicaciones, other.aplicaciones)) {
            return false;
        }
        return true;
    }
   
   
    
    
    
}
