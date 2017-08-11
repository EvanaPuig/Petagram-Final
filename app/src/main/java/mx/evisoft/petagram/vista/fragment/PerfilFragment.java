package mx.evisoft.petagram.vista.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.evisoft.petagram.R;
import mx.evisoft.petagram.adapter.AnimalCompaniaAdaptador;
import mx.evisoft.petagram.pojo.AnimalCompania;
import mx.evisoft.petagram.pojo.AnimalCompaniaProfile;
import mx.evisoft.petagram.adapter.AnimalCompaniaProfileAdaptador;
import mx.evisoft.petagram.restApi.EndpointsApi;
import mx.evisoft.petagram.restApi.adapter.RestApiAdapter;
import mx.evisoft.petagram.restApi.model.AnimalCompaniaResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private ArrayList<AnimalCompania> animalesCompania;
    private RecyclerView listaFotos;
    private String TAG = this.getClass().getSimpleName();
    private String user;
    private TextView tvNombrePerro;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaFotos = (RecyclerView) v.findViewById(R.id.rvFotos);
        tvNombrePerro = (TextView) v.findViewById(R.id.tv_nombre_perro);

        LinearLayoutManager llm = new GridLayoutManager(getActivity(), 3);

        listaFotos.setLayoutManager(llm);

        Intent intent = getActivity().getIntent();
        user = intent.getStringExtra("user");



        //inicializarListaAnimalesCompania();
        obtenerMediosRecientes(v);

        return  v;
    }



    /*public void inicializarListaAnimalesCompania(){
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
    }*/

    public void obtenerMediosRecientes(final View v){
        Log.d(TAG, "obtenerMediosRecientes()");
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        Call<AnimalCompaniaResponse> animalCompaniaResponseCall = endpointsApi.getRecentMedia();

        //aquí revisar si hay intent
        if(user != null){
            Log.d("se seteo un usuario", user);
            if(user.equals("xevixmp")){
                tvNombrePerro.setText("Evi");
                animalCompaniaResponseCall= endpointsApi.getRecentMediaEvi();
            }else if(user.equals("marilynferetrius")){
                tvNombrePerro.setText("Marilyn");
                animalCompaniaResponseCall = endpointsApi.getRecentMediaMarilyn();
            }
        }



        animalCompaniaResponseCall.enqueue(new Callback<AnimalCompaniaResponse>() {
            @Override
            public void onResponse(Call<AnimalCompaniaResponse> call, Response<AnimalCompaniaResponse> response) {
                AnimalCompaniaResponse animalCompaniaResponse = response.body();
                animalesCompania = animalCompaniaResponse.getAnimalesCompania();


                mostrarAnimalesCompania(v);
            }

            @Override
            public void onFailure(Call<AnimalCompaniaResponse> call, Throwable t) {

                Toast.makeText(getActivity(), "¡Algo pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e(TAG, "Falló la conexión " + t.toString());
            }
        });
    }

    public void mostrarAnimalesCompania(View v) {
        Log.d(TAG, "mostrarAnimalesCompania()");

        ImageView profile = (ImageView) v.findViewById(R.id.ivProfilePic);

        Picasso.with(getActivity())
                .load(animalesCompania.get(0).getUrlFoto())
                .placeholder(R.drawable.perro2)
                .into(profile);

        inicializarAdaptador(crearAdaptador(animalesCompania));
    }

    public void inicializarAdaptador(AnimalCompaniaAdaptador adaptador){
        listaFotos.setAdapter(adaptador);
    }

    public AnimalCompaniaAdaptador crearAdaptador(ArrayList<AnimalCompania> animalesCompania) {
        AnimalCompaniaAdaptador adaptador = new AnimalCompaniaAdaptador(animalesCompania, getActivity());
        return adaptador;
    }

}
