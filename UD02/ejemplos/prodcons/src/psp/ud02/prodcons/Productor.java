package psp.ud02.prodcons;

/**
 * Productor. Genera números y los almacena en el buffer
 * @author mmontoro
 *
 */
public class Productor extends Thread {

  // Tiempo mínimo y maximo para dormir
  private static final long DORMIR_MIN = 1000;
  private static final long DORMIR_MAX = 5000;
  // Valor mínimo y máximo del rango del que se extraen los números al azar
  private static final int GENERADOR_MIN = 1;
  private static final int GENERADOR_MAX = 5000;
  
  // Número del productor
  int numero;
  // Buffer a usar para almacenar los números
  Buffer buffer;
  
  /**
   * Constructor
   * @param numero. Número del productor
   * @param buffer. Buffer en el que almacenar los números que se van generando
   */
  public Productor(int numero, Buffer buffer) {
    this.numero = numero;
    this.buffer = buffer;
  }

  /**
   * Punto de entrada del hilo del productor
   */
  @Override
  public void run() {
    // Indica que se ha iniciado
    mensaje ("Iniciado");
    // Indefinidamente realiza las siguientes operaciones
    while (true) {
      mensaje("Durmiendo");
      // Duerme un tiempo aleatorio
      try {
        this.sleep((long)(Math.random() * (DORMIR_MAX - DORMIR_MIN + 1) + DORMIR_MIN));
      } catch (InterruptedException e) { }
      // Genera un número al azar
      int valor = (int)(Math.random() * (GENERADOR_MAX - GENERADOR_MIN + 1) + GENERADOR_MIN);
      mensaje("Insertando nuevo valor " + valor);
      // Y lo añade en el buffer
      buffer.add(valor);
      mensaje("Valor insertado");
    }
  }

  /**
   * Muestra un mensaje correspondiente al productor por consola. Añade un
   * prefijo identificando al productor
   * @param mensaje. Mensaje a mostrar
   */
  private void mensaje(String mensaje) {
    // Emite el mensaje con el prefijo correspondiente al productor
    System.out.println("Productor " + numero + ": " + mensaje);
  }
  
  
}
