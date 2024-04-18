package CajeroAutomatico;

public class TarjetaEFS 
{
    private String numeroTarjeta;
    private String tipo;

    public TarjetaEFS(String numeroTarjeta, String tipo)
    {
        this.numeroTarjeta = numeroTarjeta;
        this.tipo = tipo;
    }

    public String getNumeroTarjeta()
    {
        return numeroTarjeta;
    }
}
