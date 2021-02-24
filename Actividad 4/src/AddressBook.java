
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {
    private HashMap<String, String> contactos;

    public HashMap<String, String> getContactos() {return contactos;}
    public void setContactos(HashMap<String, String> contactos) {this.contactos = contactos;}

    public AddressBook(){
        contactos = new HashMap<String, String>();
    }

    //Metodo que lee un archivo de texto y carga los contactos, recibe la ruta del archivo
    public void load(String pArchivo) throws IOException {
        //String vArchivo = "C:\\Users\\V-MAL\\IdeaProjects\\Actividad 4\\Contactos.txt";
        String vLinea;
        String[] vContacto;

        FileReader file = new FileReader(pArchivo);
        BufferedReader buffer = new BufferedReader(file);
        while ((vLinea = buffer.readLine())!= null){
            vContacto = vLinea.split(",");
            contactos.put(vContacto[0],vContacto[1]);

        }
        buffer.close();
        System.out.println("Se cargo el archivo...");
    }

    //Metodo que escribe en un archivo los contactos, recibe la ruta donde estara el archivo
    public void save(String pArchivo) throws IOException{
        File file=new File(pArchivo);
        if(file.exists()){
            file.delete();
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for(Map.Entry me :contactos.entrySet()){
            bw.write(me.getKey() + ","+ me.getValue()+"\n");
        }
        bw.flush();
    }

    //Imprime en pantalla todos los contactos
    public void list(){
        int y = 1;
        System.out.println("Lista de contactos:");
        for(Map.Entry me :contactos.entrySet()){
            System.out.println(y + ".- " + me.getKey() + " : " + me.getValue());
            y++;
        }
    }

    //Agrega un nuevo contacto
    public void create(String pNumero, String pNombre){
        contactos.put(pNumero, pNombre);
        System.out.println("El contacto: " + pNombre + " con numero: " + pNumero + ". \nHa sido Agregado...");
    }

    //Elimina un contacto
    public void delete(String pNumero){
        String contacto;
        contacto = contactos.get(pNumero);
        if(contacto != null){
        contactos.remove(pNumero);
            System.out.println("El contacto: " + contacto + " con numero: " + pNumero + ". \nHa sido Eliminado...");
        }else{
            System.out.println("El contacto no existe.");
        }

    }
}

