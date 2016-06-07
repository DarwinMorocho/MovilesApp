package ec.edu.com.epn.konwarriosapp.vo;

/**
 * Created by CHUCHO on 6/6/2016.
 */
public class GeneroVO {

    private String nombreGenero;

    public GeneroVO(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    public GeneroVO() {
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
}

