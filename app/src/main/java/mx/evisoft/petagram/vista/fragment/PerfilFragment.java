package mx.evisoft.petagram.vista.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.evisoft.petagram.R;
import mx.evisoft.petagram.pojo.AnimalCompaniaProfile;
import mx.evisoft.petagram.adapter.AnimalCompaniaProfileAdaptador;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<AnimalCompaniaProfile> fotos;
    private RecyclerView listaFotos;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaFotos = (RecyclerView) v.findViewById(R.id.rvFotos);

        LinearLayoutManager llm = new GridLayoutManager(getActivity(), 3);

        listaFotos.setLayoutManager(llm);

        inicializarListaAnimalesCompania();
        inicializarAdaptador();

        return  v;
    }

    public void inicializarAdaptador(){
        AnimalCompaniaProfileAdaptador adaptador = new AnimalCompaniaProfileAdaptador(fotos);
        listaFotos.setAdapter(adaptador);
    }

    public void inicializarListaAnimalesCompania(){
        fotos = new ArrayList<AnimalCompaniaProfile>();

        fotos.add(new AnimalCompaniaProfile("3",R.drawable.perro3));
        fotos.add(new AnimalCompaniaProfile("5",R.drawable.perro3));
        fotos.add(new AnimalCompaniaProfile("32",R.drawable.perro3));
        fotos.add(new AnimalCompaniaProfile("4",R.drawable.perro3));
        fotos.add(new AnimalCompaniaProfile("15",R.drawable.perro3));
        fotos.add(new AnimalCompaniaProfile("4",R.drawable.perro3));
        fotos.add(new AnimalCompaniaProfile("10",R.drawable.perro3));
        fotos.add(new AnimalCompaniaProfile("5",R.drawable.perro3));
        fotos.add(new AnimalCompaniaProfile("8",R.drawable.perro3));
        fotos.add(new AnimalCompaniaProfile("1",R.drawable.perro3));
    }

}
