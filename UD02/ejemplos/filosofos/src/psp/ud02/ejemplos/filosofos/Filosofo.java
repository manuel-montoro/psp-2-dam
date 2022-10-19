package psp.ud02.ejemplos.filosofos;

public class Filosofo extends Thread {

  private final int TIEMPODORMIR = 15000;
  private final int TIEMPOCOMER = 30000;
  
  private Mesa mesa;
  private int posicion;
  
  public Filosofo(int posicion, Mesa mesa) {
    this.posicion = posicion;
    this.mesa = mesa;
  }
  @Override
  public void run() {
    
    // Anunciamos inicio
    imprimirMensaje("Iniciando");
    while (true) {
      // Dormimos
      imprimirMensaje("Voy a dormir");
      try {
        sleep((long)Math.random() * TIEMPODORMIR);
      } catch (InterruptedException e) {}
      // Intentamos obtener los tenedores
      imprimirMensaje("Voy a intentar comer");
      if (mesa.obtenerTenedores(this.posicion)) {
        imprimirMensaje("Comiendo");
        try {
          sleep((long)Math.random() * TIEMPOCOMER);
        } catch (InterruptedException e) {}
        imprimirMensaje("Ya he comido. Voy a soltar los tenedores");
        mesa.soltarTenedores(this.posicion);
      } else {
        imprimirMensaje("No puedo obtener los tenedores. A ayunar");
      }
    }
  }
  
  private void imprimirMensaje(String mensaje) {
    System.out.println("Filosofo " + this.posicion + ": " + mensaje);
  }

}
