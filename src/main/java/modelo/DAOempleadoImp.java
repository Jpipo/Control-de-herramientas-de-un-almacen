
package modelo;

import com.mycompany.almacen.Cconexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhomc
 */
public class DAOempleadoImp extends Cconexion implements DAOempleado {

    @Override
        public void registrar(Empleado emplead) throws Exception {
        String sql = "INSERT INTO empleado (c_identidad, nombre, ap_paterno, ap_materno, telefono, direccion, sexo, email, fecha_ingreso, f_cargo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Cconexion.Conectarbd();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, emplead.getC_identidad());
            st.setString(2, emplead.getNombre());
            st.setString(3, emplead.getAp_paterno());
            st.setString(4, emplead.getAp_materno());
            st.setInt(5, emplead.getTelefono());
            st.setString(6, emplead.getDireccion());
            st.setString(7, emplead.getSexo());
            st.setString(8, emplead.getEmail());
            st.setString(9, emplead.getFecha_ingreso());
            st.setInt(10, emplead.getF_cargo());           
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al registrar el empleado(Impl): " + e.getMessage());
        } finally {
    System.out.println("Conexión cerrada.");
}
    }    
        
    @Override
    public void modificar(Empleado emplead) throws Exception {
        String sql = "UPDATE empleado SET c_identidad = ?, nombre = ?, ap_paterno = ?, ap_materno = ?, telefono = ?, direccion = ?, sexo = ?, email = ?, fecha_ingreso = ?, f_cargo = ? WHERE id_empleado = ?";
        
        try (Connection conn = Cconexion.Conectarbd();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, emplead.getC_identidad());
            st.setString(2, emplead.getNombre());
            st.setString(3, emplead.getAp_paterno());
            st.setString(4, emplead.getAp_materno());
            st.setInt(5, emplead.getTelefono());
            st.setString(6, emplead.getDireccion());
            st.setString(7, emplead.getSexo());
            st.setString(8, emplead.getEmail());
            st.setString(9, emplead.getFecha_ingreso());
            st.setInt(10, emplead.getF_cargo());
            st.setInt(11, emplead.getId_empleado());           
            st.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al registrar el empleado(Impl): " + e.getMessage());
        } finally {
    System.out.println("Conexión cerrada.");
}
    }

    @Override
    public void eliminar(int cIdentidad) throws Exception {
            Connection conn = null;
            try {
                conn = Cconexion.Conectarbd();
                PreparedStatement st = conn.prepareStatement("DELETE FROM empleado WHERE c_identidad = ?;");
                st.setInt(1, cIdentidad);
                st.executeUpdate();
                st.close();
            } catch(Exception e) {
                throw e;
            } finally {
                Cconexion.Cerrarbd(conn);
            }
    }

    @Override
    public List<Empleado> listar(String nombre) throws Exception {
      List<Empleado> lista = new ArrayList<>();
        Cconexion cconexion = new Cconexion();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = cconexion.Conectarbd();
            

            String sql = nombre.isEmpty() ? "select * from empleado e join cargo c on f_cargo = c.cod_cargo;" : "SELECT * FROM empleado e JOIN cargo c ON e.f_cargo = c.cod_cargo WHERE e.nombre LIKE ?;";
            st = conn.prepareStatement(sql);
                    if (!nombre.isEmpty()) {
                    st.setString(1, "%" + nombre + "%");
                }
            rs = st.executeQuery();

            while (rs.next()) {
                Empleado emplead = new Empleado();               
                Cargo cargo = new Cargo();               
                emplead.setC_identidad(rs.getInt("c_identidad"));
                emplead.setNombre(rs.getString("nombre"));
                emplead.setAp_paterno(rs.getString("ap_paterno"));
                emplead.setAp_materno(rs.getString("ap_materno"));
                emplead.setTelefono(rs.getInt("telefono"));
                emplead.setFecha_ingreso(rs.getString("fecha_ingreso"));
                cargo.setNombre_cargo(rs.getString("nombre_cargo"));
                emplead.setCargo(cargo);
                lista.add(emplead);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (conn != null) cconexion.Cerrarbd(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    @Override
    public Empleado getEmpleado(int cIdent) throws Exception {
        Empleado emplead = null;
        Cconexion cconexion = new Cconexion();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = cconexion.Conectarbd();           
            String sql = "SELECT * FROM empleado WHERE c_identidad = ? limit 1;";
            st = conn.prepareStatement(sql);
            st.setInt(1, cIdent);
            rs = st.executeQuery();
            

            if (rs.next()) {
                emplead = new Empleado();
                emplead.setId_empleado(rs.getInt("id_empleado"));
                emplead.setC_identidad(rs.getInt("c_identidad"));
                emplead.setNombre(rs.getString("nombre"));
                emplead.setAp_paterno(rs.getString("ap_paterno"));
                emplead.setAp_materno(rs.getString("ap_materno"));
                emplead.setTelefono(rs.getInt("telefono"));
                emplead.setDireccion(rs.getString("direccion"));
                emplead.setSexo(rs.getString("sexo"));
                emplead.setEmail(rs.getString("email"));
                emplead.setFecha_ingreso(rs.getString("fecha_ingreso"));
                emplead.setF_cargo(rs.getInt("f_cargo"));
               
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (conn != null) cconexion.Cerrarbd(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return emplead;
    }
    
}
