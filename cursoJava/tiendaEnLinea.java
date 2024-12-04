public class tiendaEnLinea {
    public static void main(String[] args) {
        var nombreCliente = "raul";
        var diasEstancia = 5;
        var tarifaDiaria = 5000.00;
        var hasVistaMar = false;

        System.out.println("nombreCliente = " + nombreCliente);
        System.out.println("diasEstancia = " + diasEstancia);
        System.out.println("tarifaDiaria = " + tarifaDiaria);
        System.out.println("hasVistaMar = " + hasVistaMar);

        nombreCliente = "pepe";
        diasEstancia = 7;
        tarifaDiaria = 6000.00;
        hasVistaMar = true;

        System.out.println();
        System.out.println("nombreCliente = " + nombreCliente);
        System.out.println("diasEstancia = " + diasEstancia);
        System.out.println("tarifaDiaria = " + tarifaDiaria);
        System.out.println("hasVistaMar = " + hasVistaMar);
    }
}
