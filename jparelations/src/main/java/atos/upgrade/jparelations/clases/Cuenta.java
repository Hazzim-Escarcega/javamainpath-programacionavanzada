package atos.upgrade.jparelations.clases;

import javax.persistence.*;

@Entity(name = "cuentas")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cue_codigo")
    Integer codigo;

    @Column(name = "cue_descripcion")
    String descripcion;

    @Column(name = "cue_titular")
    String titular;

    @ManyToOne
    @JoinColumn(name = "cue_banco")
    Banco banco;

    @ManyToOne
    @JoinColumn(name = "cue_moneda")
    Moneda moneda;

    public Cuenta(){}
}
