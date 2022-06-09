import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.nio.file.Files;
import  java.nio.file.Path;


public class main {
    // Creamos el separador
    public static final String SEPARADOR = ",";
    //Formato de fecha
    public static SimpleDateFormat fecha = new SimpleDateFormat("yyyy.MM");

    // Lista donde almacenaremos todo lo del fichero
    public static ArrayList <electronicCard> lista = new ArrayList<>();

    // Creamos funcion leer fichero
    public static void LeerFicherocsv() {
        System.out.println("Hola mundo");

        int contador = 0; // Para saltar la primera linea del fichero.

        // Leer fichero csv --> buscar
        BufferedReader bufferLectura = null;
        try{
            // Abrimos el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new FileReader("src/electronic_card_transactions.csv"));

            // Leemos linea a linea el fichero
            String linea = bufferLectura.readLine();

            while(linea!= null){
                if(contador!= 0) {

                    // Separamos la linea leida con el separador definido previamente
                    String[] campos = linea.split(SEPARADOR);
                    // Nos creamos un nuevo objeto que se sobreescribira y se añadira a la lista
                    electronicCard EC = new electronicCard();

                    EC.setSeries_reference(campos[0]);
                    EC.setPeriod(fecha.parse(campos[1]));
                    // Añadimos un try_catch que filtre los valores vacios.
                    try{
                        EC.setData_value(Float.parseFloat(campos[2]));
                    }catch (Exception e1){
                        // En el caso de que encuentre un campo vacio, insertara un 0 en su lugar.
                        EC.setData_value(0);
                    }
                    // Cogemos solo la primera posicion del string de esa posicion del array.
                    EC.setStatus(campos[4].charAt(0));
                    EC.setUnits(campos[5]);
                    EC.setSubject(campos[7]);
                    EC.setGroup(campos[8]);
                    EC.setSeries_title1(campos[9]);
                    EC.setSeries_title2(campos[10]);
                    // System.out.println(Arrays.toString(campos));
                    // Añadimos el objeto al array list
                    lista.add(EC);
                }
                contador++;
                //Volvemos a leer otra linea del fichero
                linea = bufferLectura.readLine();
            }
        }catch (IOException | ParseException e){
            e.printStackTrace();
        }
        finally {
            //Cerramos el buffer de lectura
            if (bufferLectura != null){
                try{
                    bufferLectura.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }


        // Por cada linea creamos un objeto nuevo y lo añadimos a la lista


    }

    // Funcion que se encarga de convertir un tipo String a tipo Date
    public static Date ParseFecha(String fechaS){
        Date fechaDate = null;
        try{
            fechaDate = fecha.parse(fechaS);

        }catch (ParseException ex){
            System.out.println(ex);
        }
        return fechaDate;
    }

    // Buscar y sumar importes
    public static float BuscaYSuma (Date fecha2){
        float valor = 0;
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).period.equals( fecha2)){
                valor = valor + lista.get(i).data_value;
            }
        }
        return valor;
    }

    // Buscamos entradas con un importe entre 1000 y 10000
    public static void buscarImporte(){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).data_value>1000 && lista.get(i).data_value<10000){
                System.out.println("Series_reference: " + lista.get(i).series_reference + " / Period: " + lista.get(i).period + "/ Data_value: " + lista.get(i).data_value + "\n");
            }
        }
    }

    // Escribimos un fichero con lo que nos pide
    public static void escribircsv () throws IOException {


        File ficherosalida = new File("ficherosalida.csv");
        FileWriter sb = new FileWriter("ficherosalida.csv");

        for (int i = 0; i < lista.size(); i++){
            if(lista.get(i).getSeries_title2().equals("Credit")){
                sb.write(String.valueOf(lista.get(i).getData_value())+"\n");

            }
        }

        sb.close();
    }

    // Creamos el menu
    public static void Menu() throws IOException {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("1. Opcion 1: Suma de importe de operaciones de un usuario");
            System.out.println("2. Opcion 2: Mostrar entradas con un importe entre 1000$ y 10000$");
            System.out.println("3. Opcion 3");
            System.out.println("4. Salir");

            System.out.println("Escribe una de las opciones");
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    String fecha;
                    Date fechaformato;
                    System.out.println("Indique la fecha que desea buscar 'mm/aaaa'\n");
                    Scanner lector = new Scanner(System.in);
                    fecha = lector.nextLine();
                    String mes = fecha.substring(0,2);
                    String anio = fecha.substring(3);

                    String fechafinal = anio + "."+mes;
                    fechaformato = ParseFecha(fechafinal);

                    //Buscamos el formato y lo mostramos.
                    float importe = BuscaYSuma(fechaformato);
                    System.out.println("El importe para la fecha seleccionada es: " + importe + "\n");

                    break;
                case 2:
                    System.out.println("Buscamos las entradas con importe entre 1000 - 10000");
                    buscarImporte();
                    break;
                case 3:
                    escribircsv();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion no aceptada");
            }

        }
    }
    // Se ejecuta lo que esta dentro de lo siguiente

    public static void main(String[] args) throws IOException {

        // Lectura de fichero
        LeerFicherocsv();
        Menu();

    }
}
