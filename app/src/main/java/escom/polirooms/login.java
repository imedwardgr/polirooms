package escom.polirooms;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    Button registerButton;
    Button loginButton;

    EditText inputName;
    EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        registerButton = findViewById(R.id.login_register_button);
        loginButton = findViewById(R.id.login_singin_button);
        inputName = findViewById(R.id.login_username_input);
        inputPassword = findViewById(R.id.login_password_input);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this, reg_select_type_of_user.class);
                startActivity(i);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isHuesped;
                /*if(login_auth.execute(inputName.getText().toString(), inputPassword.getText().toString())){
                    //Si existe  una cuenta checamos si es arrendador o si es huesped
                }
                else{
                    //Mandamos error en los datos de loggin
                }
                 */
                //Prueba
                isHuesped = true;

                Intent i;
                if(isHuesped){
                    i = new Intent(login.this, dashboard_huesped.class);
                }else{
                    i = new Intent(login.this, dashboard_arrendador.class);
                }

                startActivity(i);
                finish();


            }
        });

    }

    private static class login_auth extends AsyncTask<String, Integer, Boolean> {
        @Override
        protected Boolean doInBackground(String... strings) {
            String username = strings[0];
            String password = strings[1];

            //Conectar a firebase y checar login

            return false;
        }
    }

}
