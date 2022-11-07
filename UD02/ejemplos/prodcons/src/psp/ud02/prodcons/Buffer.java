package psp.ud02.prodcons;

/**
 * Buffer sincronizado
 * @author mmontoro
 *
 */
public class Buffer {

  // Array donde se almacenan los datos en forma circular
  private int[] buffer;
  // Número actual de elementos almacenados en el buffer
  private int currentSize;
  // Número máximo de elementos que se pueden almacenar en el buffer
  private int maxSize;
  // Índice del siguiente elemento a leer
  private int readIndex;
  // Índice del siguiente elemento donde escribir
  private int writeIndex;
  
  /**
   * Inicializa el buffer
   * @param size Tamaño del buffer
   */
  public Buffer(int size) {
    // Crea el array
    buffer = new int[size];
    // Número actual de elementos (ninguno)
    currentSize = 0;
    // Número máximo (tamaño del buffer)
    maxSize = size;
    // Los índices los inicializa al elemento inicial (0)
    readIndex = 0;
    writeIndex = 0;
  }
  
  /**
   * Añade un valor al búffer. Si no hay espacio espera a que lo haya
   * @param valor. Valor a añadir
   */
  public synchronized void add(int valor) {
    
    // Si el buffer está lleno
    // Espera a que se quede espacio
    while (currentSize == maxSize) {
      try {
        wait();
      } catch (InterruptedException e) { }
    }
    
    // Cuando llega aqui hay al menos un hueco
    // Almacena el valor
    buffer[writeIndex++] = valor;
    // Y actualiza el índice
    writeIndex %= maxSize;
    // Y el tamaño actual
    currentSize++;
    
    /*
     *  Notifica algun hilo que esté esperando. Si el hilo es escritor se volverá a dormir
     *  Si el hilo es lector, podrá obtener algún valor, incluyendo el que se acaba de introducir
     */
    notify();
  }
  
  public synchronized int get() {
    // Si el buffer está vacío
    // Espera a que se inserte algo
    while (currentSize == 0) {
      try {
        wait();
      } catch (InterruptedException e) { }
    }

    // Cuando llega aqui hay al menos un valor en el buffer
    // Lo obtiene
    int resultado = buffer[readIndex++];
    // Actualiza el índice
    readIndex %= maxSize;
    // Y el tamaño actual
    currentSize--;
    
    // Notifica alguno que esté esperando
    notify();
    
    // Y devuelve el valor
    return resultado;
  }
}
