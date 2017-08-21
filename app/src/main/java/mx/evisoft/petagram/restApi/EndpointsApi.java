package mx.evisoft.petagram.restApi;

import mx.evisoft.petagram.restApi.model.AnimalCompaniaResponse;
import mx.evisoft.petagram.restApi.model.UsuarioResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

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
}
