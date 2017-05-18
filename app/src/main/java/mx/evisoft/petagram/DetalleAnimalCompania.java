package mx.evisoft.petagram;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by evana.margain on 5/17/17.
 */




public class DetalleAnimalCompania extends AppCompatActivity {
    private static final String KEY_EXTRA_URL = "url";
    private static final String KEY_EXTRA_LIKE = "like";
    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_animal_compania_foto);

        Bundle extras      = getIntent().getExtras();
        String url      = extras.getString(KEY_EXTRA_URL);
        String likes    = extras.getString(KEY_EXTRA_LIKE);

        tvLikesDetalle     = (TextView) findViewById(R.id.txtvLikesDetalle);

        tvLikesDetalle.setText(String.valueOf(likes));
    }
}