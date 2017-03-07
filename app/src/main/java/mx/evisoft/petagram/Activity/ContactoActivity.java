package mx.evisoft.petagram.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mx.evisoft.petagram.R;
import mx.evisoft.petagram.Utils.SendMail;

public class ContactoActivity extends AppCompatActivity implements View.OnClickListener{

    //Declaring EditText
    private EditText editNombreCompleto;
    private EditText editEmail;
    private EditText editDescripcion;

    //Send button
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Initializing the views
        editNombreCompleto = (EditText) findViewById(R.id.editNombreCompleto);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editDescripcion = (EditText) findViewById(R.id.editDescripcion);

        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        //Adding click listener
        btnSiguiente.setOnClickListener(this);
    }

    private void sendEmail() {
        //Getting content for email
        String email = editEmail.getText().toString().trim();
        String subject = editNombreCompleto.getText().toString().trim();
        String message = editDescripcion.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }

}
