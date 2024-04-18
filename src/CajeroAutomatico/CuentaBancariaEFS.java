package CajeroAutomatico;

public class CuentaBancariaEFS
{
	private String numeroCuenta;
    private double saldo;
    
    public CuentaBancariaEFS(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
    
    public String getNumeroCuenta()
    {
        return numeroCuenta;
    }

	public double getSaldo() 
	{
		return saldo;
	}

	
	public boolean retirar(double monto)
	{
        if (monto > 0 && saldo >= monto) 
        {
            saldo -= monto;
            return true;
        }
        return false;
    }
    
    public void depositar(double monto) 
    {
        if (monto > 0)
        {
            saldo += monto;
        }
    }
    
    public boolean transferir(CuentaBancariaEFS cuentaDestino, double monto)
    {
        if (retirar(monto))
        {
            cuentaDestino.depositar(monto);
            return true;
        }
        return false;
    }
}
