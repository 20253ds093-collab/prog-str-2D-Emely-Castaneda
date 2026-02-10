import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona[] personas = new Persona[20];
        int total = 0;
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("1 Alta");
            System.out.println("2 Buscar por ID");
            System.out.println("3 Baja logica");
            System.out.println("4 Listar activas");
            System.out.println("5 Actualizar nombre");
            System.out.println("0 Salir");

            if (!sc.hasNextInt()) {
                System.out.println("Opcion invalida");
                sc.next();
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                if (total < 20) {
                    System.out.println("Ingrese ID");
                    int idInput = sc.nextInt();
                    sc.nextLine();

                    boolean repetido = false;
                    for (int i = 0; i < total; i++) {
                        if (personas[i] != null && personas[i].getId() == idInput) {
                            repetido = true;
                        }
                    }

                    if (idInput > 0 && !repetido) {
                        System.out.println("Ingrese nombre");
                        String nomInput = sc.nextLine();
                        if (!nomInput.trim().isEmpty()) {
                            personas[total] = new Persona(idInput, nomInput);
                            total++;
                        } else {
                            System.out.println("Nombre vacio");
                        }
                    } else {
                        System.out.println("ID invalido o repetido");
                    }
                }
            } else if (opcion == 2) {
                System.out.println("ID a buscar");
                int idB = sc.nextInt();
                boolean encontrado = false;
                for (int i = 0; i < total; i++) {
                    if (personas[i] != null && personas[i].getId() == idB && personas[i].isActiva()) {
                        System.out.println("Nombre " + personas[i].getNombre());
                        encontrado = true;
                    }
                }
                if (!encontrado) System.out.println("No encontrada o inactiva");
            } else if (opcion == 3) {
                System.out.println("ID para baja");
                int idBaja = sc.nextInt();
                for (int i = 0; i < total; i++) {
                    if (personas[i] != null && personas[i].getId() == idBaja) {
                        personas[i].setActiva(false);
                    }
                }
            } else if (opcion == 4) {
                for (int i = 0; i < total; i++) {
                    if (personas[i] != null && personas[i].isActiva()) {
                        System.out.println(personas[i].getId() + " " + personas[i].getNombre());
                    }
                }
            } else if (opcion == 5) {
                System.out.println("ID para actualizar");
                int idAct = sc.nextInt();
                sc.nextLine();
                boolean exito = false;
                for (int i = 0; i < total; i++) {
                    if (personas[i] != null && personas[i].getId() == idAct && personas[i].isActiva()) {
                        System.out.println("Nuevo nombre");
                        String nvoNom = sc.nextLine();
                        if (!nvoNom.trim().isEmpty()) {
                            personas[i].setNombre(nvoNom);
                            exito = true;
                        }
                    }
                }
                if (!exito) System.out.println("No encontrada o inactiva");
            } else if (opcion != 0) {
                System.out.println("Opcion invalida");
            }
        }
    }
}