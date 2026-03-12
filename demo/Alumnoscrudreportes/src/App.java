import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona[] personas = new Persona[25];
        int total = 0;
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("1 Alta persona");
            System.out.println("2 Buscar por ID");
            System.out.println("3 Actualizar promedio");
            System.out.println("4 Baja logica");
            System.out.println("5 Listar activas");
            System.out.println("6 Reportes");
            System.out.println("0 Salir");

            if (!sc.hasNextInt()) {
                System.out.println("Opcion invalida");
                sc.next();
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                if (total < 25) {
                    System.out.println("ID");
                    int idIn = sc.nextInt();
                    sc.nextLine();

                    boolean rep = false;
                    for (int i = 0; i < total; i++) {
                        if (personas[i] != null && personas[i].getId() == idIn) rep = true;
                    }

                    if (idIn > 0 && !rep) {
                        System.out.println("Nombre");
                        String nomIn = sc.nextLine();
                        System.out.println("Promedio 0 a 10");
                        double promIn = sc.nextDouble();

                        if (!nomIn.trim().isEmpty() && promIn >= 0 && promIn <= 10) {
                            personas[total] = new Persona(idIn, nomIn, promIn);
                            total++;
                        } else {
                            System.out.println("Datos invalidos");
                        }
                    } else {
                        System.out.println("ID invalido o repetido");
                    }
                }
            } else if (opcion == 2) {
                System.out.println("ID a buscar");
                int idB = sc.nextInt();
                boolean f = false;
                for (int i = 0; i < total; i++) {
                    if (personas[i] != null && personas[i].getId() == idB && personas[i].isActivo()) {
                        System.out.println(personas[i].getNombre() + " Promedio " + personas[i].getPromedio());
                        f = true;
                    }
                }
                if (!f) System.out.println("No encontrado");
            } else if (opcion == 3) {
                System.out.println("ID para actualizar");
                int idA = sc.nextInt();
                boolean ok = false;
                for (int i = 0; i < total; i++) {
                    if (personas[i] != null && personas[i].getId() == idA && personas[i].isActivo()) {
                        System.out.println("Nuevo promedio");
                        double nP = sc.nextDouble();
                        if (nP >= 0 && nP <= 10) {
                            personas[i].setPromedio(nP);
                            ok = true;
                        }
                    }
                }
                if (!ok) System.out.println("No se pudo actualizar");
            } else if (opcion == 4) {
                System.out.println("ID para baja");
                int idBj = sc.nextInt();
                for (int i = 0; i < total; i++) {
                    if (personas[i] != null && personas[i].getId() == idBj) personas[i].setActivo(false);
                }
            } else if (opcion == 5) {
                for (int i = 0; i < total; i++) {
                    if (personas[i] != null && personas[i].isActivo()) {
                        System.out.println(personas[i].getId() + " " + personas[i].getNombre() + " " + personas[i].getPromedio());
                    }
                }
            } else if (opcion == 6) {
                double suma = 0;
                int activos = 0;
                int excelentes = 0;
                Persona mayor = null;
                Persona menor = null;

                for (int i = 0; i < total; i++) {
                    if (personas[i] != null && personas[i].isActivo()) {
                        suma += personas[i].getPromedio();
                        activos++;
                        if (personas[i].getPromedio() >= 8.0) excelentes++;

                        if (mayor == null || personas[i].getPromedio() > mayor.getPromedio()) mayor = personas[i];
                        if (menor == null || personas[i].getPromedio() < menor.getPromedio()) menor = personas[i];
                    }
                }

                if (activos > 0) {
                    System.out.println("Promedio general " + (suma / activos));
                    System.out.println("Mayor " + mayor.getNombre() + " con " + mayor.getPromedio());
                    System.out.println("Menor " + menor.getNombre() + " con " + menor.getPromedio());
                    System.out.println("Personas con 8 o mas " + excelentes);
                } else {
                    System.out.println("No hay personas activas");
                }
            } else if (opcion != 0) {
                System.out.println("Opcion invalida");
            }
        }
    }
}