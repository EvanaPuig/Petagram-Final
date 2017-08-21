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
    public static final String KEY_GET_INFORMATION_MARILYN = "users/258515851/media/recent/";
    public static final String KEY_GET_INFORMATION_EVI = "users/2963122977/media/recent/";

    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_INFORMATION_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    //marilyn 
    // www.miguelreynaga.com 
    // https://api.instagram.com/v1/users/258515851/media/recent/?access_token=2241246656.07f04f0.55862b1d16a049af8c29f4281542cba1 
    public static final String URL_GET_RECENT_MEDIA_MARILYN = KEY_GET_INFORMATION_MARILYN + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    // evi 
    // www.evisoft.mx /
    // https://api.instagram.com/v1/users/2963122977/media/recent/?access_token=2241246656.07f04f0.55862b1d16a049af8c29f4281542cba1 
    public static final String URL_GET_RECENT_MEDIA_EVI = KEY_GET_INFORMATION_EVI + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    public static final String ROOT_URL_MY_WS = "https://calm-gorge-39910.herokuapp.com/";
    public static final String KEY_POST_ID_TOKEN = "registrar-usuario/";

}
