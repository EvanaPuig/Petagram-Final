package mx.evisoft.petagram.restApi.adapter;

import com.google.gson.Gson;

import mx.evisoft.petagram.restApi.ConstantesRestApi;
import mx.evisoft.petagram.restApi.EndpointsApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by evana.margain on 5/18/17.
 */

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(){


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EndpointsApi.class);
    }
}
