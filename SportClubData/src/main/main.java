package main;

import java.sql.SQLException;

import conexionBD.*;
import view.*;

public class main {
	
	static conexionBD conexion;
	static VistaLogin miVistaLogin;

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//Invocar al constructor de la clase Bd
        conexion = new conexionBD("presidente","presidente");
        //Crear un objeto de la clase View
        miVistaLogin = new VistaLogin();
        miVistaLogin.setVisible(true);
        //Crear un objeto de la clase Controller
 
    }

}
