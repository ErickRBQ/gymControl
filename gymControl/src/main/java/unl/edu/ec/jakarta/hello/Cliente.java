package unl.edu.ec.jakarta.hello;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Cliente extends Persona {
    private LocalDate fechaRegistro;
    private List<Membresia> membresias;
    public Cliente(String id, String nombre, String telefono, String email, String direccion) {
        super(id, nombre, telefono, email, direccion);
        this.fechaRegistro = LocalDate.now();
        this.membresias = new ArrayList<>();
    }
    public void agregarMembresia(Membresia membresia) {
        this.membresias.add(membresia);
    }
    public List<Membresia> getMembresiasActivas() {
        return membresias.stream()
                .filter(Membresia::esActiva)
                .toList();
    }
    public List<Membresia> getMembresias() {
        return membresias;
    }
    @Override
    public String getDatosPersonales() {
        return super.getDatosPersonales() + " | Cliente desde: " + fechaRegistro;
    }
}
