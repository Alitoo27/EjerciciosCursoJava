package persona;

public class PruebaPersona {
    public static void main(String[] args) {
        System.out.println("*** creacion de clase y objetos Persona ***");
        var objeto1 = new Persona("Layla", "Acosta");
        objeto1.mostrarpersona();
        //segundo objeto
        System.out.println();
        var objeto2 = new Persona("Ian", "Gomez");
        objeto2.mostrarpersona();
    }
}
