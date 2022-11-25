package psp.ud03.ejemplos.echo.servidor;

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
      while (servidor.esperarConexion()) {
        // Mientras haya mensajes
        String peticion = null;
        do {
          peticion = servidor.recibir();
          // Si se pudo recibir (si la conexión no se ha cerrado)
          if (peticion != null) {
            // Lo convertimos a mayúsculas
            String respuesta = peticion.toUpperCase();
            // Y lo enviamos como respuesta
            servidor.enviar(respuesta);
          }
        } while (peticion != null);
      }
    } catch (NumberFormatException e) {
      System.err.println("El puerto proporcionado no es válido");
      return;
    }
      
  }

}
