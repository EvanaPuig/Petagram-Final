package mx.evisoft.petagram.restApi;

/**
 * Created by evana.margain on 5/17/17.
 */

public class ConstantesRestApi {

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "2241246656.07f04f0.55862b1d16a049af8c29f4281542cba1";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_INFORMATION_USER = "users/self/media/recent/";

    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_INFORMATION_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
}
