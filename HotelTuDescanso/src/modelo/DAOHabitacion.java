package modelo;

import Habitaciones.Habitacion;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Muriet
 */
public class DAOHabitacion {
    DBM dbm;
    Connection con;
    Statement sentencia;
    ResultSet resultset;
    
    public ArrayList<Habitacion> buscarHabitacion(){
        
        dbm=new DBM();
        con= dbm.getConection();
        //unir tabla
        String sql = "Select * from habitacion" ;
        ArrayList<Habitacion> lista=null;
        try {
            sentencia = con.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            resultset = sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        if(resultset != null){
        lista= new ArrayList();
            try {
                //mapear
                while(resultset.next()){
                    try {
                        Habitacion habitacion = new Habitacion();
                        habitacion.setId(resultset.getInt("hab_id"));
                        habitacion.setDescripcion(resultset.getString("hab_descripcion"));
                        habitacion.setPrecioBase(resultset.getDouble("hab_preciobase"));
                        Array a =resultset.getArray("hab_servicios");
                        boolean[] servicios= (boolean[])a.getArray(0, 3);
                        habitacion.setServicios(servicios);
 
                        lista.add(habitacion);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }   } catch (SQLException ex) {
                        ex.printStackTrace();
            }
        }
        
        return lista;
        
        
    }
}
