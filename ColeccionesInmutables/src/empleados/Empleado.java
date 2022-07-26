package empleados;

public class Empleado {
    int id;
    String nombre;
    String apellido;
    String zonaVenta;
    int ventas;
    String pais;

    public Empleado(int id, String nombre, String apellido, String zonaVenta, int ventas, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.zonaVenta = zonaVenta;
        this.ventas = ventas;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getZonaVenta() {
        return zonaVenta;
    }

    public void setZonaVenta(String zonaVenta) {
        this.zonaVenta = zonaVenta;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}

