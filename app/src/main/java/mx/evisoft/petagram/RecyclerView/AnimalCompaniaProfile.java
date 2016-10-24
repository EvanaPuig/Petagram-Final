package mx.evisoft.petagram.RecyclerView;

/**
 * Created by Evana Margain Puig on 24/07/16.
 */
public class AnimalCompaniaProfile {

    private String numeroLikes;
    private int foto;

    public AnimalCompaniaProfile(String numeroLikes, int foto) {
        this.numeroLikes = numeroLikes;
        this.foto = foto;
    }

    public String getNumeroLikes() {
        return numeroLikes;
    }

    public void setNumeroLikes(String numeroLikes) {
        this.numeroLikes = numeroLikes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
