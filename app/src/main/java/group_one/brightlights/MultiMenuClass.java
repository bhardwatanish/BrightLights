package group_one.brightlights;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MultiMenuClass extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_menu);
        Button make_level, show_levels, Main_menu;
        make_level =(Button) findViewById(R.id.make_level);
        show_levels = (Button) findViewById(R.id.show_levels);
        Main_menu = (Button) findViewById(R.id.main_menu);
        make_level.setOnClickListener(this);
        show_levels.setOnClickListener(this);
        Main_menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.make_level:
                Intent l=new Intent(getApplicationContext(), group_one.brightlights.MakeLevelMenuClass.class);
                startActivity(l);
                break;
            case R.id.show_levels:
                Intent m=new Intent(getApplicationContext(), group_one.brightlights.MultiPlayerActivity.class);
                startActivity(m);
                break;
            case R.id.main_menu:
                Intent k =new Intent(getApplicationContext(), group_one.brightlights.LevelMenuClass.class);
                startActivity(k);
                break;
        }
    }
}
