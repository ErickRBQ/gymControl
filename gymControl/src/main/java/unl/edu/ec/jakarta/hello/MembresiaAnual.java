package unl.edu.ec.jakarta.hello;

import java.time.LocalDate;
public class MembresiaAnual extends Membresia {
    public MembresiaAnual(String id, double precio, LocalDate fechaInicio, Cliente cliente) {
        super(id, precio, fechaInicio, cliente);
        aplicarDescuento();   // 8% descuento
    }
    @Override
    protected void calcularFechaVencimiento() {
        this.fechaVencimiento = fechaInicio.plusYears(1);
    }
    private void aplicarDescuento() {
        this.precio = this.precio * 0.92;   // 8% descuento
    }
}