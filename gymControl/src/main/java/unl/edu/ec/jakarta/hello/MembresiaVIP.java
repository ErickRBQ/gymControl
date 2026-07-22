package unl.edu.ec.jakarta.hello;

import java.time.LocalDate;
import java.util.List;
public class MembresiaVIP extends Membresia {
    private List<String> beneficios;
    public MembresiaVIP(String id, double precio, LocalDate fechaInicio, Cliente cliente) {
        super(id, precio, fechaInicio, cliente);
        aplicarDescuento();   // 15% descuento
        this.beneficios = List.of("Acceso 24h", "Clases ilimitadas", "Asesor personal", "Prioridad");
    }
    @Override
    protected void calcularFechaVencimiento() {
        this.fechaVencimiento = fechaInicio.plusYears(1);
    }
    private void aplicarDescuento() {
        this.precio = this.precio * 0.85;   // 15% descuento
    }
}
