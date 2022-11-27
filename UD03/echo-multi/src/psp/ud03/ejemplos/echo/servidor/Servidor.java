package psp.ud03.ejemplos.echo.servidor;

import java.net.ServerSocket;
import psp.ud03.ejemplos.echo.ConexionSocket;
import psp.ud03.ejemplos.echo.Conexion;
import psp.ud03.ejemplos.echo.ConexionException;

public class Servidor{

  private ServerSocket serverSocket;
  
  public Servidor(int port) {
    try {
      serverSocket = new ServerSocket(port);
    } catch (Exception e) {
      throw new ConexionException(e);
    }
  }

  public Conexion esperarConexion() {
    // Intentamos aceptar una conexion. Si no hay ninguna en cola espera
    try {
      return new ConexionSocket(serverSocket.accept());
    } catch (Exception e) {
      // Error. Devolvemos no ok
      return null;
    }
  }
}
