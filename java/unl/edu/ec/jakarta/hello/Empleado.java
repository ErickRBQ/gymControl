package unl.edu.ec.jakarta.hello;

import java.time.LocalDate;
public class Empleado extends Persona {
    protected double salario;
    protected String cargo;
    protected LocalDate fechaContratacion;
    public Empleado(String id, String nombre, String telefono, String email, String direccion,
                    double salario, String cargo) {
        super(id, nombre, telefono, email, direccion);
        this.salario = salario;
        this.cargo = cargo;
        this.fechaContratacion = LocalDate.now();
    }
    public double calcularSueldo() {
        return salario;
    }
    public String getCargo() {
        return cargo;
    }
}
