package psp.ud03.ejemplos.echo.servidor;

import psp.ud03.ejemplos.echo.Conexion;

public class ServidorEchoApp {
  
  private static final int DEFAULT_PORT = 1234;

  public static void main(String[] args) {
    // Si se pasa el puerto, lo toma, si no toma el puerto por defecto
    String portString = (args.length > 0) ? args[0] : Integer.toString(DEFAULT_PORT);
    // Se intenta convertir el puerto a entero. Si no se puede se termina con error
    try {
      int port = Integer.parseInt(portString);
      // Creamos el servidor con el puerto
      Servidor servidor = new Servidor(port);

      // Esperamos conexiones una detrás de otra (Si se produce un error, se termina)
      Conexion conexion = null;
      while ((conexion = servidor.esperarConexion()) != null) {
        // Creamos un hilo para procesar los mensajes de la nueva conexion
        ServidorWorker worker = new ServidorWorker(conexion);
        worker.start();
      }
    } catch (NumberFormatException e) {
      System.err.println("El puerto proporcionado no es válido");
      return;
    }
      
  }

}
