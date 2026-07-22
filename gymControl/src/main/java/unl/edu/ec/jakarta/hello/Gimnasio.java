package unl.edu.ec.jakarta.hello;

import java.util.ArrayList;
import java.util.List;
public class Gimnasio {
    private String nombre;
    private List<Cliente> clientes;
    private List<Empleado> empleados;
    private List<Producto> productos;
    private List<Membresia> membresias;
    public Gimnasio(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.productos = new ArrayList<>();
        this.membresias = new ArrayList<>();
    }
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("✅ Cliente agregado: " + cliente.getNombre());
    }
    public Cliente buscarCliente(String id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("✅ Producto agregado: " + producto.getNombre());
    }
    public List<Producto> getProductos() {
        return productos;
    }
    public void agregarMembresia(Membresia membresia) {
        membresias.add(membresia);
    }
    public void listarMembresiasConCliente() {
        System.out.println("\n=== MEMBRESÍAS REGISTRADAS (con Cliente) ===");
        if (membresias.isEmpty()) {
            System.out.println("No hay membresías registradas.");
            return;
        }
        for (Membresia m : membresias) {
            String clienteNombre = (m.getCliente() != null) ? m.getCliente().getNombre() : "Sin asignar";
            String tipo = m.getClass().getSimpleName()
                    .replace("Membresia", "");
            String fechaVence = (m.getFechaVencimiento() != null)
                    ? m.getFechaVencimiento().toString()
                    : "N/A";
            System.out.printf("ID: %s | Cliente: %s | Tipo: %s | Precio: $%.2f | Estado: %s | Vence: %s%n",
                    m.getId(),
                    clienteNombre,
                    tipo,
                    m.getPrecio(),
                    m.getEstado(),
                    fechaVence);
        }
    }
    public void listarMembresiasActivas() {
        System.out.println("\n=== MEMBRESÍAS ACTIVAS ===");
        boolean hay = false;
        for (Membresia m : membresias) {
            if (m.esActiva()) {
                String tipo = m.getClass().getSimpleName().replace("Membresia", "");
                String clienteNombre = (m.getCliente() != null) ? m.getCliente().getNombre() : "Sin asignar";
                System.out.printf("ID: %s | Cliente: %s | Tipo: %s | Precio: $%.2f | Vence: %s%n",
                        m.getId(), clienteNombre, tipo, m.getPrecio(), m.getFechaVencimiento());
                hay = true;
            }
        }
        if (!hay) System.out.println("No hay membresías activas.");
    }
    public void listarMembresiasPendientes() {
        System.out.println("\n=== MEMBRESÍAS PENDIENTES ===");
        boolean hay = false;
        for (Membresia m : membresias) {
            if (!m.esActiva()) {
                String tipo = m.getClass().getSimpleName().replace("Membresia", "");
                String clienteNombre = (m.getCliente() != null) ? m.getCliente().getNombre() : "Sin asignar";
                System.out.printf("ID: %s | Cliente: %s | Tipo: %s | Precio: $%.2f | Estado: %s%n",
                        m.getId(), clienteNombre, tipo, m.getPrecio(), m.getEstado());
                hay = true;
            }
        }
        if (!hay) System.out.println("No hay membresías pendientes.");
    }
    public void generarReporteIngresos() {
        double total = membresias.stream()
                .filter(Membresia::esActiva)
                .mapToDouble(Membresia::getPrecio)
                .sum();
        System.out.println("\n=== REPORTE DE INGRESOS ===");
        System.out.println("Total estimado mensual de membresías activas: $" + total);
        System.out.println("Total de membresías: " + membresias.size());
    }
    public String getNombre() {
        return nombre;
    }
    public String generarIdAleatorio(String prefijo) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(prefijo);
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < 6; i++) {
            int indice = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(indice));
        }
        return sb.toString();
    }
}

