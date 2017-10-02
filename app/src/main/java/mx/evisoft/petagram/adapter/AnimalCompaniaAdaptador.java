package mx.evisoft.petagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

import mx.evisoft.petagram.Activity.DetalleAnimalCompania;
import mx.evisoft.petagram.R;
import mx.evisoft.petagram.pojo.AnimalCompania;
import mx.evisoft.petagram.restApi.EndpointsApi;
import mx.evisoft.petagram.restApi.adapter.RestApiAdapter;
import mx.evisoft.petagram.restApi.model.AnimalCompaniaResponse;
import mx.evisoft.petagram.restApi.model.LikeResponse;
import mx.evisoft.petagram.restApi.model.UsuarioResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Evana Margáin Puig on 24/07/16.
 */
public class AnimalCompaniaAdaptador extends RecyclerView.Adapter<AnimalCompaniaAdaptador.AnimalCompaniaViewHolder> {

    ArrayList<AnimalCompania> animalesCompania;

    Activity activity;


    public AnimalCompaniaAdaptador(ArrayList<AnimalCompania> animalesCompania, Activity activity){
        this.animalesCompania = animalesCompania;
        this.activity = activity;
    }



    @Override
    public AnimalCompaniaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_animal_compania, parent, false);

        return new AnimalCompaniaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final AnimalCompaniaViewHolder animalCompaniaViewHolder, int position) {
        final AnimalCompania animalCompania = animalesCompania.get(position);
        //animalCompaniaViewHolder.imgvFotoAnimalCompania.setImageResource(animalCompania.getFoto());
        //animalCompaniaViewHolder.txtvNombre.setText(animalCompania.getNombre());
        Picasso.with(activity)
                .load(animalCompania.getUrlFoto())
                .placeholder(R.drawable.perro2)
                .into(animalCompaniaViewHolder.imgvFotoAnimalCompania);

        final Integer numeroLikes = animalCompania.getLikes();

        animalCompaniaViewHolder.txtvLikes.setText(numeroLikes.toString());

        animalCompaniaViewHolder.imgvFotoAnimalCompania.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, animalCompania.getNombre(), Toast.LENGTH_LONG).show();
                /*Intent intent = new Intent(activity, DetalleAnimalCompania.class);
                intent.putExtra("url", animalCompania.getUrlFoto());
                intent.putExtra("like", animalCompania.getLikes());
                activity.startActivity(intent);*/
                likePic(animalCompania.getIdFoto(), animalCompania.getUrlFoto(), animalCompania.getNombreCompleto(), animalCompania.getLikes());

                Integer nuevoLike = numeroLikes + 1;
                animalCompaniaViewHolder.txtvLikes.setText(nuevoLike.toString());

            }
        });

        /*
        animalCompaniaViewHolder.imgvHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + animalCompania.getNombre(),
                        Toast.LENGTH_SHORT).show();

                Integer numeroLikes = animalCompania.getNumeroLikes();
                numeroLikes += 1;
                animalCompania.setNumeroLikes(numeroLikes);

                ConstructorAnimalCompania constructorAnimalCompania = new ConstructorAnimalCompania(activity);
                constructorAnimalCompania.darLikeAnimalCompania(animalCompania);
                animalCompaniaViewHolder.txtvLikes.setText(String.valueOf(animalCompania.getNumeroLikes()));


            }
        });*/
    }

    public void likePic(String idFoto, String urlFoto, String nombreCompleto, int numeroDeLikes){
        Log.d("LIKE", "true");

        final AnimalCompania animalCompania = new AnimalCompania(idFoto, urlFoto, nombreCompleto, numeroDeLikes);

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagramSinDes();
        Call<ResponseBody> responseBody = endpointsApi.darLike(animalCompania.getIdFoto());

        Log.d("idFoto", animalCompania.getIdFoto());

        responseBody.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    Log.d("response", "postJSONRequest response.code : " + response.code());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("like error", t.toString());
            }
        });

        String id_dispositivo = FirebaseInstanceId.getInstance().getToken();

        this.enviarRegistroLike(id_dispositivo, idFoto, "user_id");
    }

    private void enviarRegistroLike(String idDispositivo, String idFoto, String idUsuario){
        Log.d("LIKE", idDispositivo);
        Log.d("LIKE", idFoto);
        Log.d("LIKE", idUsuario);

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsApi endpoints = restApiAdapter.establecerConexionRestAPI();
        Call<LikeResponse> usuarioResponseCall = endpoints.registrarLike(idDispositivo, idUsuario, idFoto);

        usuarioResponseCall.enqueue(new Callback<LikeResponse>() {
            @Override
            public void onResponse(Call<LikeResponse> call, Response<LikeResponse> response) {
                LikeResponse likeResponse = response.body();
                Log.d("id_firebase", likeResponse.getId());
                Log.d("usuario_firebase", likeResponse.getId_dispositivo());
                Log.d("usuario_instagram", likeResponse.getId_usuario_instagram());
                Log.d("id_foto", likeResponse.getId_foto());

            }

            @Override
            public void onFailure(Call<LikeResponse> call, Throwable t) {
                Log.d("error", t.toString());
            }
        });

        this.enviarNotificacion("-KvQez7samAkvTFS1Kkk", "evi");

    }

    private void enviarNotificacion(String idDispositivo, String nombreUsuario){
        Log.d("LIKE", idDispositivo);
        Log.d("LIKE", nombreUsuario);

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsApi endpoints = restApiAdapter.establecerConexionRestAPI();
        Call<ResponseBody> enviarNotificacionCall = endpoints.enviarNotificacion(idDispositivo, nombreUsuario);

        enviarNotificacionCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("notificacion enviada", "notificacion correcta");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("error", t.toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return animalesCompania.size();
    }

    public static class AnimalCompaniaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgvFotoAnimalCompania;
        //private TextView txtvNombre;
        private TextView txtvLikes;
        //private ImageView imgvHuesoBlanco;


        public AnimalCompaniaViewHolder(View itemView){
            super(itemView);
            imgvFotoAnimalCompania = (ImageView) itemView.findViewById(R.id.imgvFotoAnimalCompania);
            //txtvNombre = (TextView) itemView.findViewById(R.id.txtvNombre);
            txtvLikes = (TextView) itemView.findViewById(R.id.txtvLikes);
            //imgvHuesoBlanco = (ImageView) itemView.findViewById(R.id.imgvHuesoBlanco);
        }
    }
}
