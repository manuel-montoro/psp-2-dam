
public class Hilo extends Thread {

  private final long MAXVALOR = 1000;
  
  private Contador contador;
  
  public Hilo(Contador c) {
    this.contador = c;
  }

  @Override
  public void run() {
    
    for (long i = 0; i < MAXVALOR; i++) {
      contador.incrementa();
    }
  }

  
}
