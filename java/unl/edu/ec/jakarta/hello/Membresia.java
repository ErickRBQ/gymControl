package unl.edu.ec.jakarta.hello;

import java.time.LocalDate;
public abstract class Membresia {
    protected String id;
    protected double precio;
    protected LocalDate fechaInicio;
    protected LocalDate fechaVencimiento;
    protected EstadoMembresia estado;
    protected Cliente cliente;
    public Membresia(String id, double precio, LocalDate fechaInicio, Cliente cliente) {
        this.id = id;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.cliente = cliente;
        this.estado = EstadoMembresia.ACTIVA;
        calcularFechaVencimiento();
    }
    protected abstract void calcularFechaVencimiento();
    public boolean esActiva() {
        return estado == EstadoMembresia.ACTIVA &&
                LocalDate.now().isBefore(fechaVencimiento);
    }
    public boolean estaPendiente() {
        return estado == EstadoMembresia.PENDIENTE;
    }
    public void renovar() {
        this.fechaInicio = LocalDate.now();
        calcularFechaVencimiento();
        this.estado = EstadoMembresia.ACTIVA;
    }
    public String getId() { return id; }
    public double getPrecio() { return precio; }
    public Cliente getCliente() { return cliente; }
    public EstadoMembresia getEstado() { return estado; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
}