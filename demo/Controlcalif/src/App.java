import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService service = new GradeService();
        boolean seguir = true;

        while (seguir) {
            String nombre = leerTextoNoVacio(sc, "Nombre");
            double p1 = leerDoubleEnRango(sc, "Parcial 1 0 a 100", 0, 100);
            double p2 = leerDoubleEnRango(sc, "Parcial 2 0 a 100", 0, 100);
            double p3 = leerDoubleEnRango(sc, "Parcial 3 0 a 100", 0, 100);
            int asis = leerIntEnRango(sc, "Asistencia 0 a 100", 0, 100);
            boolean proy = leerBoolean(sc, "Proyecto true o false");

            double prom = service.calcularPromedio(p1, p2, p3);
            double fin = service.calcularFinal(prom, asis);
            String est = service.determinarEstado(fin, asis, proy);

            imprimirReporte(nombre, p1, p2, p3, prom, asis, proy, fin, est);

            System.out.println("Otro alumno? true o false");
            seguir = leerBoolean(sc, "Opcion");
        }
    }

    public static String leerTextoNoVacio(Scanner sc, String msg) {
        String t = "";
        while (t.trim().isEmpty()) {
            System.out.println(msg);
            t = sc.nextLine();
        }
        return t;
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double v;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextDouble()) {
                v = sc.nextDouble();
                if (v >= min && v <= max) { sc.nextLine(); return v; }
            } else { sc.next(); }
            System.out.println("Invalido");
        }
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int v;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                v = sc.nextInt();
                if (v >= min && v <= max) { sc.nextLine(); return v; }
            } else { sc.next(); }
            System.out.println("Invalido");
        }
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg);
            String i = sc.next();
            sc.nextLine();
            if (i.equalsIgnoreCase("true")) return true;
            if (i.equalsIgnoreCase("false")) return false;
            System.out.println("Use true o false");
        }
    }

    public static void imprimirReporte(String n, double p1, double p2, double p3, double pr, int as, boolean py, double f, String e) {
        System.out.println("REPORTE");
        System.out.println("Nombre " + n);
        System.out.println("Promedio " + pr);
        System.out.println("Asistencia " + as);
        System.out.println("Proyecto " + py);
        System.out.println("Final " + f);
        System.out.println("Estado " + e);
    }
}