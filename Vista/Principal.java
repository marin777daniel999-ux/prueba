package BANCO3315298.Vista;

import java.time.LocalDate;
import java.util.Scanner;

import BANCO3315298.Logica.Cuenta; 
import BANCO3315298.Logica.Titular;
import BANCO3315298.Persistencia.Banco;

public class Principal {

    static Scanner sc = new Scanner(System.in);
    static Banco banco = null;

    public static void main(String[] args) {
        System.out.println("-#| BANCO-SENA |#-");
        menu();
    }

    public static void menu() {

        System.out.println("\n1. Abrir banco");
        System.out.println("2. Crear cuenta");
        System.out.println("3. Consultar cuenta vieja");
        System.out.println("4. Eliminar cuenta lololo");
        System.out.println("5. Listar cuentas");
        System.out.println("6. Transacciones");
        System.out.println("7. Salir hola");

        String op = sc.next();

        switch (op) {
            case "1": abrirBanco(); break;
            case "2": crearCuenta(); break;
            case "3": consultarCuenta(); break;
            case "4": eliminarCuenta(); break;
            case "5": listarCuentas(); break;
            case "6": transacciones(); break;
            case "7": System.exit(0);
            default: menu();
        }
    }

    private static void abrirBanco() {
        if (banco == null) {
            banco = new Banco();
            System.out.println("NIT:");
            banco.setNit(sc.next());
            System.out.println("Razón social:");
            banco.setRazon_social(sc.next());
        }
        menu();
    }

    private static void crearCuenta() {

        if (banco == null) {
            System.out.println("Debe abrir el banco primero");
            menu();
            return;
        }

        Titular t = new Titular();
        System.out.println("Documento:");
        t.setDocumento(sc.next());
        System.out.println("Nombre:");
        t.setNombres(sc.next());
        System.out.println("Apellido:");
        t.setApellidos(sc.next());
        t.setFechaNac(LocalDate.now());

        Cuenta c = new Cuenta();
        System.out.println("Número:");
        c.setNumero(sc.next());
        System.out.println("Tipo:");
        c.setTipo(sc.next());
        c.setTitular(t);
        c.setFecha_apertura(LocalDate.now());
        System.out.println("Clave:");
        c.setClave(sc.next());
        System.out.println("Saldo:");
        c.setSaldo(sc.nextDouble());

        banco.guardarCuenta(c);
        menu();
    }

    private static void consultarCuenta() {
        System.out.println("Número cuenta:");
        Cuenta c = banco.buscarCuenta(sc.next());

        if (c != null) {
            System.out.println("Titular: " + c.getTitular().getNombres());
            System.out.println("Saldo: " + c.getSaldo());
        }

        menu();
    }

    private static void eliminarCuenta() {
        System.out.println("Número:");
        banco.eliminarCuenta(sc.next());
        menu();
    }

    private static void listarCuentas() {
        for (Cuenta c : banco.getCuentas()) {
            System.out.println(c.getNumero() + " - " + c.getTitular().getNombres());
        }
        menu();
    }

    private static void transacciones() {

        System.out.println("1. Consignar");
        System.out.println("2. Retirar");
        System.out.println("3. Consultar saldo");

        int op = sc.nextInt();

        System.out.println("Número:");
        String num = sc.next();

        switch (op) {

            case 1:
                System.out.println("Valor:");
                banco.realizarTransaccion(num, sc.nextDouble(), "con", "");
                break;

            case 2:
                System.out.println("Clave:");
                String cla = sc.next();
                System.out.println("Valor:");
                banco.realizarTransaccion(num, sc.nextDouble(), "ret", cla);
                break;

            case 3:
                System.out.println("Clave:");
                banco.realizarTransaccion(num, 0, "sal", sc.next());
                break;
        }

        menu();
    }
}
