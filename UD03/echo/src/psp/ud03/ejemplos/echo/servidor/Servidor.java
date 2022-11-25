package psp.ud03.ejemplos.echo.servidor;

import java.net.ServerSocket;
import psp.ud03.ejemplos.echo.Conexion;
import psp.ud03.ejemplos.echo.ConexionException;

public class Servidor{

  private ServerSocket serverSocket;
  private Conexion conexion;
  
  public Servidor(int port) {
    try {
      serverSocket = new ServerSocket(port);
    } catch (Exception e) {
      throw new ConexionException(e);
    }
  }

  public boolean esperarConexion() {
    // Intentamos aceptar una conexion. Si no hay ninguna en cola espera
    try {
      conexion = new Conexion(serverSocket.accept());
      // Conectados. Devuelve OK
      return true;
    } catch (Exception e) {
      // Error. Devolvemos no ok
      return false;
    }
  }

  public void enviar(String msg) {
    conexion.enviar(msg);
  }
  
  public String recibir() {
    return conexion.recibir();
  }

}
