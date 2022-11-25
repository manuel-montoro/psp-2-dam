package psp.ud03.ejemplos.echo.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

  // Socket que va a utilizar el cliente para la conexion
  Socket socket = null;
  
  public Cliente(String host, int port) {
    // Creamos y conectamos el socket (no se almacenan los parametros)
    try {
      // Se intenta crear (y conectar)
      socket = new Socket(host, port);
    } catch (Exception e) {
      // Si no se puede conectar, lanzamos una excepcion
      throw new ClienteException(e);
    }
  }

  public void enviar(String mensaje) {
    // Si el socket está conectado
    if (socket.isConnected()) {
      // Intenta enviar el mensaje
      PrintWriter writer;
      try {
        // Usamos un writer porque vamos a enviar y recibir texto.
        // Para enviar o recibir datos binarios (ficheros, por ejemplo) hay que usar directamente el stream
        writer = new PrintWriter(socket.getOutputStream());
        // Imprimimos (enviamos por el socket) el mensaje
        writer.println(mensaje);
        // Hacemos esto para que el mensaje se envíe inmediatamente
        // Hay un buffer por cada socket y no se envían datos hasta que está lleno
        // o se fuerce usando flush()
        writer.flush();
      } catch (IOException e) {
        // En caso de cualquier error de comunicaciones
        // Lanzamos una excepción hacia arriba
        throw new ClienteException(e);
      }
    } else {
      // Si el socket no está conectado, lanzamos una excepción
      throw new ClienteException("Socket no conectado");
    }
  }

  public String recibir() {
    // Si el socket está conectado
    if (socket.isConnected()) {
      // Intenta leer del socket (vamos a usar un Reader porque usamos texto)
      // Si se recibieran datos binarios habría que usar directamente el stream
      try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // Leemos el resultado y cerramos el scanner (no la conexion)
        String resultado = reader.readLine();
        reader.close();
        // Devolvemos el mensaje enviado por el servidor
        return resultado;
      } catch (Exception e) {
        // Si hay algún error con la conexión lanzamos nuestra excepcion
        throw new ClienteException(e);
      }
    } else {
      // Si el socket no está conectado lanza una excepcion
      throw new ClienteException("Socket no conectado");
    }
    
  }

  public void cerrar() {
    // Lo intenta cerrar. Si no se pueda no pasa nada
    try {
      socket.close();
    } catch (IOException e) {}
  }
  
 
  
}
