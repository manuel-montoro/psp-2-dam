package psp.ud02.prodcons;

/**
 * Aplicación Productores y consumidores
 * @author mmontoro
 *
 */
public class ProdConsApp {

  // Tamaño del buffer
  private static final int BUFFER_SIZE = 10;
  // Número de productores
  private static final int NUM_PRODS = 10;
  // Numero de consumidores
  private static final int NUM_CONS = 2;
  
  public static void main(String[] args) {
    
    // Crea el buffer
    Buffer buffer = new Buffer(BUFFER_SIZE);
    
    // Crea los productores y consumidores y les da curso
    for (int i = 0; i < NUM_PRODS; i++) {
      Productor productor = new Productor(i, buffer);
      productor.start();
    }
    for (int i = 0; i < NUM_CONS; i++) {
      Consumidor consumidor = new Consumidor(i, buffer);
      consumidor.start();
    }
  }
}
