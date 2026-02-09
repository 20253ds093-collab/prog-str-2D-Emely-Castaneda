import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShippingCalculator calc = new ShippingCalculator();
        boolean continuar = true;

        while (continuar) {
            double peso = leerDoubleEnRango(sc, "Peso 0.1 a 50.0", 0.1, 50.0);
            int dist = leerIntEnRango(sc, "Distancia 1 a 2000", 1, 2000);
            int serv = leerIntEnRango(sc, "Tipo servicio 1 Estandar 2 Express", 1, 2);
            boolean remota = leerBoolean(sc, "Es zona remota true o false");

            double subtotal = calc.calcularSubtotal(peso, dist, serv, remota);
            double iva = calc.calcularIVA(subtotal);
            double total = calc.calcularTotal(subtotal, iva);

            imprimirTicket(serv, peso, dist, remota, subtotal, iva, total);

            System.out.println("Desea realizar otro calculo?");
            continuar = leerBoolean(sc, "true o false");
        }
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double valor;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                if (valor >= min && valor <= max) return valor;
            } else {
                sc.next();
            }
            System.out.println("Error fuera de rango");
        }
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= min && valor <= max) return valor;
            } else {
                sc.next();
            }
            System.out.println("Error fuera de rango");
        }
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg);
            String input = sc.next();
            if (input.equalsIgnoreCase("true")) return true;
            if (input.equalsIgnoreCase("false")) return false;
            System.out.println("Error use true o false");
        }
    }

    public static void imprimirTicket(int s, double p, int d, boolean z, double sub, double iva, double tot) {
        System.out.println("TICKET DE ENVIO");
        System.out.println("Servicio " + (s == 1 ? "Estandar" : "Express"));
        System.out.println("Peso " + p + " kg");
        System.out.println("Distancia " + d + " km");
        System.out.println("Zona remota " + z);
        System.out.println("Subtotal " + sub);
        System.out.println("IVA " + iva);
        System.out.println("Total final " + tot);
        System.out.println("---------------------------");
    }
}