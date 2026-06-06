import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {

    private HashMap<String, String> contactos;
    private final String archivo = "db/contactos.txt";

    public AddressBook() {
        contactos = new HashMap<>();
    }

    public void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    contactos.put(partes[0], partes[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo.");
        }
    }

    public void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Map.Entry<String, String> entry : contactos.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar.");
        }
    }

    public void list() {
        System.out.println("\nContactos:");
        for (Map.Entry<String, String> entry : contactos.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void create(String numero, String nombre) {
        contactos.put(numero, nombre);
        System.out.println("Contacto agregado.");
    }
    public void delete(String numero) {

    }
}

