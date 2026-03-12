
import java.util.Random;
import java.util.Scanner;

public class App {

    static int erroresRango = 0;
    static int erroresNoNumerico = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int max = 100;
        int min = 1;
        int secreto = random.nextInt(100) + 1;
        int intentos = 0;
        int limiteIntentos = 7;
        boolean gano = false;

        System.out.println("Adivina el numero secreto (1-100)");

        while(intentos < limiteIntentos){
            int numero = obtenerNumeroValido(sc, "Intento: " + (intentos + 1), min, max);
            intentos++;

            if(numero == secreto){
                System.out.println("¡Ganaste!");
                gano = true;
                break;
            } else if(numero > secreto){
                System.out.println("El numero secreto es MENOR a " + numero);
            } else {
                System.out.println("El numero secreto es MAYOR a " + numero);
            }
        }

        if(!gano){
            System.out.println("Perdiste, el numero secreto es " + secreto);
        }

        System.out.println("Resumen de errores de entrada");
        System.out.println("Veces fuera de rango: " + erroresRango);
        System.out.println("Veces dato no numérico: " + erroresNoNumerico);

        sc.close();
    }
    public static int obtenerNumeroValido(Scanner sc, String mensaje, int min, int max){
        int valor;
        while (true) {
            System.out.println(mensaje);
            if(sc.hasNextInt()){
                valor = sc.nextInt();
                if(valor >= min && valor <= max){
                    return valor;
                }
                erroresRango++;
                System.out.println("El valor ingresado esta fuera de rango (" + min + "-" + max + ")");
            } else {
                erroresNoNumerico++;
                System.out.println("El dato ingresado no es numerico");
                sc.next();
            }
        }
    }
}