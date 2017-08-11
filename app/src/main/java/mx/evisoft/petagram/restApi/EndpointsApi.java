package mx.evisoft.petagram.restApi;

import mx.evisoft.petagram.restApi.model.AnimalCompaniaResponse;
import retrofit2.Call;
import retrofit2.http.GET;

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
}
