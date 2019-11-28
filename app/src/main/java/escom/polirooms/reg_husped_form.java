package escom.polirooms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class reg_husped_form extends AppCompatActivity {
    DialogFragment chooseImageDialog;
    Button ineButton;
    Button ipnButton;
    Button nextStep;

    EditText name;
    EditText second_name;
    EditText email;
    EditText age;
    RadioGroup gender;
    Bitmap ine;
    Bitmap ipn;
    CheckBox termsBox;

    private static final int MY_INTERNET_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_husped_form);

        chooseImageDialog = new choose_image();

        ineButton = findViewById(R.id.form_huesped_ine);
        ipnButton = findViewById(R.id.form_huesped_ipn);
        nextStep = findViewById(R.id.form_huesped_next_button);

        name = findViewById(R.id.form_huesped_name);
        second_name = findViewById(R.id.form_huesped_second_name);
        email = findViewById(R.id.form_huesped_email);
        age = findViewById(R.id.form_huesped_age);
        gender = findViewById(R.id.form_huesped_genre);
        termsBox = findViewById(R.id.form_huesped_terms);

        ine =  Bitmap.createBitmap(1, 1,Bitmap.Config.RGB_565);
        ipn = Bitmap.createBitmap(1, 1,Bitmap.Config.RGB_565);

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

        nextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(reg_husped_form.this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED)
                {
                    requestPermissions(new String[]{Manifest.permission.INTERNET}, MY_INTERNET_PERMISSION_CODE);
                }
                else
                {
                    if(termsBox.isChecked()){
                        Intent i = new Intent(reg_husped_form.this, reg_huesped_personality_test.class);
                        i.putExtra("name", name.getText().toString());
                        i.putExtra("second_name", second_name.getText().toString());
                        i.putExtra("email",email.getText().toString());
                        i.putExtra("age", age.getText().toString());
                        i.putExtra("gender", Integer.toString(gender.getCheckedRadioButtonId()));


                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        ine.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream .toByteArray();
                        i.putExtra("ine", Base64.encodeToString(byteArray,Base64.DEFAULT));

                        byteArrayOutputStream = new ByteArrayOutputStream();
                        ipn.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        byteArray = byteArrayOutputStream .toByteArray();
                        i.putExtra("ipn", Base64.encodeToString(byteArray,Base64.DEFAULT));

                        startActivity(i);
                    }else{
                        Toast.makeText(reg_husped_form.this, "Por favor, llena todo el formulario antes de continuar", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_INTERNET_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(reg_husped_form.this, "Internet permission granted", Toast.LENGTH_LONG).show();
                Intent i = new Intent(reg_husped_form.this, reg_huesped_personality_test.class);
                startActivity(i);
            }
            else
            {
                Toast.makeText(reg_husped_form.this, "Internet permission denied, register cannot continue", Toast.LENGTH_LONG).show();
            }
        }
    }
}
