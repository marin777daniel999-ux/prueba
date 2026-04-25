package BANCO3315298.Logica;

import java.time.LocalDate;

public class Titular { 

    private String documento;
    private String nombres;
    private String apellidos;
    private String genero;
    private String direccion;
    private String celular;
    private String correo;
    private LocalDate fecha_nac;
    private String tipo;

    public Titular() {
    }

    public Titular(String doc, String nom, String ap, String gen,
                   String direc, String cel, String corr,
                   LocalDate fn, String tip) {

        this.documento = doc;
        this.nombres = nom;
        this.apellidos = ap;
        this.genero = gen;
        this.direccion = direc;
        this.celular = cel;
        this.correo = corr;
        this.fecha_nac = fn;
        this.tipo = tip;
    }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public LocalDate getFechaNac() { return fecha_nac; }
    public void setFechaNac(LocalDate fecha_nac) { this.fecha_nac = fecha_nac; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
