package mx.evisoft.petagram.restApi.deserializador;

/**
 * Created by evana.margain on 03/07/17.
 */

import android.util.Log;

import mx.evisoft.petagram.pojo.AnimalCompania;
import mx.evisoft.petagram.restApi.JsonKeys;
import mx.evisoft.petagram.restApi.model.AnimalCompaniaResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AnimalCompaniaDeserializador implements JsonDeserializer<AnimalCompaniaResponse> {
    private final String TAG = this.getClass().getSimpleName();

    @Override
    public AnimalCompaniaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        AnimalCompaniaResponse animalCompaniaResponse = gson.fromJson(json, AnimalCompaniaResponse.class);
        JsonArray animalCompaniaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        animalCompaniaResponse.setAnimalesCompania(deseralizarAnimalCompaniaDeJson(animalCompaniaResponseData));
        return animalCompaniaResponse;
    }

    private ArrayList<AnimalCompania> deseralizarAnimalCompaniaDeJson(JsonArray animalCompaniaResponseData){
        ArrayList<AnimalCompania> animalesCompania = new ArrayList<>();
        for (int i = 0; i < animalCompaniaResponseData.size() ; i++) {
            JsonObject animalCompaniaResponseDataObject = animalCompaniaResponseData.get(i).getAsJsonObject();

            String picId = animalCompaniaResponseDataObject.get(JsonKeys.MEDIA_ID).getAsString();

            JsonObject userJson     = animalCompaniaResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id               = userJson.get(JsonKeys.USER_ID).getAsString();
            String nombreCompleto   = userJson.get(JsonKeys.USER_FULLNAME).getAsString();

            JsonObject imageJson            = animalCompaniaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson    = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String urlFoto                  = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson = animalCompaniaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            AnimalCompania animalCompaniaActual = new AnimalCompania();
            animalCompaniaActual.setId(id);
            animalCompaniaActual.setIdFoto(picId);
            animalCompaniaActual.setNombreCompleto(nombreCompleto);
            animalCompaniaActual.setUrlFoto(urlFoto);
            animalCompaniaActual.setNumeroLikes(likes);

            animalesCompania.add(animalCompaniaActual);

            Log.d(TAG, animalCompaniaActual.getId().toString() + " " +
                    animalCompaniaActual.getNombreCompleto().toString()  + " " +
                    animalCompaniaActual.getIdFoto().toString() + " " +
                    animalCompaniaActual.getUrlFoto().toString()  + " " +
                    animalCompaniaActual.getLikes()

            );

        }

        return animalesCompania;
    }
}