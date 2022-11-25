package psp.ud03.ejemplos.echo.cliente;

import java.util.Scanner;

public class ClienteEchoApp {

  private static final String DEFAULT_HOST = "localhost";
  private static final int DEFAULT_PORT = 1234;
  
  public static void main(String[] args) {
    
    // Si se ha pasado la direccion del servidor la toma, si no usa la direccion por defecto
    String host = (args.length > 0) ? args[0] : DEFAULT_HOST;
    // Igual con el puerto
    String portString = (args.length > 1) ? args[1] : Integer.toString(DEFAULT_PORT);
    // Se intenta convertir el puerto a entero. Si no se puede se termina con error
    try {
      int port = Integer.parseInt(portString);
      
      // Creamos el cliente con la direccion y el puerto
      Cliente cliente = new Cliente(host, port);
      
      // Mientras no se introduzca la cadena vacía
      String mensaje;
      Scanner sc = new Scanner(System.in);
      do {
        // Lee el mensaje
        mensaje = sc.nextLine();
        // Lo envía
        cliente.enviar(mensaje);
        // Recibe la respuesta
        String respuesta = cliente.recibir();
        // Y la imprime
        System.out.println("Respuesta recibida: " + respuesta);
      } while (mensaje.length() > 0);
      // Terminamos el cliente (la conexion)
      cliente.cerrar();
      System.out.println("Terminando...");
    } catch (NumberFormatException e) {
      System.err.println("El puerto proporcionado no es válido. Terminando.");
      return;
    } catch (ClienteException e) {
      System.err.println("Error en la conexión.");
      System.err.println("Excepcion original:");
      e.printStackTrace(System.err);
    }
  }

}
