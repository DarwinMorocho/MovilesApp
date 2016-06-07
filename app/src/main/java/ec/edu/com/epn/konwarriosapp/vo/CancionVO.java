package ec.edu.com.epn.konwarriosapp.vo;

/**
 * Created by CHUCHO on 6/6/2016.
 */
public class CancionVO {

    private String nombreCancion;
    private String album;
    private int anio;

    public CancionVO(String nombreCancion, String album, int anio) {
        this.nombreCancion = nombreCancion;
        this.album = album;
        this.anio = anio;
    }

    public CancionVO() {
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
