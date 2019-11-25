package escom.polirooms;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class reg_select_type_of_user extends AppCompatActivity {
    Button huespedButton;
    Button arrendadorButton;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_select_type_of_user);

        huespedButton = findViewById(R.id.register_huesped_button);
        arrendadorButton = findViewById(R.id.register_arrendador_button);

        huespedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(reg_select_type_of_user.this, reg_husped_form.class);
                startActivity(i);
            }
        });

        arrendadorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(reg_select_type_of_user.this, reg_arrendador_form.class);
                startActivity(i);
            }
        });

    }

}
