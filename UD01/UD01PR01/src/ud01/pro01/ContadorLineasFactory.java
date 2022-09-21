package ud01.pro01;

public class ContadorLineasFactory {

  public static ContadorLineas createContador(String archivo) {
    String os = System.getProperty("os.name").toLowerCase();
    if (os.indexOf("nux") >= 0) {
      return new ContadorLineasUnix(archivo);
    } else if (os.indexOf("win") >= 0) {
      return new ContadorLineasWindows(archivo);
    } else {
      throw new RuntimeException("Sistema operativo no soportado");
    }

  }
}
