import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("MENU");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular area de un rectangulo");
            System.out.println("3. Convertir C a F");
            System.out.println("4. Calcular area de un circulo");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion: ");

            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Peso en kilos (ejemplo 80): ");
                    double peso = leer.nextDouble();
                    System.out.print("Altura en centimetros (ejemplo 175): ");
                    double alturaCm = leer.nextDouble();

                    double alturaM = alturaCm / 100; // Conversion interna
                    double imc = calcularIMC(peso, alturaM);

                    System.out.println("RESULTADO IMC: " + imc);
                    System.out.println("CLASIFICACION: " + obtenerClasificacion(imc));
                    break;

                case 2:
                    System.out.print("Base: ");
                    double base = leer.nextDouble();
                    System.out.print("Altura: ");
                    double altR = leer.nextDouble();
                    System.out.println("\nAREA RECTANGULO: " + calcularAreaRectangulo(base, altR));
                    break;

                case 3:
                    System.out.print("Grados Celsius: ");
                    double c = leer.nextDouble();
                    System.out.println("\nGRADOS FAHRENHEIT: " + convertirCelsiusFahrenheit(c));
                    break;

                case 4:
                    System.out.print("Radio: ");
                    double r = leer.nextDouble();
                    System.out.println("\nAREA CIRCULO: " + calcularAreaCirculo(r));
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

            if (opcion != 5) {
                System.out.println("\nPresiona ENTER para volver al menu...");
                leer.nextLine();
                leer.nextLine();
            }

        } while (opcion != 5);

        leer.close();
    }

    /**
     * Calcula el IMC
     * @param peso en kg
     * @param altura en metros
     * @return resultado imc
     */
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    /**
     * Clasifica el IMC
     * @param imc valor numerico
     * @return texto de clasificacion
     */
    public static String obtenerClasificacion(double imc) {
        if (imc < 18.5) return "Bajo peso";
        else if (imc < 25) return "Peso medio";
        else if (imc < 30) return "Sobre peso";
        else return "Obesidad";
    }

    /**
     * Area de rectangulo
     * @param base base
     * @param altura altura
     * @return area
     */
    public static double calcularAreaRectangulo(double base, double altura) {
        return base * altura;
    }

    /**
     * Celsius a Fahrenheit
     * @param celsius grados C
     * @return grados F
     */
    public static double convertirCelsiusFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    /**
     * Area de circulo
     * @param radio radio
     * @return area
     */
    public static double calcularAreaCirculo(double radio) {
        return 3.1416 * (radio * radio);
    }
}