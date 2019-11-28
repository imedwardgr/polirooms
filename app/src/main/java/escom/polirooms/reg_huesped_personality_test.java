package escom.polirooms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class reg_huesped_personality_test extends AppCompatActivity {
    WebView web16Personatilies;
    Boolean hasResult = false;
    String personality;
    ImageButton nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_huesped_personality_test);

        web16Personatilies = findViewById(R.id.web16Personalites);
        nextButton = findViewById(R.id.register_personality_next);

        web16Personatilies.getSettings().setJavaScriptEnabled(true);
        web16Personatilies.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                System.out.println("when you click on any interlink on webview that time you got url :-" + url);
                StringBuilder sb = new StringBuilder();
                int start = 35;
                for(int i=url.length()-4; i<url.length(); i++){
                    sb.append(url.charAt(i));
                }

                hasResult = true;
                personality = sb.toString().toUpperCase();

                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        web16Personatilies.loadUrl("https://www.16personalities.com/es/test-de-personalidad");

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getIntent());
                i.setComponent(new ComponentName(reg_huesped_personality_test.this, reg_verifying_message.class));
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                if(hasResult){
                    Toast.makeText(reg_huesped_personality_test.this, "Personalidad: " + personality, Toast.LENGTH_LONG).show();
                    i.putExtra("personality", personality);
                }else{
                    Toast.makeText(reg_huesped_personality_test.this, "MODO TEST: Generando Resultado Aleatorio\nESTP", Toast.LENGTH_LONG).show();
                    i.putExtra("personality", "ESTP");
                }

                startActivity(i);
            }
        });
    }
}
