package unl.edu.ec.jakarta.hello;

public interface Pago {
    boolean procesarPago(double monto);
    String obtenerComprobante();
}