import java.util.Map;

public class ContactValidator {
    public static boolean isContactValid(String number, String name, Map<String, String> contacts) {
        // Verificar si el número de contacto ya existe en la agenda
        if (contacts.containsKey(number)) {
            System.out.println("El contacto con el número " + number + " ya existe en la agenda.");
            return false;
        }
        return true;
    }
}

