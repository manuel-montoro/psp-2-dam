
public class HiloThread extends Thread{

  private int idHilo;
  
  public HiloThread(int idHilo) {
    this.idHilo = idHilo;
  }

  @Override
  public void run() {
    System.out.println("Hola, soy el hilo " + idHilo);
  }
  
  public static void main(String[] args) {
    
    HiloThread hilo1 = new HiloThread(1);
    HiloThread hilo2 = new HiloThread(2);
    
    hilo1.start();
    hilo2.start();
  }
  
}
