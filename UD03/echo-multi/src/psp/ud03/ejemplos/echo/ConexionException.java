package psp.ud03.ejemplos.echo;

public class ConexionException extends RuntimeException {
  public ConexionException(Exception e) {
    super(e);
  }
  
  public ConexionException(String msg) {
    super(msg);
  }
}
