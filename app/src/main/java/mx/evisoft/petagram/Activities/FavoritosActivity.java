package mx.evisoft.petagram.Activities;

/**
 * Created by Evana Margain Puig on 24/07/16.
 */

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import mx.evisoft.petagram.R;
import mx.evisoft.petagram.RecyclerView.AnimalCompania;
import mx.evisoft.petagram.adapter.AnimalCompaniaAdaptador;
import mx.evisoft.petagram.db.BaseDatos;

public class FavoritosActivity extends AppCompatActivity {

    private ArrayList animalesCompania;
    private RecyclerView listaAnimalesCompania;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        context = this.getApplicationContext();

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listaAnimalesCompania = (RecyclerView) findViewById(R.id.rvAnimalesCompania);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaAnimalesCompania.setLayoutManager(llm);

        inicializarListaAnimalesCompania();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        AnimalCompaniaAdaptador adaptador = new AnimalCompaniaAdaptador(animalesCompania, context);
        listaAnimalesCompania.setAdapter(adaptador);
    }

    public void inicializarListaAnimalesCompania(){
        animalesCompania = new ArrayList<AnimalCompania>();

        /*animalesCompania.add(new AnimalCompania("Huevo", "5", R.drawable.perro2));
        animalesCompania.add(new AnimalCompania("Sally", "3", R.drawable.perro5));
        animalesCompania.add(new AnimalCompania("Fluffy", "3", R.drawable.perro6));
        animalesCompania.add(new AnimalCompania("Pluto", "3", R.drawable.perro7));
        animalesCompania.add(new AnimalCompania("Doggy", "3", R.drawable.perro8));*/

        BaseDatos db = new BaseDatos(context);

        animalesCompania = db.obtenerFavoritos();
    }
}
