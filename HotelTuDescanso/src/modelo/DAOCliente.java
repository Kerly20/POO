package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Muriet
 */
public class DAOCliente {
    DBM dbm;
    Connection con;
    Statement sentencia;
    ResultSet resultset;
    
    public ArrayList<Cliente> buscarEmpleado(){
        
        dbm=new DBM();
        con= dbm.getConection();
        //unir tabla
        String sql = "Select * from cliente" ;
        ArrayList<Cliente> lista=null;
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
                        Cliente cliente = new Cliente();
                        cliente.setCedula(resultset.getString("cli_cedula"));
                        cliente.setNombres(resultset.getString("cli_nombres"));
                        cliente.setApellidos(resultset.getString("cli_apellidos"));
                        cliente.setTelefono(resultset.getString("cli_telefono"));
                        cliente.setEmail(resultset.getString("cli_email"));
                        cliente.setDireccion(resultset.getString("cli_direccion"));

                        lista.add(cliente);
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
