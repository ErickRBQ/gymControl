package unl.edu.ec.jakarta.hello;
import gym.modelo.excepciones.StockInsuficienteException;
public abstract class Producto {
    protected String codigo;
    protected String nombre;
    protected int stock;
    protected double precioBase;
    public Producto(String codigo, String nombre, int stock, double precioBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.precioBase = precioBase;
    }
    public abstract double calcularPrecioFinal();
    public void reducirStock(int cantidad) throws StockInsuficienteException {
        if (cantidad > stock) {
            throw new StockInsuficienteException("Stock insuficiente para: " + nombre);
        }
        stock -= cantidad;
    }
    public String getNombre() { return nombre; }
    public int getStock() { return stock; }
    public double getPrecioBase() { return precioBase; }
}
