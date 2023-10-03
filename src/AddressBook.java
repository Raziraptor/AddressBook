import java.io.*;
import java.util.*;

public class AddressBook {
    private Map<String, String> contacts;
    private String filePath;

    public AddressBook(String filePath) {
        this.contacts = new HashMap<>();
        this.filePath = "C:\\Users\\razpi\\IdeaProjects\\AddressBook\\src\\contacts.csv";
    }

    // Cargar contactos desde un archivo CSV

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    contacts.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar los contactos desde el archivo.");
        }
    }

    // Guardar contactos en un archivo CSV
    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al guardar los contactos en el archivo.");
        }
    }


    // Mostrar la lista de contactos
    public void list() {
        System.out.println("Contactos:");
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            String number = entry.getKey();
            String name = entry.getValue();
            System.out.println(number + " : " + name);
        }
    }

    // Crear un nuevo contacto
    public void create(String number, String name) {
        if (ContactValidator.isContactValid(number, name, contacts)) {
            contacts.put(number, name);
            System.out.println("Contacto creado con éxito.");
        }
    }


    // Borrar un contacto
    public void delete(String number) {
        if (contacts.containsKey(number)) {
            contacts.remove(number);
            System.out.println("Contacto eliminado con éxito.");
        } else {
            System.out.println("No se encontró el contacto con el número " + number);
        }
    }
}
