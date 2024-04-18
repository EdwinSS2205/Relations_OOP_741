package CajeroAutomatico;

import java.util.Arrays;
import java.util.Scanner;

public class MenuPrincipalEFS 
{
	public static void main(String[] args) {

		CuentaBancariaEFS cuenta1 = new CuentaBancariaEFS("123456789", 1000);
        CuentaBancariaEFS cuenta2 = new CuentaBancariaEFS("987654321", 2000);
        
        ClienteEFS cliente1 = new ClienteEFS("Cliente1", Arrays.asList(cuenta1, cuenta2), "1234");
        
        CajeroEFS cajero = new CajeroEFS();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su tarjeta:");
        String numeroTarjeta = scanner.nextLine();
        System.out.println("Ingrese su PIN:");
        String pin = scanner.nextLine();
        
        ClienteEFS cliente = cajero.autenticarCliente(numeroTarjeta, pin);
        
        if (cliente != null) 
        {
            
            int opcion;
            do {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Retirar dinero");
                System.out.println("3. Depositar fondos");
                System.out.println("4. Transferir fondos");
                System.out.println("5. Salir");
                opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1:
                        cliente.consultarSaldo();
                        break;
                    case 2:
                        cliente.retirar(cajero);
                        break;
                    case 3:
                        cliente.depositar(cajero);
                        break;
                    case 4:
                        cliente.transferir(cajero);
                        break;
                    case 5:
                        System.out.println("Gracias por utilizar nuestros servicios.");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            }
            while (opcion != 5);
            
        } 
        else 
        {
            System.out.println("Tarjeta o PIN incorrectos. Por favor, inténtelo de nuevo.");
        }
        
        scanner.close();
    }

}
