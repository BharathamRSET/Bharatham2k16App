package josephvarghese.roundmelon.dell.bharathamone;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class Chart extends AppCompatActivity {

    float oneChart;
    float twoChart;
    float threeChart;
    float fourChart;
    float fiveChart;
    String oneCharts;
    String twoCharts;
    String threeCharts;
    String fourCharts;
    String fiveCharts;
    BarChart chart;

    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        Firebase.setAndroidContext(this);
        pDialog = new ProgressDialog(this);



        //Creating firebase object
        Firebase ref =new Firebase(ConfigChart.FIREBASE_URL);

        //Getting values to store
        String aryans = "0";
        String mughals = "0";
        String rajputs = "0";
        String spartans = "0";
        String vikings = "0";

        //Creating Person object
        House house = new House();

        //Adding values
        house.setAryans(aryans);
        house.setMughals(mughals);
        house.setRajputs(rajputs);
        house.setSpartans(spartans);
        house.setVikings(vikings);


        //Storing values to firebase
//        ref.child("House").setValue(house);
//          ref.child("House");

        pDialog.setMessage("Updating Scores...");
        pDialog.show();







        //Value event listener for realtime data update
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.d("Snapshot",snapshot.getChildrenCount()+"");
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    //Getting the data from snapshot
                    House house = postSnapshot.getValue(House.class);

                    //Adding it to a string
//                    String string = "Name: "+person.getName()+"\nAddress: "+person.getAddress()+"\n\n";
                    Log.d("Sna",house.getAll());
                    oneCharts = house.getAryans();
                    twoCharts = house.getMughals();
                    threeCharts = house.getRajputs();
                    fourCharts = house.getSpartans();
                    fiveCharts = house.getVikings();


                    oneChart = Float.parseFloat(oneCharts);
                    twoChart = Float.parseFloat(twoCharts);
                    threeChart = Float.parseFloat(threeCharts);
                    fourChart = Float.parseFloat(fourCharts);
                    fiveChart = Float.parseFloat(fiveCharts);

                    if(pDialog.isShowing())
                        pDialog.dismiss();
                    BarData data = new BarData(getXAxisValues(), getDataSet());
                    chart.setData(data);
                    chart.setDescription("");
                    chart.animateY(2000);
                    chart.invalidate();

                    //Displaying it on textview
//                    textViewPersons.setText(string);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());


            }
        });


        chart = (BarChart) findViewById(R.id.chart);

        BarData data = new BarData(getXAxisValues(), getDataSet());
        chart.setData(data);
        chart.setDescription("");
        chart.animateY(2000);
        chart.invalidate();


    }






    private ArrayList<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(oneChart, 0);
        valueSet1.add(v1e1);


        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
        BarEntry v2e1 = new BarEntry(twoChart, 0);
        valueSet2.add(v2e1);

        ArrayList<BarEntry> valueSet3 = new ArrayList<>();
        BarEntry v3e1 = new BarEntry(threeChart, 0);
        valueSet3.add(v3e1);

        ArrayList<BarEntry> valueSet4 = new ArrayList<>();
        BarEntry v4e1 = new BarEntry(fourChart, 0);
        valueSet4.add(v4e1);

        ArrayList<BarEntry> valueSet5 = new ArrayList<>();
        BarEntry v5e1 = new BarEntry(fiveChart, 0);
        valueSet5.add(v5e1);





        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Aryans");
        barDataSet1.setColor(Color.rgb(128,0,0));
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Mughals");
        barDataSet2.setColor(Color.rgb(255,165,0));
        BarDataSet barDataSet3 = new BarDataSet(valueSet3, "Rajputs");
        barDataSet3.setColor(Color.rgb(255,255,0));
        BarDataSet barDataSet4 = new BarDataSet(valueSet4, "Spartans");
        barDataSet4.setColor(Color.rgb(255,0,255));
        BarDataSet barDataSet5 = new BarDataSet(valueSet5, "Vikings");
        barDataSet5.setColor(Color.rgb(0,191,255));




        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        dataSets.add(barDataSet3);
        dataSets.add(barDataSet4);
        dataSets.add(barDataSet5);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("");

        return xAxis;
    }


}

