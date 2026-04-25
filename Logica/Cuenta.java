package BANCO3315298.Logica;

import java.time.LocalDate;
import java.util.Random;

public class Cuenta {

    private String numero;
    private String tipo;
    private Titular titular;
    private LocalDate fecha_apertura;
    private double saldo;
    private String clave;
    private String clave_dinamica;

    public Cuenta() {
    }

    public Cuenta(String numero, String tipo, Titular titular,
                  LocalDate fecha_apertura, double saldo,
                  String clave, String clave_dinamica) {

        this.numero = numero;
        this.tipo = tipo;
        this.titular = titular;
        this.fecha_apertura = fecha_apertura;
        this.saldo = saldo;
        this.clave = clave;
        this.clave_dinamica = clave_dinamica;
    }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Titular getTitular() { return titular; }
    public void setTitular(Titular titular) { this.titular = titular; }

    public LocalDate getFecha_apertura() { return fecha_apertura; }
    public void setFecha_apertura(LocalDate fecha_apertura) { this.fecha_apertura = fecha_apertura; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public String getClave_dinamica() { return clave_dinamica; }
    public void setClave_dinamica(String clave_dinamica) { this.clave_dinamica = clave_dinamica; }

    // MÉTODOS

    public void consignar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean retirar(double valor, String clave) {
        if (!this.clave.equals(clave)) {
            System.out.println("-! Clave incorrecta");
            return false;
        }

        if (valor <= 0 || saldo < valor) {
            System.out.println("-! Saldo insuficiente");
            return false;
        }

        saldo -= valor;
        return true;
    }

    public boolean cambiarClave(String nueva, String actual) {
        if (!this.clave.equals(actual)) {
            System.out.println("-! Clave incorrecta");
            return false;
        }

        if (nueva.equals(this.clave)) {
            System.out.println("-! La nueva clave no puede ser igual a la anterior");
            return false;
        }

        this.clave = nueva;
        return true;
    }

    public String generarDinamica() {
        Random aleatorio = new Random();
        String claveDin = "";

        for (int i = 0; i < 6; i++) {
            claveDin += aleatorio.nextInt(10); // 0-9
        }

        this.clave_dinamica = claveDin;
        return claveDin;
    }
}
