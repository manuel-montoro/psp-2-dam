package ud01.pro01;

public class ContadorLineasWindows extends ContadorLineas {
  // Os lo dejo como ejercicio. Seria algo asi como
  // find /V /C "" archivo

  public ContadorLineasWindows(String archivo) {
    super(archivo);
  }
  
  
  @Override
  protected String[] construirComando(String archivo) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected int procesaResultado(String resultado) {
    // TODO Auto-generated method stub
    return 0;
  }

}
