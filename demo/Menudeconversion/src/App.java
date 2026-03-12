import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        int contadorCF = 0;
        int contadorFC = 0;
        int contadorKM = 0;
        int contadorMK = 0;

        do {
            mostrarMenu();
            opcion = (int) obtenerNumero(sc, "Elige una opción: ", 1, 5, true);

            if (opcion != 5) {
                double valor = obtenerNumero(sc, "Ingresa la cantidad a convertir:", -100000, 100000, false);
                double resultado = 0;

                switch (opcion) {
                    case 1:
                        resultado = (valor * 9/5) + 32;
                        System.out.println("Resultado: " + valor + " °C = " + resultado + " °F");
                        contadorCF++;
                        break;
                    case 2:
                        resultado = (valor - 32) * 5/9;
                        System.out.println("Resultado: " + valor + " °F = " + resultado + " °C");
                        contadorFC++;
                        break;
                    case 3:
                        resultado = valor * 0.621371;
                        System.out.println("Resultado: " + valor + " Km = " + resultado + " Millas");
                        contadorKM++;
                        break;
                    case 4:
                        resultado = valor * 1.60934;
                        System.out.println("Resultado: " + valor + " Millas = " + resultado + " Km");
                        contadorMK++;
                        break;
                }
            }

        } while (opcion != 5);

        int total = contadorCF + contadorFC + contadorKM + contadorMK;
        System.out.println("RESUMEN");
        System.out.println("Total de conversiones realizadas: " + total);
        System.out.println("1) °C a °F: " + contadorCF);
        System.out.println("2) °F a °C: " + contadorFC);
        System.out.println("3) Km a Millas: " + contadorKM);
        System.out.println("4) Millas a Km: " + contadorMK);
        System.out.println("Hasta luego");

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("MENÚ DE CONVERSIONES");
        System.out.println("1) °C a °F");
        System.out.println("2) °F a °C");
        System.out.println("3) Km a Millas");
        System.out.println("4) Millas a Km");
        System.out.println("5) Salir");
    }

    public static double obtenerNumero(Scanner sc, String mensaje, double min, double max, boolean esEntero) {
        double valor;
        while (true) {
            System.out.println(mensaje);
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();

                if (esEntero && (valor % 1 != 0)) {
                    System.out.println("Error: Debes ingresar un número entero.");
                    continue;
                }

                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.println("El valor está fuera de rango (" + min + " - " + max + ")");
            } else {
                System.out.println("Error: El dato ingresado no es numérico.");
                sc.next();
            }
        }
    }
}