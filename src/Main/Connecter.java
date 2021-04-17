package Main;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author angel_p11
 */
public class Connecter {

    /**
     * Create a easy connection to mysql using an object of this class
     *
     * @author Angel
     */
    public static final String URL = "jdbc:mysql://192.168.64.2/test?useSSL=false";
    public static final String user = "Angel";
    public static final String password = "!T(R6u7d1M9xJEw!";
    public PreparedStatement ps;
    public ResultSet rs;
    public Connection conexion = null;

    /**
     * Use to get a connection
     *
     * @return Connection object to use
     */
    public Connection getConexion() {
        Connection conection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conection = (Connection) DriverManager.getConnection(URL, user, password);
        } catch (Exception ex) {
            System.err.println("An error was ocurred: " + ex);
        }
        return conection;
    }

}
