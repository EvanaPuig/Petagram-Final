package mx.evisoft.petagram.vista.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.evisoft.petagram.R;
import mx.evisoft.petagram.pojo.AnimalCompania;
import mx.evisoft.petagram.presentador.IRecyclerViewFragmentPresenter;
import mx.evisoft.petagram.adapter.AnimalCompaniaAdaptador;
import mx.evisoft.petagram.pojo.AnimalCompania;
import mx.evisoft.petagram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by evana.margain on 03/07/17.
 */

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{
    private ArrayList<AnimalCompania> animalesCompania;
    private RecyclerView rvAnimalesCompania;
    private IRecyclerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        rvAnimalesCompania = (RecyclerView) v.findViewById(R.id.rvAnimalesCompania);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    /*
    public void inicializarDatos(){
        contactos = new ArrayList<>();
        contactos.add(new Contacto(R.drawable.candy_icon, "Anahi Salgado", "77779999", "anahi@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.yammi_banana_icon, "Pedro Sanchez", "88882222", "pedro@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.shock_rave_bonus_icon, "Mireya Lopez", "33331111", "mireya@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.forest_mushroom_icon, "Juan Lopez", "44442222", "juan@gmail.com", likes));
    }*/



    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvAnimalesCompania.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvAnimalesCompania.setLayoutManager(gridLayoutManager);
    }

    @Override
    public AnimalCompaniaAdaptador crearAdaptador(ArrayList<AnimalCompania> animalesCompania) {
        AnimalCompaniaAdaptador adaptador = new AnimalCompaniaAdaptador(animalesCompania, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(AnimalCompaniaAdaptador adaptador) {
        rvAnimalesCompania.setAdapter(adaptador);
    }
}
