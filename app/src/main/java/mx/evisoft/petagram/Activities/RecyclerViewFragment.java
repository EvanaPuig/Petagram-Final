package mx.evisoft.petagram.Activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.evisoft.petagram.R;
import mx.evisoft.petagram.RecyclerView.AnimalCompania;
import mx.evisoft.petagram.adapter.AnimalCompaniaAdaptador;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    private ArrayList<AnimalCompania> animalesCompania;
    private RecyclerView listaAnimalesCompania;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listaAnimalesCompania = (RecyclerView) v.findViewById(R.id.rvAnimalesCompania);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaAnimalesCompania.setLayoutManager(llm);

        inicializarListaAnimalesCompania();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        AnimalCompaniaAdaptador adaptador = new AnimalCompaniaAdaptador(animalesCompania);
        listaAnimalesCompania.setAdapter(adaptador);
    }

    public void inicializarListaAnimalesCompania(){
        animalesCompania = new ArrayList<AnimalCompania>();

        animalesCompania.add(new AnimalCompania("Lucky", "0", R.drawable.perro1));
        animalesCompania.add(new AnimalCompania("Huevo", "0", R.drawable.perro2));
        animalesCompania.add(new AnimalCompania("Xola", "0", R.drawable.perro3));
        animalesCompania.add(new AnimalCompania("Taffy", "0", R.drawable.perro4));
        animalesCompania.add(new AnimalCompania("Sally", "0", R.drawable.perro5));
        animalesCompania.add(new AnimalCompania("Fluffy", "0", R.drawable.perro6));
        animalesCompania.add(new AnimalCompania("Pluto", "0", R.drawable.perro7));
        animalesCompania.add(new AnimalCompania("Doggy", "0", R.drawable.perro8));
    }

}
