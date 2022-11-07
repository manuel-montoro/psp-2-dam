
public class HiloRunnable implements Runnable{

  private int idHilo;
  
  public HiloRunnable(int idHilo) {
    this.idHilo = idHilo;
  }

  @Override
  public void run() {
    System.out.println("Hola, soy el hilo " + Thread.currentThread().getName());
  }
  
  public static void main(String[] args) {
    
    Thread hilo1 = new Thread(new HiloRunnable(1));
    hilo1.setName("Hilo 1");
    Thread hilo2 = new Thread(new HiloRunnable(2));
    hilo2.setName("Otro hilo");
    
    hilo1.start();
    hilo2.start();
  }
  

}
