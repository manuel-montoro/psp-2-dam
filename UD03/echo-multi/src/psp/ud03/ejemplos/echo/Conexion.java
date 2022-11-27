package psp.ud03.ejemplos.echo;

public interface Conexion {
  public void enviar(String mensaje);
  public String recibir();
  public void cerrar();

}
