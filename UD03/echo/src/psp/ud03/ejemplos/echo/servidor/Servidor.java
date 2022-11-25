package psp.ud03.ejemplos.echo.servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import psp.ud03.ejemplos.echo.cliente.ClienteException;

public class Servidor {

  private ServerSocket serverSocket;
  private Socket clientSocket;
  
  public Servidor(int port) {
    try {
      clientSocket = null;
      serverSocket = new ServerSocket(port);
    } catch (Exception e) {
      throw new ServidorException(e);
    }
  }

  public boolean esperarConexion() {
    // Intentamos aceptar una conexion. Si no hay ninguna en cola espera
    try {
      clientSocket = serverSocket.accept();
      // Conectados. Devuelve OK
      return true;
    } catch (Exception e) {
      // Error. Devolvemos no ok
      return false;
    }
  }

  public String recibir() {
    // Si el socket está conectado
    if (clientSocket.isConnected()) {
      // Intenta leer del socket (vamos a usar un scanner porque recibimos texto)
      // Si se recibieran datos binarios habría que usar directamente el stream
      Scanner sc;
      try {
        sc = new Scanner(clientSocket.getInputStream());
        // Leemos el resultado y cerramos el scanner (no la conexion)
        String resultado = sc.nextLine();
        sc.close();
        // Devolvemos el mensaje enviado por el servidor
        return resultado;
      } catch (Exception e) {
        // Si hay algún error con la conexión lanzamos nuestra excepcion
        throw new ServidorException(e);
      }
    } else {
      // Si el socket no está conectado lanza una excepcion
      throw new ServidorException("Socket no conectado");
    }
  }

  public void enviar(String mensaje) {
    // Si el socket está conectado
    if (clientSocket.isConnected()) {
      // Intenta enviar el mensaje
      PrintWriter writer;
      try {
        // Usamos un writer porque vamos a enviar y recibir texto.
        // Para enviar o recibir datos binarios (ficheros, por ejemplo) hay que usar directamente el stream
        writer = new PrintWriter(clientSocket.getOutputStream());
        // Imprimimos (enviamos por el socket) el mensaje
        writer.println(mensaje);
        // Hacemos esto para que el mensaje se envíe inmediatamente
        // Hay un buffer por cada socket y no se envían datos hasta que está lleno
        // o se fuerce usando flush()
        writer.flush();
      } catch (IOException e) {
        // En caso de cualquier error de comunicaciones
        // Lanzamos una excepción hacia arriba
        throw new ServidorException(e);
      }
    } else {
      // Si el socket no está conectado, lanzamos una excepción
      throw new ServidorException("Socket no conectado");
    }
  }
}
