package coatocl.exaatocl.splash_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class screen2 extends AppCompatActivity {

    EditText editText,editText2;
    Button button;
    public  static String PREF_NAME="shared";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("shared",MODE_PRIVATE);

                SharedPreferences.Editor edit=sharedPreferences.edit();

                edit.putBoolean("hasLoggedIn",true);
                edit.commit();

                Intent intent3=new Intent(screen2.this,screen3.class);
                startActivity(intent3);
                finish();
            }
        });

    }

}
