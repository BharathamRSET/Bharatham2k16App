package josephvarghese.roundmelon.dell.bharathamone;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;



public class Updates extends AppCompatActivity {

        private String mFIleContents;

        private ListView listApps;

        private int downloadRespone;


        boolean doubleBackToExit = false;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_updates);



            TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
            tabLayout.addTab(tabLayout.newTab().setText("ALL UPDATES"));
            tabLayout.addTab(tabLayout.newTab().setText("ARYANS"));
            tabLayout.addTab(tabLayout.newTab().setText("MUGHALS"));
            tabLayout.addTab(tabLayout.newTab().setText("RAJPUTS"));
            tabLayout.addTab(tabLayout.newTab().setText("SPARTANS"));
            tabLayout.addTab(tabLayout.newTab().setText("VIKINGS"));
            tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);




            final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
            final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });





        }
//
//        @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//            // Inflate the menu; this adds items to the action bar if it is present.
//            getMenuInflater().inflate(R.menu.menu_main, menu);
//            return true;
//        }

//        @Override
//        public boolean onOptionsItemSelected(MenuItem item) {
//            // Handle action bar item clicks here. The action bar will
//            // automatically handle clicks on the Home/Up button, so long
//            // as you specify a parent activity in AndroidManifest.xml.
//            int id = item.getItemId();
//
//            //noinspection SimplifiableIfStatement
//            if (id == R.id.action_settings) {
//                return true;
//            }
//
//            return super.onOptionsItemSelected(item);
//        }

//        private class DownloadData extends AsyncTask<String,Void,String> {
//
//
//
//            @Override
//            protected String doInBackground(String... params) {
//                mFIleContents = downloadXmlFile(params[0]);
//                if (mFIleContents == null) {
//                    Log.d("DownloadData", "Error downloading");
//                }
//
//                return mFIleContents;
//
//            }
//
//
//            @Override
//            protected void onPostExecute(String result) {
//                super.onPostExecute(result);
//                Log.d("DownloadData","Result was:" + result);
//
//            }
//
//
//
//            private String downloadXmlFile(String urlPath) {
//                StringBuilder tempBuffer = new StringBuilder();
//                int response;
//
//                try {
//                    URL url = new URL(urlPath);
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                    response = connection.getResponseCode();
//                    Log.d("DownloadData", "The response code was" + response);
//                    InputStream is = connection.getInputStream();
//                    InputStreamReader isr = new InputStreamReader(is);
//
//
//
//
//                    int charRead;
//                    char[] inputBuffer = new char[500];
//                    while (true) {
//                        charRead = isr.read(inputBuffer);
//                        if(charRead <= 0) {
//                            break;}
//                        tempBuffer.append(String.copyValueOf(inputBuffer,0,charRead));
//
//                    }
//                    return tempBuffer.toString();
//
//
//                }catch(IOException e){
//                    Log.d("DownloadData", "IO Exception reading data:" + e.getMessage());
//                    e.printStackTrace();
//                }catch(SecurityException e){
//                    Log.d("DownloadData","Security exception needs permisiion?" + e.getMessage());
//
//                }
//
//                return null;
//
//
//            }
//        }
//
//
//        @Override
//        public void onBackPressed() {
//            if (doubleBackToExit) {
//                super.onBackPressed();
//                return;
//            }
//
//            this.doubleBackToExit = true;
//            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
//
//
//        }
//

    }






