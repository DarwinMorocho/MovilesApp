package ec.edu.com.epn.konwarriosapp.vo;

/**
 * Created by CHUCHO on 6/6/2016.
 */
public class ArtistaVO {

    private String nombreArtista;
    private String cancion;
    private String descripcionBanda;
    private String genero;

    public ArtistaVO(String nombreArtista, String cancion, String descripcionBanda, String genero) {
        this.nombreArtista = nombreArtista;
        this.cancion = cancion;
        this.descripcionBanda = descripcionBanda;
        this.genero = genero;
    }

    public ArtistaVO() {
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public String getDescripcionBanda() {
        return descripcionBanda;
    }

    public void setDescripcionBanda(String descripcionBanda) {
        this.descripcionBanda = descripcionBanda;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
