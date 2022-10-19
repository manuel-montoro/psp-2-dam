package psp.ud02.ejemplos.filosofos;

public class Mesa {

  private boolean[] tenedores;
  
  public Mesa() {
    this(0);
  }
  
  public Mesa(int tenedores) {
    this.tenedores = new boolean[tenedores];
    for (int i = 0; i < this.tenedores.length; i++) {
      this.tenedores[i] = false;
    }
  }
  
  public synchronized boolean obtenerTenedores(int posicionFilosofo) {
    int izquierda = posicionTenedorIzquierda(posicionFilosofo);
    int derecha = posicionTenedorDerecha(posicionFilosofo);
    
    // Si los tenedores están libres
    if (!tenedores[izquierda] && !tenedores[derecha]) {
      // Los toma
      tenedores[izquierda] = true;
      tenedores[derecha] = true;
      return true;
    } else {
      return false;
    }
  }
  
  public synchronized void soltarTenedores(int posicionFilosofo) {
    int izquierda = posicionTenedorIzquierda(posicionFilosofo);
    int derecha = posicionTenedorDerecha(posicionFilosofo);

    // Suelta los tenedores
    tenedores[izquierda] = false;
    tenedores[derecha] = false;
  }

  private int posicionTenedorIzquierda(int posicionFilosofo) {
    return (posicionFilosofo > 0) ? (posicionFilosofo - 1) : (tenedores.length - 1);
  }
  
  private int posicionTenedorDerecha(int posicionFilosofo) {
    return (posicionFilosofo < (tenedores.length - 1)) ? (posicionFilosofo + 1) : 0;
  }

}
