package CajeroAutomatico;

import java.util.Arrays;

public class CajeroEFS 
{
	public ClienteEFS autenticarCliente(String numeroTarjeta, String pin)
	{

		return new ClienteEFS("Cliente1", Arrays.asList(new CuentaBancariaEFS("123456789", 1000), new CuentaBancariaEFS("987654321", 2000)), "1234");
    }
}
