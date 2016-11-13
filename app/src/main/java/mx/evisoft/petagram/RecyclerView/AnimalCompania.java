package mx.evisoft.petagram.RecyclerView;

/**
 * Created by Evana Margain Puig on 24/07/16.
 */
public class AnimalCompania {

    private String nombre;
    private String numeroLikes;
    private int foto;
    private int id;

    public AnimalCompania(String nombre, String numeroLikes, int foto) {
        this.nombre = nombre;
        this.numeroLikes = numeroLikes;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
