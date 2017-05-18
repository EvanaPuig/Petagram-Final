package mx.evisoft.petagram.restApi.model;

import java.util.ArrayList;

import mx.evisoft.petagram.pojo.AnimalCompania;

/**
 * Created by evana.margain on 5/18/17.
 */

public class AnimalCompaniaResponse {
    ArrayList<AnimalCompania> animalesCompania;

    public ArrayList<AnimalCompania> getAnimalesCompania() {
        return animalesCompania;
    }

    public void setAnimalesCompania(ArrayList<AnimalCompania> animalesCompania) {
        this.animalesCompania = animalesCompania;
    }
}
