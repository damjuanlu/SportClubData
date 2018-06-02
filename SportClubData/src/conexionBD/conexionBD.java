package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
public class conexionBD {

    private Statement statement;
    String servidor = "";
    private String usuario;
    private String contraseña;
    private static Connection conexion  = null;
 
    //CONSTRUCTOR
    //Recibe el nombre de la base de datos
    public conexionBD (String usuario, String contraseña) throws SQLException{
    	
     	this.usuario=usuario;
    	this.contraseña=contraseña;
    	
        this.servidor="jdbc:mysql://localhost/sportclubdata";
        //Registrar el driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DRIVER REGISTRADO");
            conexion = DriverManager.getConnection(this.servidor,
                    this.usuario, this.contraseña);
        System.out.println("CONECTADO A LA BASE DE DATOS");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR AL REGISTRAR EL DRIVER");
            System.exit(0); //parar la ejecución
        } catch (SQLException e) {
        	System.out.println(e);
            System.err.println("ERROR AL CONECTAR CON EL SERVIDOR");
            System.exit(0); //parar la ejecución
        }
    }
 
    //Devuelve el objeto Connection que se usará en la clase Controller
    public static Connection getConexion() {
        return conexion;
    }

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
 
}