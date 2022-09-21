package ud01.pro01;

public class CuentaLineasEnDirectorio {

  public static void main(String[] args) {
    
    // Para que funcione correctamente y no complicar la lógica, la ruta debe ser absoluta.
    // La carpeta por defecto también funciona
    String rutaCarpetaProcesar = args.length > 0 ? args[0] : ".";
    
    Carpeta carpetaProcesar = new Carpeta(rutaCarpetaProcesar);
    
    String[] archivosEnCarpeta = carpetaProcesar.getNombresArchivos();
    
    long totalLineas = 0;
    
    for (String archivo : archivosEnCarpeta) {
      String rutaCompletaArchivo = rutaCarpetaProcesar + "/" + archivo;
      ContadorLineas contador = ContadorLineasFactory.createContador(rutaCompletaArchivo);
      totalLineas += contador.getLineas();
      
    }
    System.out.println("El total de líneas en los archivos de la carpeta '" 
        + rutaCarpetaProcesar
        + "' es de "
        + totalLineas
        + " lineas");
  }

}
