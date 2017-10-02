package mx.evisoft.petagram.pojo;

/**
 * Created by Evana Margain Puig on 24/07/16.
 */
public class AnimalCompania {

    private String id;
    private String nombreCompleto;
    private String idFoto;
    private String urlFoto;
    private int likes = 0;

    public AnimalCompania(String idFoto, String urlFoto, String nombreCompleto, int numeroLikes) {
        this.idFoto = idFoto;
        this.urlFoto = urlFoto;
        this.nombreCompleto = nombreCompleto;
        this.likes = numeroLikes;

    }

    public AnimalCompania() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(String idFoto) {
        this.idFoto = idFoto;
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

    public int getLikes() {
        return likes;
    }

    public void setNumeroLikes(int likes) {
        this.likes = likes;
    }
}
