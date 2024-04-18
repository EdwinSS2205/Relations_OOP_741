package CajeroAutomatico;

public class TransacciónEFS 
{
	private String idTransaccion;
    private double monto;
    private String tipo;

    public TransacciónEFS(String idTransaccion, double monto, String tipo) 
    {
        this.idTransaccion = idTransaccion;
        this.monto = monto;
        this.tipo = tipo;
    }

    public String getIdTransaccion()
    {
        return idTransaccion;
    }

    public double getMonto() 
    {
        return monto;
    }

    public String getTipo() 
    {
        return tipo;
    }
}
