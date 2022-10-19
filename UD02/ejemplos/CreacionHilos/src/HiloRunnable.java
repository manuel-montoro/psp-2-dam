
public class HiloRunnable implements Runnable{

  private int idHilo;
  
  public HiloRunnable(int idHilo) {
    this.idHilo = idHilo;
  }

  @Override
  public void run() {
    System.out.println("Hola, soy el hilo " + idHilo);
  }
  
  public static void main(String[] args) {
    
    Thread hilo1 = new Thread(new HiloThread(1));
    Thread hilo2 = new Thread(new HiloThread(2));
    
    hilo1.start();
    hilo2.start();
  }
  

}
