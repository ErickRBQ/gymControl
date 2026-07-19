package unl.edu.ec.jakarta.hello;

import java.time.LocalDate;
public class MembresiaMensual extends Membresia {
    public MembresiaMensual(String id, double precio, LocalDate fechaInicio, Cliente cliente) {
        super(id, precio, fechaInicio, cliente);
    }
    @Override
    protected void calcularFechaVencimiento() {
        this.fechaVencimiento = fechaInicio.plusMonths(1);
    }
}
