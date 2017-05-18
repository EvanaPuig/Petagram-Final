package mx.evisoft.petagram.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import mx.evisoft.petagram.db.ConstructorAnimalCompania;
import mx.evisoft.petagram.pojo.AnimalCompania;
import mx.evisoft.petagram.fragment.IRecyclerViewFragmentView;
import mx.evisoft.petagram.restApi.EndpointsApi;
import mx.evisoft.petagram.restApi.adapter.RestApiAdapter;
import mx.evisoft.petagram.restApi.model.AnimalCompaniaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

/**
 * Created by evana.margain on 5/18/17.
 */

public class RecyclerViewFragmentPresenter implements  IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorAnimalCompania constructorAnimalCompania;
    private ArrayList<AnimalCompania> animalesCompania;
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
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram();
        Call<AnimalCompaniaResponse> animalCompaniaResponseCall= endpointsApi.getRecentMedia();

        animalCompaniaResponseCall.enqueue(new Callback<AnimalCompaniaResponse>() {
            @Override
            public void onResponse(Call<AnimalCompaniaResponse> call, Response<AnimalCompaniaResponse> response) {
                AnimalCompaniaResponse animalCompaniaResponse = response.body();
                animalesCompania = animalCompaniaResponse.getAnimalesCompania();
                mostrarAnimalesCompaniaRV();
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
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(animalesCompania));
        iRecyclerViewFragmentView.generarGridLayout();
    }
}
