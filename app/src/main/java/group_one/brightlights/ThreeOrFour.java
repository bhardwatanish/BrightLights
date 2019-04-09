package group_one.brightlights;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThreeOrFour extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threefour);
        Button three,four,five;
        three=(Button) findViewById(R.id.three);
        four=(Button) findViewById(R.id.four);
        five=(Button) findViewById(R.id.five);

        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.three:
                Intent i=new Intent(getApplicationContext(), group_one.brightlights.NineLightModeClass.class).putExtra("level",1);
                startActivity(i);
                break;
            case R.id.four:
                Intent j=new Intent(getApplicationContext(), group_one.brightlights.SixteenLightModeClass.class).putExtra("level",1);
                startActivity(j);
                break;
            case R.id.five:
                Intent k=new Intent(getApplicationContext(), group_one.brightlights.TwentyFiveLights.class).putExtra("level",1);
                startActivity(k);
                break;
        }
    }
}
