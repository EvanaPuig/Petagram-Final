package mx.evisoft.petagram.Activity;

/**
 * Created by Evana Margain Puig on 24/07/16.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.evisoft.petagram.R;
import mx.evisoft.petagram.pojo.AnimalCompania;
import mx.evisoft.petagram.adapter.AnimalCompaniaAdaptador;
import mx.evisoft.petagram.db.BaseDatos;
import mx.evisoft.petagram.restApi.EndpointsApi;
import mx.evisoft.petagram.restApi.adapter.RestApiAdapter;
import mx.evisoft.petagram.restApi.model.AnimalCompaniaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoritosActivity extends AppCompatActivity {

    private ArrayList animalesCompania;
    private RecyclerView listaAnimalesCompania;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);


        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listaAnimalesCompania = (RecyclerView) findViewById(R.id.rvAnimalesCompania);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaAnimalesCompania.setLayoutManager(llm);

        animalesCompania = new ArrayList<AnimalCompania>();

        //inicializarListaAnimalesCompania();
        obtenerMediosRecientes();
    }



    public void inicializarListaAnimalesCompania(){


        /*animalesCompania.add(new AnimalCompania("Huevo", "5", R.drawable.perro2));
        animalesCompania.add(new AnimalCompania("Sally", "3", R.drawable.perro5));
        animalesCompania.add(new AnimalCompania("Fluffy", "3", R.drawable.perro6));
        animalesCompania.add(new AnimalCompania("Pluto", "3", R.drawable.perro7));
        animalesCompania.add(new AnimalCompania("Doggy", "3", R.drawable.perro8));

        BaseDatos db = new BaseDatos(this);

        animalesCompania = db.obtenerFavoritos();*/
    }

    public void obtenerMediosRecientes(){
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        Call<AnimalCompaniaResponse> animalCompaniaResponseCall = endpointsApi.getRecentMedia();



        animalCompaniaResponseCall.enqueue(new Callback<AnimalCompaniaResponse>() {
            @Override
            public void onResponse(Call<AnimalCompaniaResponse> call, Response<AnimalCompaniaResponse> response) {
                AnimalCompaniaResponse animalCompaniaResponse = response.body();
                animalesCompania = animalCompaniaResponse.getAnimalesCompania();

                mostrarAnimalesCompania();
            }

            @Override
            public void onFailure(Call<AnimalCompaniaResponse> call, Throwable t) {

                Toast.makeText(FavoritosActivity.this, "¡Algo pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("Favoritos", "Falló la conexión " + t.toString());
            }
        });
    }

    public void mostrarAnimalesCompania() {
        ArrayList<AnimalCompania> animalesCompania2 = new ArrayList<AnimalCompania>(animalesCompania.subList(0, 5));
        inicializarAdaptador(crearAdaptador(animalesCompania2));
    }

    public void inicializarAdaptador(AnimalCompaniaAdaptador adaptador){
        listaAnimalesCompania.setAdapter(adaptador);
    }

    public AnimalCompaniaAdaptador crearAdaptador(ArrayList<AnimalCompania> animalesCompania) {
        AnimalCompaniaAdaptador adaptador = new AnimalCompaniaAdaptador(animalesCompania, FavoritosActivity.this);
        return adaptador;
    }
}
