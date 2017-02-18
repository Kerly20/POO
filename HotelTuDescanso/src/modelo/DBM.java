/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*
    CHICOS CUANDO QUIERAN USAR SU BASE SOLO COMENTEN LAS PASSWORD QUE NON SON SUYAS
*/
public class DBM {
    Connection conection;
	
	//Parametros de conexion
	final String cadenaConexion="jdbc:mysql://localhost:3306/tudescanso";
	final String User="root";
        //Password Guillermo
	final String password="1234";
        
        //Password Kerly
	//final String password="";
        
        //Password José
	//final String password="";
        
        //Password Adrían
	//final String password="";

	//constructor para la clase
	public DBM(){
		this.conection=null;
	}
	//metodo para obtener la conexion
	public Connection getConection(){
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Class mysql no encontrada");
		}
		
		try {
			this.conection= DriverManager.getConnection(cadenaConexion,this.User,this.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error en la conexion");
		}
		
		return this.conection;
	}
    
}
