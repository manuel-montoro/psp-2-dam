package ud01.pro01;

import java.io.File;
import java.util.ArrayList;

public class Carpeta {

  private String ruta;
  
  public Carpeta(String ruta) {
    this.ruta = ruta;
  }

  public String[] getNombresArchivos() {
    ArrayList<String> nombres = new ArrayList<String>();
    File carpeta = new File(ruta);
    File listaArchivos[] = carpeta.listFiles();
    for (File archivo : listaArchivos) {
      nombres.add(archivo.getName());
    }
    return (String [])nombres.toArray(new String[nombres.size()]);
 }
  
  
}
