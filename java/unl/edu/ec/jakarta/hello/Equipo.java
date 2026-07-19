package unl.edu.ec.jakarta.hello;

public class Equipo extends Producto {
    private int garantiaMeses;
    public Equipo(String codigo, String nombre, int stock, double precioBase, int garantiaMeses) {
        super(codigo, nombre, stock, precioBase);
        this.garantiaMeses = garantiaMeses;
    }
    @Override
    public double calcularPrecioFinal() {
        return precioBase * 1.15; // IVA + margen
    }
}
