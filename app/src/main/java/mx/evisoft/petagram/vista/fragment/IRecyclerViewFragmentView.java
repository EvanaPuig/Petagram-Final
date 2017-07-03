package mx.evisoft.petagram.vista.fragment;

import mx.evisoft.petagram.adapter.AnimalCompaniaAdaptador;
import mx.evisoft.petagram.pojo.AnimalCompania;

import java.util.ArrayList;

/**
 * Created by evana.margain on 5/18/17.
 */

public interface IRecyclerViewFragmentView {

        void generarLinearLayoutVertical();
        void generarGridLayout();

        AnimalCompaniaAdaptador crearAdaptador(ArrayList<AnimalCompania> animalCompania);

        void inicializarAdaptadorRV(AnimalCompaniaAdaptador adaptador);

}
