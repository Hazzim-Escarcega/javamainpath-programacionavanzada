package atos.upgrade.jparelations.clases;

import javax.persistence.*;

@Entity(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_codigo")
    Integer codigo;

    @Column(name = "per_nombre")
    String nombre;
    @Column(name = "per_apellido_paterno")
    String apellidoPaterno;
    @Column(name = "per_apellido_materno")
    String apellidoMaterno;
    @Column(name = "per_correo")
    String correo;
    @Column(name = "per_telefono")
    String telefono;
    @OneToOne
    @JoinColumn(name = "cue_codigo")
    Cuenta cuenta;

    public Persona() {}

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
