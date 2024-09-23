
package com.mycompany.almacen;

/**
 *
 * @author jhomc
 */
import java.sql.*;
import javax.swing.JComboBox;

public class comboBox {

    public void llenarComboBox(JComboBox comboBox) {
        try {
            String url = "jdbc:mysql://localhost:3306/almacen";
            String user = "root";
            String password = "";

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "SELECT nombre_cargo FROM cargo";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString("nombre_cargo");
                comboBox.addItem(nombre);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
          
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
