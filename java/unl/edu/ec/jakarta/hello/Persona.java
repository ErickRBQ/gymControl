package unl.edu.ec.jakarta.hello;

public abstract class Persona {
    protected String id;
    protected String nombre;
    protected String telefono;
    protected String email;
    protected String direccion;
    public Persona(String id, String nombre, String telefono, String email, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }
    public String getDatosPersonales() {
        return "ID: " + id + " | Nombre: " + nombre;
    }
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
}
