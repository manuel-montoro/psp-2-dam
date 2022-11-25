package psp.ud03.ejemplos.echo.cliente;

public class ClienteException extends RuntimeException {
  
  public ClienteException(Exception e) {
    super(e);
  }
  
  public ClienteException(String msg) {
    super(msg);
  }

}
