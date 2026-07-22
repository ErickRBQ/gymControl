package unl.edu.ec.jakarta.hello;

public class Suplemento extends Producto {
    private String marca;
    private String sabor;
    public Suplemento(String codigo, String nombre, int stock, double precioBase, String marca, String sabor) {
        super(codigo, nombre, stock, precioBase);
        this.marca = marca;
        this.sabor = sabor;
    }
    @Override
    public double calcularPrecioFinal() {
        return precioBase * 1.12; // IVA 12%
    }
}
