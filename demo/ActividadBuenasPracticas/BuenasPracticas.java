import java.util.Scanner;

public class BuenasPracticas {

    public static void main(String[] args) {
        int numeroLimite = pedirEntero("Ingrese un número entero positivo: ");
        int resultadoSuma = calcularSumaAcumulada(numeroLimite);

        mostrarResultado(numeroLimite, resultadoSuma);
    }
    public static int pedirEntero(String mensaje) {
        Scanner lector = new Scanner(System.in);
        System.out.print(mensaje);
        return lector.nextInt();
    }
    public static int calcularSumaAcumulada(int n) {
        int sumaTotal = 0;
        for (int i = 1; i <= n; i++) {
            sumaTotal += i;
        }
        return sumaTotal;
    }
    public static void mostrarResultado(int limite, int resultado) {
        System.out.println("------------------------------------------");
        System.out.println("La suma de los números del 1 al " + limite + " es: " + resultado);
        System.out.println("------------------------------------------");
    }
}