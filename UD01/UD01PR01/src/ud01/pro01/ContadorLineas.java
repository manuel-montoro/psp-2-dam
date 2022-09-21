package ud01.pro01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class ContadorLineas {
  
  private String archivo;

  public ContadorLineas(String archivo) {
    this.archivo = archivo;
  }

  public long getLineas() {
    try {
      String[] comando = construirComando(archivo);
      ProcessBuilder builder = new ProcessBuilder(comando);
      Process process = builder.start();
      String salida = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
      process.waitFor();
      if (process.exitValue() == 0) {
        return procesaResultado(salida);
      } else {
        return 0;
      }
    }  catch (IOException | InterruptedException e) {
      return 0;
    }
  }

  protected abstract String[] construirComando(String archivo);
  
  protected abstract int procesaResultado(String resultado);
}
