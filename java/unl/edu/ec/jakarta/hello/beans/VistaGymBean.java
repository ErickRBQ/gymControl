package unl.edu.ec.jakarta.hello.beans;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class VistaGymBean {

    private List<PlanVista> planes;
    private List<MiembroVista> miembros;
    private List<InstructorVista> instructores;
    private List<CheckInVista> checkIns;
    private List<PaymentVista> pagos;

    @PostConstruct
    public void init() {
        planes = new ArrayList<>();
        planes.add(new PlanVista("Mensual Básico", "Basic", 50.00, "Gym Access", List.of("Locker", "Shower"), true));
        planes.add(new PlanVista("Trimestral Pro", "Pro", 120.00, "Gym + Pool", List.of("Pool", "Locker", "Classes"), true));
        planes.add(new PlanVista("Anual Premium", "Premium", 300.00, "Gym + Pool + Spa", List.of("Pool", "Spa", "Classes", "Trainer"), true));

        miembros = new ArrayList<>();
        miembros.add(new MiembroVista("AF-20934", "Marcus Thorne", "+1 (555) 123-4567", "m.thorne@apex.com", "Active"));
        miembros.add(new MiembroVista("AF-20935", "Sofia Rivera", "+1 (555) 234-5678", "s.rivera@apex.com", "Expired"));
        miembros.add(new MiembroVista("AF-20936", "Daniel Cruz", "+1 (555) 345-6789", "d.cruz@apex.com", "Active"));

        instructores = new ArrayList<>();
        instructores.add(new InstructorVista("Ana Morales", "CrossFit", "9:00", "4.9", 18, "Active", "https://images.unsplash.com/photo-1518611012118-696072aa579a", true));
        instructores.add(new InstructorVista("Luis Ortega", "Yoga", "11:00", "4.8", 12, "Active", "https://images.unsplash.com/photo-1517836357463-d25dfeac3438", true));
        instructores.add(new InstructorVista("Marta Silva", "Strength", "18:00", "5.0", 21, "On Break", "https://images.unsplash.com/photo-1526401485004-5f7ddf94c6b8", false));

        checkIns = new ArrayList<>();
        checkIns.add(new CheckInVista("Marcus Thorne", "Active Membership • Platinum", "10:05 AM", "Entry Approved"));
        checkIns.add(new CheckInVista("Sofia Rivera", "Paused Membership • Basic", "09:40 AM", "Entry Denied"));
        checkIns.add(new CheckInVista("Daniel Cruz", "Active Membership • Pro", "08:20 AM", "Entry Approved"));

        pagos = new ArrayList<>();
        pagos.add(new PaymentVista("Julianna Dougherty", "Premium Plan", "Card", 120.00, "Oct 12, 2023", "Paid"));
        pagos.add(new PaymentVista("Marcus Sterling", "Basic Plan", "Transfer", 75.00, "Oct 11, 2023", "Pending"));
        pagos.add(new PaymentVista("Helena Suarez", "Pro Plan", "Card", 180.00, "Oct 10, 2023", "Paid"));
        pagos.add(new PaymentVista("Carlos Medina", "Basic Plan", "Transfer", 50.00, "Oct 09, 2023", "Paid"));
    }

    public List<PlanVista> getPlanes() {
        return planes;
    }

    public List<MiembroVista> getMiembros() {
        return miembros;
    }

    public List<InstructorVista> getInstructores() {
        return instructores;
    }

    public List<CheckInVista> getCheckIns() {
        return checkIns;
    }

    public List<PaymentVista> getPagos() {
        return pagos;
    }

    public double getTotalRevenue() {
        return pagos.stream()
                .filter(p -> "Paid".equals(p.getEstado()))
                .mapToDouble(PaymentVista::getAmount)
                .sum();
    }

    public double getPendingBalance() {
        return pagos.stream()
                .filter(p -> "Pending".equals(p.getEstado()))
                .mapToDouble(PaymentVista::getAmount)
                .sum();
    }

    public long getPendingCount() {
        return pagos.stream()
                .filter(p -> "Pending".equals(p.getEstado()))
                .count();
    }

    public int getCardShare() {
        long cardCount = pagos.stream().filter(p -> "Card".equals(p.getMetodo())).count();
        return pagos.isEmpty() ? 0 : (int) ((cardCount * 100) / pagos.size());
    }

    public int getTransferShare() {
        long transferCount = pagos.stream().filter(p -> "Transfer".equals(p.getMetodo())).count();
        return pagos.isEmpty() ? 0 : (int) ((transferCount * 100) / pagos.size());
    }

    public static class PlanVista {
        private final String nombre;
        private final String tipo;
        private final double precio;
        private final String descripcion;
        private final List<String> beneficios;
        private final boolean activo;

        public PlanVista(String nombre, String tipo, double precio, String descripcion, List<String> beneficios, boolean activo) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.precio = precio;
            this.descripcion = descripcion;
            this.beneficios = beneficios;
            this.activo = activo;
        }

        public String getNombre() { return nombre; }
        public String getTipo() { return tipo; }
        public double getPrecio() { return precio; }
        public String getDescripcion() { return descripcion; }
        public List<String> getBeneficios() { return beneficios; }
        public boolean isActivo() { return activo; }
    }

    public static class MiembroVista {
        private final String id;
        private final String nombre;
        private final String telefono;
        private final String email;
        private final String estado;

        public MiembroVista(String id, String nombre, String telefono, String email, String estado) {
            this.id = id;
            this.nombre = nombre;
            this.telefono = telefono;
            this.email = email;
            this.estado = estado;
        }

        public String getId() { return id; }
        public String getNombre() { return nombre; }
        public String getTelefono() { return telefono; }
        public String getEmail() { return email; }
        public String getEstado() { return estado; }
    }

    public static class InstructorVista {
        private final String nombre;
        private final String especialidad;
        private final String horario;
        private final String puntuacion;
        private final int clientes;
        private final String estatus;
        private final String imageUrl;
        private final boolean activo;

        public InstructorVista(String nombre, String especialidad, String horario, String puntuacion, int clientes, String estatus, String imageUrl, boolean activo) {
            this.nombre = nombre;
            this.especialidad = especialidad;
            this.horario = horario;
            this.puntuacion = puntuacion;
            this.clientes = clientes;
            this.estatus = estatus;
            this.imageUrl = imageUrl;
            this.activo = activo;
        }

        public String getNombre() { return nombre; }
        public String getEspecialidad() { return especialidad; }
        public String getHorario() { return horario; }
        public String getPuntuacion() { return puntuacion; }
        public int getClientes() { return clientes; }
        public String getEstatus() { return estatus; }
        public String getImageUrl() { return imageUrl; }
        public boolean isActivo() { return activo; }
    }

    public static class CheckInVista {
        private final String nombre;
        private final String detalle;
        private final String hora;
        private final String estado;

        public CheckInVista(String nombre, String detalle, String hora, String estado) {
            this.nombre = nombre;
            this.detalle = detalle;
            this.hora = hora;
            this.estado = estado;
        }

        public String getNombre() { return nombre; }
        public String getDetalle() { return detalle; }
        public String getHora() { return hora; }
        public String getEstado() { return estado; }
    }

    public static class PaymentVista {
        private final String nombre;
        private final String plan;
        private final String metodo;
        private final double amount;
        private final String fecha;
        private final String estado;

        public PaymentVista(String nombre, String plan, String metodo, double amount, String fecha, String estado) {
            this.nombre = nombre;
            this.plan = plan;
            this.metodo = metodo;
            this.amount = amount;
            this.fecha = fecha;
            this.estado = estado;
        }

        public String getNombre() { return nombre; }
        public String getPlan() { return plan; }
        public String getMetodo() { return metodo; }
        public double getAmount() { return amount; }
        public String getFecha() { return fecha; }
        public String getEstado() { return estado; }
        public String getFormattedAmount() { return String.format("$%.2f", amount); }
        public String getIniciales() {
            if (nombre == null || nombre.isBlank()) {
                return "?";
            }
            String[] partes = nombre.trim().split("\\s+");
            if (partes.length == 1) {
                return partes[0].substring(0, 1).toUpperCase();
            }
            String primera = partes[0].substring(0, 1).toUpperCase();
            String segunda = partes[partes.length - 1].substring(0, 1).toUpperCase();
            return primera + segunda;
        }
    }
}
