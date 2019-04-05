package group_one.brightlights;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import group_one.brightlights.GamesAdapter;
import group_one.brightlights.R;

public class MultiPlayerActivity extends AppCompatActivity {

    List<String> Games = Arrays.asList("16lights","k6986774","kfkgmm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mp_recycler_view);

        RecyclerView rvGames = (RecyclerView) findViewById(R.id.rvGames);

        GamesAdapter adapter = new GamesAdapter(Games);

        rvGames.setAdapter(adapter);
        rvGames.setLayoutManager(new LinearLayoutManager(this));
    }


}
