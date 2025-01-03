package ventas;

public class Orden {
    private int idOrden;
    private Producto[] productos;
    private int contadorProductos;
    private static final int MAX_PRODUCTOS = 10;
    private static int contadorOrdenes;

    public Orden() {
        this.idOrden = ++Orden.contadorOrdenes;
        this.productos = new Producto[Orden.MAX_PRODUCTOS];
    }

    public void agregarProductos(Producto producto){
        if(this.contadorProductos < Orden.MAX_PRODUCTOS)
            this.productos[this.contadorProductos++] = producto;
        else
            System.out.println("se ha superado el maximo de productos: " + Orden.MAX_PRODUCTOS);
    }

    public double calcularTotal(){
        double total = 0;
        for(var i = 0; i < this.contadorProductos; i++){
            var producto = this.productos[i];
            total += producto.getPrecio();
        }
        return total;
    }
    public void mostrarOrden(){
        System.out.println("id orden: "+ this.idOrden);
        var totalOrden = this.calcularTotal();
        System.out.println("\ttotal de la orden: $" + totalOrden);
        System.out.println("\tproductos de la orden: ");
        for(var i = 0; i < this.contadorProductos; i++)
            System.out.println("\t\t" + this.productos[i]);
    }

}
