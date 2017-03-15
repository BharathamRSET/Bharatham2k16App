package josephvarghese.roundmelon.dell.bharathamone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Animation an1= AnimationUtils.loadAnimation(getBaseContext(),R.anim.idle);
        final Animation an2= AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);
        final RelativeLayout rl=(RelativeLayout)findViewById(R.id.rl);
        rl.startAnimation(an1);
        an1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {



                    rl.startAnimation(an2);
                    finish();

                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                }


            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
