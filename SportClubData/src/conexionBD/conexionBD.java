package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
public class conexionBD {

    public Statement statement;
    String servidor = "";
    public String usuario;
    public String contrase�a;
    private static Connection conexion  = null;
 
    //CONSTRUCTOR
    //Recibe el nombre de la base de datos
    conexionBD (String usuario, String contrase�a){
    	
     	this.usuario=usuario;
    	this.contrase�a=contrase�a;
    	
        this.servidor="jdbc:mysql://localhost/sportclubdata";
        //Registrar el driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("DRIVER REGISTRADO");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR AL REGISTRAR EL DRIVER");
            System.exit(0); //parar la ejecuci�n
        }
 
        //Establecer la conexi�n con el servidor
        try {
            conexion = DriverManager.getConnection(this.servidor,
                        this.usuario, this.contrase�a);
            System.out.println("CONECTADO A LA BASE DE DATOS");
        } catch (SQLException e) {
            System.err.println("ERROR AL CONECTAR CON EL SERVIDOR");
            System.exit(0); //parar la ejecuci�n
        }
    }
 
    //Devuelve el objeto Connection que se usar� en la clase Controller
    public static Connection getConexion() {
        return conexion;
    }

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
 
}