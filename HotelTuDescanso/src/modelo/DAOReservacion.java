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
public class DAOReservacion {
    DBM dbm;
    Connection con;
    Statement sentencia;
    ResultSet resultset;
    
    public ArrayList<Reservacion> buscarHabitacion(){
        
        dbm=new DBM();
        con= dbm.getConection();
        //unir tabla
        String sql = "Select * from reservacion, cliente, habitacion where reserv_hab = hab_id and reserv_cli=cli_cedula";
        ArrayList<Reservacion> lista=null;
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
                        Reservacion reservacion = new Reservacion();
                        reservacion.setId(resultset.getInt("reserv_id"));
                        reservacion.setFechaEntrada(resultset.getDate("reserv_fechaentrada"));
                        reservacion.setFechaSalida(resultset.getDate("reserv_fechasalida"));
                        reservacion.setCosto(resultset.getDouble("reserv_costo"));
                        reservacion.setTipoTemporada(resultset.getString("reserv_tipotemp"));
                        reservacion.setConsumo(resultset.getString("reserv_consumo"));
                                
                        Cliente cliente = new Cliente();
                        cliente.setCedula(resultset.getString("cli_cedula"));
                        cliente.setNombres(resultset.getString("cli_nombres"));
                        cliente.setApellidos(resultset.getString("cli_apellidos"));
                        cliente.setTelefono(resultset.getString("cli_telefono"));
                        cliente.setEmail(resultset.getString("cli_email"));
                        cliente.setDireccion(resultset.getString("cli_direccion"));
                        reservacion.setCliente(cliente);
                        
                        Habitacion habitacion = new Habitacion();
                        habitacion.setId(resultset.getInt("hab_id"));
                        habitacion.setDescripcion(resultset.getString("hab_descripcion"));
                        habitacion.setPrecioBase(resultset.getDouble("hab_preciobase"));
                        Array a =resultset.getArray("hab_servicios");
                        boolean[] servicios= (boolean[])a.getArray(0, 3);
                        habitacion.setServicios(servicios);
                        reservacion.setHabitacion(habitacion);
                        
                        lista.add(reservacion);
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
