package mx.evisoft.petagram.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import mx.evisoft.petagram.db.ConstructorAnimalCompania;
import mx.evisoft.petagram.pojo.AnimalCompania;
import mx.evisoft.petagram.vista.fragment.IRecyclerViewFragmentView;
import mx.evisoft.petagram.restApi.EndpointsApi;
import mx.evisoft.petagram.restApi.adapter.RestApiAdapter;
import mx.evisoft.petagram.restApi.model.AnimalCompaniaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by evana.margain on 5/18/17.
 */

public class RecyclerViewFragmentPresenter implements  IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorAnimalCompania constructorAnimalCompania;
    private ArrayList<AnimalCompania> animalesCompania;
    private ArrayList<AnimalCompania> animalesCompania2;
    private ArrayList<AnimalCompania> animalesCompania3;
    private ArrayList<AnimalCompania> animalesCompaniaCompleto;
    private boolean service1 = false;
    private boolean service2 = false;
    private boolean service3 = false;

    private String TAG = this.getClass().getSimpleName();

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        //obtenerAnimalesCompaniaBaseDatos();
        obtenerMediosRecientes();
    }

    @Override
    public void obtenerAnimalesCompaniaBaseDatos() {
        constructorAnimalCompania = new ConstructorAnimalCompania(context);
        animalesCompania = constructorAnimalCompania.obtenerDatos();
        mostrarAnimalesCompaniaRV();
    }

    @Override
    public void obtenerMediosRecientes(){
        Log.d(TAG, "obtenerMediosRecientes()");
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        Call<AnimalCompaniaResponse> animalCompaniaResponseCall= endpointsApi.getRecentMediaEvi();

        animalCompaniaResponseCall.enqueue(new Callback<AnimalCompaniaResponse>() {
            @Override
            public void onResponse(Call<AnimalCompaniaResponse> call, Response<AnimalCompaniaResponse> response) {
                AnimalCompaniaResponse animalCompaniaResponse = response.body();
                animalesCompania2 = animalCompaniaResponse.getAnimalesCompania();
                service2 = true;
                if(service1 == true && service2 == true && service3 == true){
                    mostrarAnimalesCompaniaRV();
                }
            }

            @Override
            public void onFailure(Call<AnimalCompaniaResponse> call, Throwable t) {

                Toast.makeText(context, "¡Algo pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e(TAG, "Falló la conexión " + t.toString());
            }
        });

        animalCompaniaResponseCall= endpointsApi.getRecentMediaMarilyn();

        animalCompaniaResponseCall.enqueue(new Callback<AnimalCompaniaResponse>() {
            @Override
            public void onResponse(Call<AnimalCompaniaResponse> call, Response<AnimalCompaniaResponse> response) {
                AnimalCompaniaResponse animalCompaniaResponse = response.body();
                animalesCompania3 = animalCompaniaResponse.getAnimalesCompania();
                service3 = true;
                if(service1 == true && service2 == true && service3 == true){
                    mostrarAnimalesCompaniaRV();
                }

            }

            @Override
            public void onFailure(Call<AnimalCompaniaResponse> call, Throwable t) {

                Toast.makeText(context, "¡Algo pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e(TAG, "Falló la conexión " + t.toString());
            }
        });

        animalCompaniaResponseCall= endpointsApi.getRecentMedia();

        animalCompaniaResponseCall.enqueue(new Callback<AnimalCompaniaResponse>() {
            @Override
            public void onResponse(Call<AnimalCompaniaResponse> call, Response<AnimalCompaniaResponse> response) {
                AnimalCompaniaResponse animalCompaniaResponse = response.body();
                animalesCompania = animalCompaniaResponse.getAnimalesCompania();
                service1 = true;
                if(service1 == true && service2 == true && service3 == true){
                    mostrarAnimalesCompaniaRV();
                }

            }

            @Override
            public void onFailure(Call<AnimalCompaniaResponse> call, Throwable t) {

                Toast.makeText(context, "¡Algo pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e(TAG, "Falló la conexión " + t.toString());
            }
        });

    }

    @Override
    public void mostrarAnimalesCompaniaRV() {
        Log.d(TAG, "mostrarAnimalesCompaniaRV()");
        animalesCompania.addAll(animalesCompania2);
        animalesCompania.addAll(animalesCompania3);
        animalesCompaniaCompleto = animalesCompania;
        Collections.shuffle(animalesCompaniaCompleto);
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(animalesCompaniaCompleto));
        iRecyclerViewFragmentView.generarGridLayout();
    }
}
