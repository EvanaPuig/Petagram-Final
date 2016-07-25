package mx.evisoft.petagram;

/**
 * Created by Evana Margain Puig on 24/07/16.
 */
public class AnimalCompania {

    private String nombre;
    private int numeroLikes;
    private int foto;

    public AnimalCompania(String nombre, int numeroLikes, int foto) {
        this.nombre = nombre;
        this.numeroLikes = numeroLikes;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroLikes() {
        return numeroLikes;
    }

    public void setNumeroLikes(int numeroLikes) {
        this.numeroLikes = numeroLikes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
