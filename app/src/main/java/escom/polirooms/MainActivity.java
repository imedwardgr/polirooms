package escom.polirooms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import escom.polirooms.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Esto es una simulación del autologgeo, por lo que deberá ser remplazado con una conexion a la BD para comprobar el login
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(MainActivity.this, login.class);
                startActivity(i);
                finish();
            }
        }, 5000);   //5 seconds

    }
}
