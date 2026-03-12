import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa tu edad:");
        int edad = sc.nextInt();
        System.out.println("¿Eres estudiante? (true/false):");
        boolean esEstudiante = sc.nextBoolean();
        int tarifa = 0;
        if (edad < 0 || edad > 120) {
            System.out.println("Edad inválida");
            return;
        }
        if (edad < 12) {
            tarifa = 50;
        } else if (edad >= 12 && edad <= 17) {
            if (esEstudiante) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }
        } else {
            if (esEstudiante) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
        }
        System.out.println("Edad ingresada: " + edad);
        System.out.println("Es estudiante: " + esEstudiante);
        System.out.println("Tarifa final: " + tarifa);
        sc.close();
    }
}