package unl.edu.ec.jakarta.hello;

public class PagoEfectivo implements Pago {
    @Override
    public boolean procesarPago(double monto) {
        System.out.println("💵 Pago en efectivo recibido: $" + monto);
        return true;
    }
    @Override
    public String obtenerComprobante() {
        return "Comprobante Efectivo - " + java.time.LocalDate.now();
    }
}
