package mx.evisoft.petagram.pojo;

/**
 * Created by Evana Margain Puig on 24/07/16.
 */
public class AnimalCompania {

    private String id;
    private String nombreCompleto;
    private String urlFoto;
    private int numeroLikes;

    public AnimalCompania(String urlFoto, String nombreCompleto, int numeroLikes) {
        this.urlFoto = urlFoto;
        this.nombreCompleto = nombreCompleto;
        this.numeroLikes = numeroLikes;

    }

    public AnimalCompania() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getNumeroLikes() {
        return numeroLikes;
    }

    public void setNumeroLikes(int numeroLikes) {
        this.numeroLikes = numeroLikes;
    }
}
