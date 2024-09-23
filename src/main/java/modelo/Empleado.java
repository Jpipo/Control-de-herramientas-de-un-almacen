
package modelo;


/**
 *
 * @author jhomc
 */
public class Empleado {
    private Integer id_empleado;
    private Integer c_identidad;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private Integer telefono;
    private String direccion;
    private String sexo;
    private String email;
    private String fecha_ingreso;
    private Integer f_cargo;
    private Cargo cargo;

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    


    public Integer getId_empleado() {
        return id_empleado;
    }

    public int getC_identidad() {
        return c_identidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEmail() {
        return email;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public int getF_cargo() {
        return f_cargo;
    }


    
    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }
    
    public void setC_identidad(int c_identidad) {
        this.c_identidad = c_identidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public void setF_cargo(int f_cargo) {
        this.f_cargo = f_cargo;
    }
}
