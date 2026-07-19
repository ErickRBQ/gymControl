package unl.edu.ec.jakarta.hello;

public class Instructor extends Empleado {
    private String especialidad;
    private int horasClase;
    public Instructor(String id, String nombre, String telefono, String email, String direccion,
                      double salario, String especialidad) {
        super(id, nombre, telefono, email, direccion, salario, "Instructor");
        this.especialidad = especialidad;
        this.horasClase = 0;
    }
    public void dictarClase() {
        horasClase++;
        System.out.println(nombre + " impartió una clase de " + especialidad);
    }
    @Override
    public double calcularSueldo() {
        return salario + (horasClase * 8.50); // bono por hora
    }
}
