package unl.edu.ec.jakarta.hello;

import gym.modelo.excepciones.StockInsuficienteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Factura {
    private String numeroFactura;
    private LocalDate fechaEmision;
    private Cliente cliente;
    private List<Producto> productos;
    private double subtotal;
    private double total;
    public Factura(String numeroFactura, Cliente cliente) {
        this.numeroFactura = numeroFactura;
        this.fechaEmision = LocalDate.now();
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.subtotal = 0.0;
        this.total = 0.0;
    }
    public void agregarProducto(Producto producto, int cantidad) throws StockInsuficienteException {
        producto.reducirStock(cantidad);
        productos.add(producto);
        subtotal += producto.getPrecioBase() * cantidad;
        total = subtotal * 1.12; // IVA 12%
    }
    public void registrarPago(Pago pago) {
        boolean exito = pago.procesarPago(total);
        if (exito) {
            System.out.println("✅ Pago registrado correctamente - Factura: " + numeroFactura);
        } else {
            System.out.println("❌ Error en el pago");
        }
    }
    public void mostrarFactura() {
        System.out.println("\n=== FACTURA " + numeroFactura + " ===");
        System.out.println("Fecha: " + fechaEmision);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("----------------------------------");
        for (Producto p : productos) {
            System.out.println("- " + p.getNombre() + " | Precio final: $" + p.calcularPrecioFinal());
        }
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Total (IVA incl.): $" + total);
        System.out.println("==================================\n");
    }
    public String getNumeroFactura() {
        return numeroFactura;
    }
}
