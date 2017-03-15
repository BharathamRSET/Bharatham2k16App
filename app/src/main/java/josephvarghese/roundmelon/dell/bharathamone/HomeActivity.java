package josephvarghese.roundmelon.dell.bharathamone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    Animation fade_in, fade_out;
    ViewFlipper viewFlipper;
    private ImageButton imageButton;
    ImageView mImageView;
    String url = "http://bharathamserver.hol.es/PhotoUploadWithText/getLiked.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mImageView = (ImageView) findViewById(R.id.myImage);





        viewFlipper = (ViewFlipper) this.findViewById(R.id.bckgrndViewFlipper1);
        fade_in = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);
        fade_out = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right);
        viewFlipper.setInAnimation(fade_in);
        viewFlipper.setOutAnimation(fade_out);
//sets auto flipping
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(2500);
        viewFlipper.startFlipping();
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Light.ttf");
        TextView t = (TextView) findViewById(R.id.textView7);
        t.setTypeface(type);
        t=(TextView) findViewById(R.id.textview8);
        t.setTypeface(type);

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent videoIntent = new Intent(HomeActivity.this,Youtube.class);
                startActivity(videoIntent);
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fabIntent = new Intent(HomeActivity.this,UploadActivity.class);
                startActivity(fabIntent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Retrieves an image specified by the URL, displays it in the UI.
        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                        mImageView.setImageBitmap(bitmap);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {

                    }
                });
// Access the RequestQueue through your singleton class.
        AppController.getInstance().addToRequestQueue(request);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            Intent aboutIntent = new Intent(HomeActivity.this,About.class);
            startActivity(aboutIntent);
        }else if(id == R.id.credits){
            Intent creditsIntent = new Intent(HomeActivity.this,Credits.class);
            startActivity(creditsIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
           /* Intent homeIntent = new Intent(HomeActivity.this,HomeActivity.class);
            startActivity(homeIntent);*/
        } else if (id == R.id.nav_site) {
            Intent siteIntent = new Intent(HomeActivity.this,Site.class);
            startActivity(siteIntent);
        } else if (id == R.id.nav_update) {
            Intent updateIntent = new Intent(HomeActivity.this,Updates.class);
            startActivity(updateIntent);
        } else if (id == R.id.nav_schedule) {
            Intent scheduleIntent = new Intent(HomeActivity.this,Schedule.class);
            startActivity(scheduleIntent);
        } else if (id == R.id.nav_chart) {
            Intent chartIntent = new Intent(HomeActivity.this,Chart.class);
            startActivity(chartIntent);
        }else if (id == R.id.nav_selfie) {
            Intent selfieIntent = new Intent(HomeActivity.this,UploadActivity.class);
            startActivity(selfieIntent);
        } else if (id == R.id.nav_selfieShow) {
            Intent selfieShow = new Intent(HomeActivity.this,SelfieGallery.class);
            startActivity(selfieShow);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
