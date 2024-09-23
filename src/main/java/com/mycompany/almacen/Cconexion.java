
package com.mycompany.almacen;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jhomc
 */
public class Cconexion {
    
    private static final String BD = "almacenherramienta";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/" + BD;
    private static final String USUARIO = "jhon";
    private static final String CONTRASENA = "6361063";

    
    public static Connection Conectarbd() {
      Connection conexion = null;
            try {
                Class.forName(JDBC_DRIVER);
                conexion = DriverManager.getConnection(DB_URL, USUARIO, CONTRASENA);
                Logger.getLogger(Cconexion.class.getName()).log(Level.INFO, "Conexión establecida");
            } catch (ClassNotFoundException e) {
                Logger.getLogger(Cconexion.class.getName()).log(Level.SEVERE, "Error al cargar el driver", e);
            } catch (SQLException e) {
                Logger.getLogger(Cconexion.class.getName()).log(Level.SEVERE, "Error al conectar a la base de datos", e);
            }
      //  }
        return conexion;
    }

    public static void Cerrarbd(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                Logger.getLogger(Cconexion.class.getName()).log(Level.INFO, "Conexión cerrada");
            } catch (SQLException e) {
                Logger.getLogger(Cconexion.class.getName()).log(Level.SEVERE, "Error al cerrar la conexión", e);
            }
        }
    }
    
}
