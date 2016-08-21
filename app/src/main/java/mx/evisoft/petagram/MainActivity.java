package mx.evisoft.petagram;

/**
 * Created by Evana Margain Puig on 24/07/16.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList animalesCompania;
    private RecyclerView listaAnimalesCompania;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


        listaAnimalesCompania = (RecyclerView) findViewById(R.id.rvAnimalesCompania);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaAnimalesCompania.setLayoutManager(llm);

        inicializarListaAnimalesCompania();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toolbar tb = (Toolbar) findViewById(R.id.miActionBar);
        tb.inflateMenu(R.menu.action_favoritos);
        tb.setOnMenuItemClickListener(
                new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return onOptionsItemSelected(item);
                    }
                });

        return true;
    }

    public void inicializarAdaptador(){
        AnimalCompaniaAdaptador adaptador = new AnimalCompaniaAdaptador(animalesCompania);
        listaAnimalesCompania.setAdapter(adaptador);
    }

    public void inicializarListaAnimalesCompania(){
        animalesCompania = new ArrayList<AnimalCompania>();

        animalesCompania.add(new AnimalCompania("Lucky", "3", R.drawable.perro1));
        animalesCompania.add(new AnimalCompania("Huevo", "5", R.drawable.perro2));
        animalesCompania.add(new AnimalCompania("Chola", "7", R.drawable.perro3));
        animalesCompania.add(new AnimalCompania("Taffy", "3", R.drawable.perro4));
        animalesCompania.add(new AnimalCompania("Sally", "3", R.drawable.perro5));
        animalesCompania.add(new AnimalCompania("Fluffy", "3", R.drawable.perro6));
        animalesCompania.add(new AnimalCompania("Pluto", "3", R.drawable.perro7));
        animalesCompania.add(new AnimalCompania("Doggy", "3", R.drawable.perro8));
    }
}
