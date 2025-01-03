package ventas;

public class pruebaVentas {
    public static void main(String[] args) {
        System.out.println("*** sistema de ventas ***");
        var producto1 = new Producto("blusa", 5000.00);
        var producto2 = new Producto("Zapatos", 10000.00);

        var orden1 = new Orden();
        orden1.agregarProductos(producto1);
        orden1.agregarProductos(producto2);
        orden1.mostrarOrden();

        var orden2 = new Orden();
        orden2.agregarProductos(producto1);
        orden2.agregarProductos(new Producto("playera", 3000.00));
        orden2.mostrarOrden();
    }
}
