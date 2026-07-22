package unl.edu.ec.jakarta.hello;

public class PagoTarjeta implements Pago {
    private String numeroTarjeta;
    public PagoTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("💳 Procesando pago con tarjeta (" + numeroTarjeta + ") por $" + monto);
        return true;
    }
    @Override
    public String obtenerComprobante() {
        return "Comprobante Tarjeta - " + java.time.LocalDate.now();
    }
}
