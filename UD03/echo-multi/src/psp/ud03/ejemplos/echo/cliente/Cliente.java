package psp.ud03.ejemplos.echo.cliente;

import java.net.Socket;
import psp.ud03.ejemplos.echo.ConexionSocket;
import psp.ud03.ejemplos.echo.Conexion;
import psp.ud03.ejemplos.echo.ConexionException;

public class Cliente {

  private Conexion conexion;
  
  public Cliente(String host, int port) {
    // Creamos y conectamos el socket (no se almacenan los parametros)
    try {
      // Se intenta crear (y conectar)
      conexion = new ConexionSocket(new Socket(host, port));
    } catch (Exception e) {
      // Si no se puede conectar, lanzamos una excepcion
      throw new ConexionException(e);
    }
  }
  
  public void enviar(String msg) {
    conexion.enviar(msg);
  }
  
  public String recibir() {
    return conexion.recibir();
  }

  public void cerrar() {
    conexion.cerrar();
  }
  
 
  
}
