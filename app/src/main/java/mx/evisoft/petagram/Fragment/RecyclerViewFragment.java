package mx.evisoft.petagram.Fragment;


import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.evisoft.petagram.R;
import mx.evisoft.petagram.model.AnimalCompania;
import mx.evisoft.petagram.adapter.AnimalCompaniaAdaptador;
import mx.evisoft.petagram.db.BaseDatos;
import mx.evisoft.petagram.db.ConstantesBaseDatos;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    private ArrayList<AnimalCompania> animalesCompania;
    private RecyclerView listaAnimalesCompania;

    private Context context;

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

        context = this.getContext();

        inicializarListaAnimalesCompania();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        AnimalCompaniaAdaptador adaptador = new AnimalCompaniaAdaptador(animalesCompania, getActivity());
        listaAnimalesCompania.setAdapter(adaptador);
    }

    public void inicializarListaAnimalesCompania(){
        /*animalesCompania = new ArrayList<AnimalCompania>();

        animalesCompania.add(new AnimalCompania(1, "Lucky", "0", R.drawable.perro1));
        animalesCompania.add(new AnimalCompania(2, "Huevo", "0", R.drawable.perro2));
        animalesCompania.add(new AnimalCompania(3, "Xola", "0", R.drawable.perro3));
        animalesCompania.add(new AnimalCompania(4, "Taffy", "0", R.drawable.perro4));
        animalesCompania.add(new AnimalCompania(5, "Sally", "0", R.drawable.perro5));
        animalesCompania.add(new AnimalCompania(6, "Fluffy", "0", R.drawable.perro6));
        animalesCompania.add(new AnimalCompania(7, "Pluto", "0", R.drawable.perro7));
        animalesCompania.add(new AnimalCompania(8, "Doggy", "0", R.drawable.perro8));*/

        BaseDatos db = new BaseDatos(context);
        insertarAnimalesEjemplo(db);
        animalesCompania = db.obtenerTodosAnimalesCompania();
    }

    public void insertarAnimalesEjemplo(BaseDatos db){
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_ID, 1);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NOMBRE, "Carlitos");
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NUMERO_LIKES, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_FOTO, R.drawable.perro1);

        db.insertarAnimalCompania(contentValues);

        contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_ID, 2);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NOMBRE, "Xola");
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NUMERO_LIKES, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_FOTO, R.drawable.perro2);

        db.insertarAnimalCompania(contentValues);

        contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_ID, 3);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NOMBRE, "Huevo");
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NUMERO_LIKES, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_FOTO, R.drawable.perro3);

        db.insertarAnimalCompania(contentValues);

        contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_ID, 4);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NOMBRE, "Winnie");
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NUMERO_LIKES, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_FOTO, R.drawable.perro4);

        db.insertarAnimalCompania(contentValues);

        contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_ID, 5);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NOMBRE, "Mimmie");
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NUMERO_LIKES, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_FOTO, R.drawable.perro5);

        db.insertarAnimalCompania(contentValues);

        contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_ID, 6);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NOMBRE, "Chata");
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NUMERO_LIKES, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_FOTO, R.drawable.perro6);

        db.insertarAnimalCompania(contentValues);

        contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_ID, 7);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NOMBRE, "Plutto");
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NUMERO_LIKES, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_FOTO, R.drawable.perro7);

        db.insertarAnimalCompania(contentValues);

        contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_ID, 8);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NOMBRE, "Fluffy");
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_NUMERO_LIKES, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_ANIMAL_COMPANIA_FOTO, R.drawable.perro8);

        db.insertarAnimalCompania(contentValues);
    }



}
