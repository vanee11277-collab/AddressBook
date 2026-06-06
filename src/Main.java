import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AddressBook agenda = new AddressBook();
        agenda.load();

        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Listar");
            System.out.println("2. Crear");
            System.out.println("3. Eliminar");
            System.out.println("4. Guardar y salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agenda.list();
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Número: ");
                    String numero = sc.nextLine();
                    agenda.create(numero, nombre);
                    break;
                case 3:
                    System.out.print("Número a eliminar: ");
                    String num = sc.nextLine();
                    agenda.delete(num);
                    break;
                case 4:
                    agenda.save();
                    System.out.println("Guardado");
                    break;
            }

        } while (opcion != 4);

        sc.close();
    }
}