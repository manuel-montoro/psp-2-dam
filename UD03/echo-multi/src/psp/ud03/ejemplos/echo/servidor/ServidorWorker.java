package psp.ud03.ejemplos.echo.servidor;

import psp.ud03.ejemplos.echo.Conexion;

public class ServidorWorker extends Thread {

  private Conexion conexion;
  
  public ServidorWorker(Conexion conexion) {
    this.conexion = conexion;
  }
  
  @Override
  public void run() {
    // Mientras haya mensajes
    String peticion = null;
    do {
      peticion = conexion.recibir();
      // Si se pudo recibir (si la conexión no se ha cerrado)
      if (peticion != null) {
        // Lo convertimos a mayúsculas
        String respuesta = peticion.toUpperCase();
        // Y lo enviamos como respuesta
        conexion.enviar(respuesta);
      }
    } while (peticion != null);
  }
}
