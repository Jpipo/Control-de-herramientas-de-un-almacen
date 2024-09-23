
package modelo;

/**
 *
 * @author jhomc
 */
public class Cargo {
    private Integer cod_cargo;
    private String nombre_cargo;
    private Integer f_area;

    public void setCod_cargo(Integer cod_cargo) {
        this.cod_cargo = cod_cargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }

    public void setF_area(Integer f_area) {
        this.f_area = f_area;
    }

    public Integer getCod_cargo() {
        return cod_cargo;
    }

    public String getNombre_cargo() {
        return nombre_cargo;
    }

    public Integer getF_area() {
        return f_area;
    }

    
}
