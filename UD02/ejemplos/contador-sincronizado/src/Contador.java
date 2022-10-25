
public class Contador {

  private long valor;
  
  public Contador(long valorInicial) {
    this.valor = valorInicial;
  }
  
  public long getValor() {
    return valor;
  }
  
  public synchronized void incrementa() {
    this.valor++;
  }
}
