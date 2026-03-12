import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");

        System.out.print("Selecciona una opcion: ");
        int opcion = sc.nextInt();

        System.out.print("Ingrese el valor de a: ");
        double a = sc.nextDouble();
        System.out.print("Ingrese el valor de b: ");
        double b = sc.nextDouble();

        double resultado = 0;
        String operacion = "";
        boolean errorDivisión = false;
        boolean opcionValida = true;

        switch (opcion) {
            case 1:
                operacion = "Suma";
                resultado = a + b;
                break;
            case 2:
                operacion = "Resta";
                resultado = a - b;
                break;
            case 3:
                operacion = "Multiplicación";
                resultado = a * b;
                break;
            case 4:
                operacion = "División";
                if (b == 0) {
                    System.out.println("No se puede dividir entre cero");
                    errorDivisión = true;
                } else {
                    resultado = a / b;
                }
                break;
            default:
                System.out.println("Opción inválida");
                opcionValida = false;
                break;
        }

        if (opcionValida && !errorDivisión) {
            System.out.println("Operación: " + operacion);
            System.out.println("Valores: a = " + a + ", b = " + b);
            System.out.println("Resultado: " + resultado);
        }

        sc.close();
    }
}