package ud01.pro01;

public class ContadorLineasUnix extends ContadorLineas {

  public ContadorLineasUnix(String archivo) {
    super(archivo);
  }
  
  @Override
  protected String[] construirComando(String archivo) {
    String comando[] = {"/usr/bin/wc", "-l", archivo};
    return comando;
  }

  @Override
  protected int procesaResultado(String resultado) {
    StringBuffer numero = new StringBuffer();
    int i = 0;
    while ((i < resultado.length()) && (resultado.charAt(i) != ' ')) {
      numero.append(resultado.charAt(i));
      i++;
    }
    return Integer.parseInt(numero.toString());
  }

}
