package psp.ud02.ejemplos.filosofos;

public class FilosofosApp {

  private static final int FILOSOFOS = 5;
  
  public static void main(String[] args) {

    // Creamos el gestor de tenedores
    Mesa gestorTenedores = new Mesa(FILOSOFOS);
    
    // Y los filósofos
    Filosofo[] filosofos = new Filosofo[FILOSOFOS];
    for (int i = 0; i < filosofos.length; i++) {
      // Crea el filósofo
      filosofos[i] = new Filosofo(i, gestorTenedores);
      // Y lo lanza
      filosofos[i].start();
    }
  }

}
