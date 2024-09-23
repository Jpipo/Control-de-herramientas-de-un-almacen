
package modelo;

import java.util.List;

/**
 *
 * @author jhomc
 */
public interface DAOempleado {
    public void registrar (Empleado emplead) throws Exception;
    public void modificar (Empleado emplead) throws Exception;
    public void eliminar (int cIdentidad) throws Exception;
    public List<Empleado> listar (String nombre) throws Exception;
    public Empleado getEmpleado(int cIdent) throws Exception;
    
}
