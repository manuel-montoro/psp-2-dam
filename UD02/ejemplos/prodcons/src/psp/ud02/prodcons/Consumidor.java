package psp.ud02.prodcons;

/**
 * Consumidor. Consume números de un buffer
 * @author mmontoro
 *
 */
public class Consumidor extends Thread{
  // Tiempo mínimo y máximo que se duerme
  private static final long DORMIR_MIN = 1000;
  private static final long DORMIR_MAX = 5000;

  // Número del consumidor
  int numero;
  // Buffer donde se lee
  Buffer buffer;

  public Consumidor(int numero, Buffer buffer) {
    this.numero = numero;
    this.buffer = buffer;
  }

  /**
   * Punto de entrada del hilo
   */
  @Override
  public void run() {
    mensaje ("Iniciado");
    // Ciclo infinito
    while (true) {
      mensaje("Durmiendo");
      // Duerme un tiempo aleatorio
      try {
        this.sleep((long)(Math.random() * (DORMIR_MAX - DORMIR_MIN + 1) + DORMIR_MIN));
      } catch (InterruptedException e) { }
      mensaje("Leyendo nuevo valor del buffer");
      // Obtiene un valor del buffer
      int valor = buffer.get();
      // Lo muestra por pantalla
      mensaje("Valor leido: " + valor);
    }
  }
  
  /**
   * Genera un mensaje por consola añadiendo el prefijo del consumidor
   * @param mensaje. Mensaje a mostrar
   */
  private void mensaje(String mensaje) {
    System.out.println("Consumidor " + numero + ": " + mensaje);
  }

}
