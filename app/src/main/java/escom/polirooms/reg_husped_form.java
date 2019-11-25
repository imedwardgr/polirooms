package escom.polirooms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class reg_husped_form extends AppCompatActivity {
    DialogFragment chooseImageDialog;
    Button ineButton;
    Button ipnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_husped_form);

        chooseImageDialog = new choose_image();

        ineButton = findViewById(R.id.form_huesped_ine);
        ipnButton = findViewById(R.id.form_huesped_ipn);

        ineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImageDialog.show(getSupportFragmentManager(),"chooseImage");
            }
        });

        ipnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImageDialog.show(getSupportFragmentManager(),"chooseImage");
            }
        });
    }
}
