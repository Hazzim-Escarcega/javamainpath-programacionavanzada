package atos.upgrade.jparelations.clases;

import javax.persistence.*;
import java.util.List;

@Entity(name = "monedas")
public class Moneda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mon_codigo")
    Integer codigo;

    @Column(name = "mon_nombre")
    String nombre;

    @OneToMany(mappedBy = "moneda")
    List<Cuenta> cuentaList;

    public Moneda() {
    }

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
