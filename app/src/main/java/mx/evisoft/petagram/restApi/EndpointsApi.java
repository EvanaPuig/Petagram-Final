package mx.evisoft.petagram.restApi;

import mx.evisoft.petagram.restApi.model.AnimalCompaniaResponse;
import mx.evisoft.petagram.restApi.model.LikeResponse;
import mx.evisoft.petagram.restApi.model.UsuarioResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by evana.margain on 5/17/17.
 */

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<AnimalCompaniaResponse> getRecentMedia();

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_MARILYN)
    Call<AnimalCompaniaResponse> getRecentMediaMarilyn();

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_EVI)
    Call<AnimalCompaniaResponse> getRecentMediaEvi();

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenId(@Field("id_dispositivo") String id_dispositivo, @Field("id_usuario_instagram") String id_usuario_instagram);

    @POST(ConstantesRestApi.KEY_PUT_LIKE)
    Call<ResponseBody> darLike(@Path("media-id") String media_id);

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_LIKE_FOTO)
    Call<LikeResponse> registrarLike(@Field("id_dispositivo") String id_dispositivo, @Field("id_usuario_instagram") String id_usuario_instagram, @Field("id_foto") String id_foto);

    //https://calm-gorge-39910.herokuapp.com/notificacion-foto/:id/:nombre_usuario
    @GET(ConstantesRestApi.KEY_SEND_NOTIF)
    Call<ResponseBody> enviarNotificacion(@Path("id") String id, @Path("nombre_usuario") String nombre_usuario);
}
