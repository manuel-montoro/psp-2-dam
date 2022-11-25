package psp.ud03.ejemplos.echo.servidor;

public class ServidorException extends RuntimeException {

  public ServidorException(Exception e) {
    super(e);
  }

  public ServidorException(String msg) {
    super(msg);
  }
}
