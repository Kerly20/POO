package Habitaciones;

/**
 *
 * @author Muriet
 */
public class Habitacion {
    int id; 
    String descripcion; 
    double precioBase; 
    int cantidadCamas;
    String tipo;
    boolean [] servicios;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean[] getServicios() {
        return servicios;
    }

    public void setServicios(boolean[] servicios) {
        this.servicios = servicios;
    }

    
    
}
