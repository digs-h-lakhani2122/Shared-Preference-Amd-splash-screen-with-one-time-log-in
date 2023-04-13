package coatocl.exaatocl.splash_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Animation topanim,bottomanim;
    private static int SPLASH_SCREEN=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView=findViewById(R.id.imageView);
        textView=findViewById(R.id.textView);
//        for animation
        topanim= AnimationUtils.loadAnimation(this,R.anim.top);
        bottomanim=AnimationUtils.loadAnimation(this,R.anim.bottom);
        imageView.setAnimation(topanim);
        textView.setAnimation(bottomanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences=getSharedPreferences(screen2.PREF_NAME,MODE_PRIVATE);
                boolean hasLoggedIn=sharedPreferences.getBoolean("hasLoggedIn",false);

                if(hasLoggedIn)
                {
                    Intent intent=new Intent(MainActivity.this,screen3.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                Intent intent2=new Intent(MainActivity.this,screen2.class);
                startActivity(intent2);
                finish();
                }
            }

        },SPLASH_SCREEN);


    }
}
