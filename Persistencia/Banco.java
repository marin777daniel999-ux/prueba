package BANCO3315298.Persistencia;

import java.util.LinkedList;
import BANCO3315298.Logica.Cuenta;

public class Banco { 

    private String nit;
    private String razon_social;
    private LinkedList<Cuenta> cuentas;

    public Banco() {
        this.cuentas = new LinkedList<>();
    }

    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }

    public String getRazon_social() { return razon_social; }
    public void setRazon_social(String razon_social) { this.razon_social = razon_social; }

    public LinkedList<Cuenta> getCuentas() { return cuentas; }

    public void guardarCuenta(Cuenta cta) {
        if (buscarCuenta(cta.getNumero()) != null) {
            System.out.println("-! Cuenta ya existente");
            return;
        }
        cuentas.add(cta);
    }

    public Cuenta buscarCuenta(String numero) {
        for (Cuenta c : cuentas) {
            if (c.getNumero().equals(numero)) {
                return c;
            }
        }
        return null;
    }

    public void eliminarCuenta(String numero) {
        Cuenta c = buscarCuenta(numero);
        if (c != null) {
            cuentas.remove(c);
            System.out.println("-| Cuenta eliminada");
        }
    }

    // MÉTODO FALTANTE (IMPORTANTE)
    public boolean realizarTransaccion(String numero, double valor, String tipo, String clave) {

        Cuenta cta = buscarCuenta(numero);

        if (cta == null) {
            System.out.println("-! Cuenta no encontrada");
            return false;
        }

        switch (tipo) {

            case "con":
                cta.consignar(valor);
                System.out.println("-| Consignación exitosa");
                return true;

            case "ret":
                return cta.retirar(valor, clave);

            case "sal":
                if (cta.getClave().equals(clave)) {
                    System.out.println("-| Saldo actual: " + cta.getSaldo());
                    return true;
                } else {
                    System.out.println("-! Clave incorrecta");
                    return false;
                }

            default:
                return false;
        }
    }

    public boolean cambiarClave(String numero, String nueva, String actual) {
        Cuenta cta = buscarCuenta(numero);
        if (cta == null) return false;
        return cta.cambiarClave(nueva, actual);
    }
}
