package CajeroAutomatico;
import java.util.List;
import java.util.Scanner;


public class ClienteEFS  
{
	private String idCliente;
    private List<CuentaBancariaEFS> cuentas;
    private String pin;
    
    public ClienteEFS(String idCliente, List<CuentaBancariaEFS> cuentas, String pin)
    {
        this.idCliente = idCliente;
        this.cuentas = cuentas;
        this.pin = pin;
    }
    

    public void consultarSaldo() 
    {
        for (CuentaBancariaEFS cuenta : cuentas)
        {
            System.out.println("Cuenta: " + cuenta.getNumeroCuenta() + ", Saldo: " + cuenta.getSaldo());
        }
    }
    
    public void retirar(CajeroEFS cajero) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de cuenta:");
        String numeroCuenta = scanner.nextLine();
        System.out.println("Ingrese el monto a retirar:");
        double monto = scanner.nextDouble();
        scanner.nextLine(); 
        
        for (CuentaBancariaEFS cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                cuenta.retirar(monto);
                System.out.println("Retiro exitoso. Nuevo saldo: " + cuenta.getSaldo());
                return;
            }
        }
        
        System.out.println("Número de cuenta incorrecto. Inténtelo de nuevo.");
    }
    
    public void depositar(CajeroEFS cajero) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de cuenta:");
        String numeroCuenta = scanner.nextLine();
        System.out.println("Ingrese el monto a depositar:");
        double monto = scanner.nextDouble();
        scanner.nextLine(); 
        
        for (CuentaBancariaEFS cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                cuenta.depositar(monto);
                System.out.println("Depósito exitoso. Nuevo saldo: " + cuenta.getSaldo());
                return;
            }
        }
        
        System.out.println("Número de cuenta incorrecto. Inténtelo de nuevo.");
    }
    
    public void transferir(CajeroEFS cajero) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de cuenta de origen:");
        String numeroCuentaOrigen = scanner.nextLine();
        System.out.println("Ingrese el número de cuenta de destino:");
        String numeroCuentaDestino = scanner.nextLine();
        System.out.println("Ingrese el monto a transferir:");
        double monto = scanner.nextDouble();
        scanner.nextLine(); 
        
        CuentaBancariaEFS cuentaOrigen = null;
        CuentaBancariaEFS cuentaDestino = null;
        

        for (CuentaBancariaEFS cuenta : cuentas)
        {
            if (cuenta.getNumeroCuenta().equals(numeroCuentaOrigen)) 
            {
                cuentaOrigen = cuenta;
            } else if (cuenta.getNumeroCuenta().equals(numeroCuentaDestino)) 
            {
                cuentaDestino = cuenta;
            }
        }
        

        if (cuentaOrigen != null && cuentaDestino != null)
        {
            if (cuentaOrigen.transferir(cuentaDestino, monto))
            {
                System.out.println("Transferencia exitosa.");
                System.out.println("Nuevo saldo en cuenta de origen: " + cuentaOrigen.getSaldo());
                System.out.println("Nuevo saldo en cuenta de destino: " + cuentaDestino.getSaldo());
            }
            else
            {
                System.out.println("Saldo insuficiente en la cuenta de origen.");
            }
        } 
        else 
        {
            System.out.println("Número de cuenta incorrecto. Inténtelo de nuevo.");
        }
    }
}

