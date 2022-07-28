package atos.upgrade.jparelations.clases;

import javax.persistence.*;

@Entity(name = "bancos")
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ban_codigo")
    Integer codigo;

    @Column(name = "ban_nombre")
    String nombre;

    public Banco() {}

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
}
