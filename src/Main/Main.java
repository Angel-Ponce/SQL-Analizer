package Main;

/**
 *
 * @author angel_p11
 */
public class Main {
    public static void main(String[] args) {
        Connecter c = new Connecter();
        c.conexion = c.getConexion();
        if(c.conexion != null){
            System.out.println("Conexion exitosa");
        }else{
            System.err.println("Conexion fallida");
        }
    }
}
