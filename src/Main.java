import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook("contacts.csv");
        Scanner scanner = new Scanner(System.in);

        addressBook.load();

        while (true) {
            System.out.println("\nMenú de la Agenda Telefónica:");
            System.out.println("1. Listar contactos");
            System.out.println("2. Crear contacto");
            System.out.println("3. Borrar contacto");
            System.out.println("4. Guardar cambios");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea en blanco

            switch (choice) {
                case 1:
                    addressBook.list();
                    break;
                case 2:
                    System.out.print("Ingrese el número del contacto: ");
                    String newNumber = scanner.nextLine();
                    System.out.print("Ingrese el nombre del contacto: ");
                    String newName = scanner.nextLine();
                    addressBook.create(newNumber, newName);
                    break;
                case 3:
                    System.out.print("Ingrese el número del contacto a borrar: ");
                    String deleteNumber = scanner.nextLine();
                    addressBook.delete(deleteNumber);
                    break;
                case 4:
                    addressBook.save();
                    break;
                case 5:
                    System.out.println("Saliendo de la aplicación.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
