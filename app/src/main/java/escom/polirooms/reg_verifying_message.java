package escom.polirooms;

import android.content.Intent;
import android.os.Bundle;

import com.azure.data.service.DocumentClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class reg_verifying_message extends AppCompatActivity {
    TextView regData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_verifying_message);

        Intent prev = getIntent();
        regData = findViewById(R.id.datosRegistro);

        StringBuilder sb = new StringBuilder();
        sb.append("Nombre= " + prev.getStringExtra("name") + "\n");
        sb.append("Apellidos= " + prev.getStringExtra("second_name") + "\n");
        sb.append("Edad= " + prev.getStringExtra("age") + "\n");
        sb.append("Personalidad= " + prev.getStringExtra("personality") + "\n");
        sb.append("Genero= " + prev.getStringExtra("gender") + "\n");

        regData.setText(sb.toString());

        //Cosmos DB Integration
        String cosmosUrl = "https://polirooms.documents.azure.com:443/";
        String cosmosKey = "to2y15KRJvniDFAYoxU42jQgtJRlt0AgcF1n4WqaGMIHeUdZ0pbJggLGMuvtAvBWoTeisn8MeOfSHu15pEoXaw==";

    }

}
