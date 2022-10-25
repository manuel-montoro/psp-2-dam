import java.util.Scanner;

public class MainApp {
  
  public static int MAXHILOS = 5;
  
  public static void main(String[] args) {
    
    Hilo[] hilos = new Hilo[MAXHILOS];
    Contador contador = new Contador(0);
    for (int i = 0; i < hilos.length; i++) {
      hilos[i] = new Hilo(contador);
      hilos[i].start();
    }
    
    for (int i = 0; i < hilos.length; i++) {
      try {
        hilos[i].join();
      } catch (InterruptedException e) {}
    }
    
    System.out.println("Contador llegó hasta " + contador.getValor());
  }
}
