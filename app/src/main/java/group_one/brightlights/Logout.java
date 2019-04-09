
package group_one.brightlights;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class  Logout  extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        Button remain, byee;
        remain = (Button) findViewById(R.id.remain);
        byee = (Button) findViewById(R.id.byee);

        remain.setOnClickListener(this);
        byee.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.remain:
                Intent i = new Intent(getApplicationContext(), group_one.brightlights.LevelMenuClass.class);
                startActivity(i);
                break;
            case R.id.byee:
                Intent j = new Intent(getApplicationContext(), group_one.brightlights.Byee.class);
                startActivity(j);
                break;

        }
    }
}