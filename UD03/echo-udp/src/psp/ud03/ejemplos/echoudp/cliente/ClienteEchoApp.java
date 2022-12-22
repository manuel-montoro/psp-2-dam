package psp.ud03.ejemplos.echoudp.cliente;

import java.util.Scanner;
import psp.ud03.ejemplos.echoudp.ConexionException;
import psp.ud03.ejemplos.echoudp.Endpoint;
import psp.ud03.ejemplos.echoudp.Mensaje;

public class ClienteEchoApp {

  private static final int MY_DEFAULT_PORT = 1235;
  private static final String DEFAULT_OTHER_HOST = "localhost";
  private static final int DEFAULT_OTHER_PORT = 1234;
  
  public static void main(String[] args) {
    
    // Si se ha pasado la direccion del servidor la toma, si no usa la direccion por defecto
    String host = (args.length > 0) ? args[0] : DEFAULT_OTHER_HOST;
    // Igual con el puerto
    String portString = (args.length > 1) ? args[1] : Integer.toString(DEFAULT_OTHER_PORT);
    // Y el puerto propio
    String myPortString = (args.length > 2) ? args[2] : Integer.toString(MY_DEFAULT_PORT);
    
    // Se intentan convertir los puertos a entero. Si no se puede se termina con error
    try {
      int port = Integer.parseInt(portString);
      int myPort = Integer.parseInt(myPortString);
      
      // Creamos el endpoint con nuestro puerto
      Endpoint cliente = new Endpoint(myPort);
      
      // Mientras no se introduzca la cadena vacía
      String mensajeContent;
      Scanner sc = new Scanner(System.in);
      do {
        // Lee el mensaje desde teclado
        System.out.print("Introduzca el mensaje a enviar (vacio para acabar): ");
        mensajeContent = sc.nextLine();
        // Si no es el mensaje de fin
        if (mensajeContent.length() > 0) {
          // Crea el mensaje
          Mensaje mensaje = new Mensaje(host, port, mensajeContent);
          // Lo envía
          cliente.enviar(mensaje);
          // Recibe la respuesta
          Mensaje respuesta = cliente.recibir();
          // Y la imprime
          System.out.println("Respuesta recibida: " + respuesta.getContent());
        }
      } while (mensajeContent.length() > 0);
      // Terminamos el cliente (la conexion)
      cliente.cerrar();
      System.out.println("Terminando...");
    } catch (NumberFormatException e) {
      System.err.println("El puerto proporcionado no es válido. Terminando.");
      return;
    } catch (ConexionException e) {
      System.err.println("Error en la conexión.");
      System.err.println("Excepcion original:");
      e.printStackTrace(System.err);
    }
  }

}
