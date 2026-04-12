import java.util.Scanner;
//Daniel Alexander Pareja Montero
//Daniel-Alexander19

public class Ejemplo1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Cuántos estudiantes desea ingresar?: ");
        int cantidadEstudiante = scanner.nextInt();

        String[] tipoDocumento = new String[cantidadEstudiante];
        Integer[] documento = new Integer[cantidadEstudiante];
        String[] nombre = new String[cantidadEstudiante];
        String[] correo = new String[cantidadEstudiante];
        String[] tipoDcumentoPermitodo = {"CC", "CE", "TI", "PA", "DNI", "RUT", "NIT"};

        int i = 0;
        int j = 0;

        for(i=0; i<tipoDocumento.length; i++){

            System.out.print("Ingrese el tipo de documento del estudiante " + (i+1)+ ": ");
            for(j=0; j<tipoDcumentoPermitodo.length; j++){
                System.out.print("("+(j+1)+"=>" + tipoDcumentoPermitodo[j]+") ");
            }
            System.out.print(": ");

            int pos = -1;

            while(pos<0 || pos>=tipoDcumentoPermitodo.length){
                try{
                    pos = scanner.nextInt();
                    pos--;

                    if (pos < 0 || pos >= tipoDcumentoPermitodo.length) {
                        System.out.print("Error en el dato ingresado. Por favor, ingrese un número entre 1 y " + tipoDcumentoPermitodo.length+", ingresar de nuevo el dato: ");
                    }else{
                        tipoDocumento[i] = tipoDcumentoPermitodo[pos];
                    }

                }catch(Exception e){
                    System.out.print("Error, tipo de documento invalido: ");
                    scanner.next();
                    pos = -1;
                }
            }

            // Pedir el numero de documento al usuario y mandandole a error si introduce un tipo de caracter invalido
            System.out.print("Ingrese el número de documento del estudiante " + (i+1) + ": ");
            boolean valido = false;

            while(!valido){
                try{
                    documento[i] = scanner.nextInt();
                    valido = true;
                }catch(Exception e){
                    System.out.print("Error, número de documento invalido: ");
                    scanner.next();
                }
            }

            scanner.nextLine();

            // Pedir el nombre del estudiante
            System.out.print("Ingrese el nombre completo del estudiante " + (i+1) + ": ");
            boolean nombreValido = false;

            while(!nombreValido){
                String entrada = scanner.nextLine();

                if(entrada.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
                    nombre[i] = entrada;
                    nombreValido = true;
                }else{
                    System.out.print("Error, nombre del estudiante invalido: ");
                }
            }

            // Solicitar al usuario el correo del estudiante
            System.out.print("Ingrese el correo del estudiante " + (i+1) + ": ");
            boolean correoValido = false;

            while(!correoValido){
                String entradaCorreo = scanner.nextLine();

                if(entradaCorreo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")){
                    correo[i] = entradaCorreo;
                    correoValido = true;
                }else{
                    System.out.print("Error, correo del estudiante invalido: ");
                }
            }

            System.out.println("Estudiante guardado correctamente");
        }

        // Monstrar los datos de todos los estudiantes
        System.out.println("\n===== LISTA DE ESTUDIANTES =====");

        for(i=0; i<tipoDocumento.length; i++){
            System.out.println("Estudiante " + (i+1) + ":");
            System.out.println("Tipo Documento: " + tipoDocumento[i]);
            System.out.println("Número Documento: " + documento[i]);
            System.out.println("Nombre: " + nombre[i]);
            System.out.println("Correo: " + correo[i]);
            System.out.println("-----------------------------");
        }
    }
}