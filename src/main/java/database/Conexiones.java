
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexiones {
    private final String URL = "C:\\Users\\elian\\Documents\\NetBeansProjects\\Agendador_Visitas-master\\db\\agendador.db";
        Connection connect;

    public Connection conectarse() {
        try {
            Class.forName("org.sqlite.JDBC");

            //Connection es un objeto de tipo java sql.
            connect = DriverManager.getConnection("jdbc:sqlite:" + URL);
            if (connect != null) {
                return connect;

            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexiones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //DESCONEXIÖN
    public void desconectarse(Connection dato) {
        if (dato != null) {
            try {
                dato.close();
            } catch (SQLException ex) {
                System.err.println("Conexion fallida por: " + ex);

            }
        }
    }
}
