package josephvarghese.roundmelon.dell.bharathamone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Schedule extends AppCompatActivity {

    private Button btn19;
    private Button btn20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        btn19 = (Button)findViewById(R.id.btn19);
        btn20 = (Button)findViewById(R.id.btn20);




        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dayOne = new Intent(Schedule.this,DayOne.class);
                startActivity(dayOne);
            }
        });





    }
}
