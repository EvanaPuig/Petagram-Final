package mx.evisoft.petagram.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.evisoft.petagram.MainActivity;
import mx.evisoft.petagram.R;

public class ConfigurarCuenta extends AppCompatActivity {

    private Button btnGuardar;
    private EditText etUsuario;
    private String usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        btnGuardar = (Button)findViewById(R.id.btn_guardar);
        etUsuario = (EditText)findViewById(R.id.et_usuario);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentPerfil = new Intent(ConfigurarCuenta.this, MainActivity.class);
                usuario = etUsuario.getText().toString();

                if(!usuario.equals("xevixmp") && !usuario.equals("marilynferetrius") && !usuario.equals("_pelusoo")){
                    Toast.makeText(ConfigurarCuenta.this, "usuario no válido", Toast.LENGTH_LONG).show();
                }else{
                    intentPerfil.putExtra("user", usuario);
                    startActivity(intentPerfil);
                }

            }
        });
    }
}
