package group_one.brightlights;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


public  class GamesAdapter extends
        RecyclerView.Adapter<GamesAdapter.ViewHolder> {

    private List<String> mGameIdList;

    public GamesAdapter(List<String> GameIds)
    {
        mGameIdList = GameIds;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView gameIdTextView;
        public Button playButton;

        public ViewHolder(View itemView) {
            super(itemView);

            gameIdTextView = (TextView) itemView.findViewById(R.id.game_id);
            playButton = (Button) itemView.findViewById(R.id.play_button);

            playButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView gameIdTextView = (TextView) ((View)v.getParent()).findViewById(R.id.game_id);
                    String gameId = gameIdTextView.getText().toString();

                    Intent l=new Intent(v.getContext().getApplicationContext(), group_one.brightlights.NineLightModeClass.class).putExtra("level",0).putExtra("gameId", gameId);
                    v.getContext().startActivity(l);
                }
            });
        }
    }

    @Override
    public GamesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View gameView = inflater.inflate(R.layout.game_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(gameView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(GamesAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        String gameId = mGameIdList.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.gameIdTextView;
        textView.setText(gameId);
        Button button = viewHolder.playButton;
        //button.setText(gameId.isOnline() ? "Message" : "Offline");
        //button.setEnabled(gameId.isOnline());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mGameIdList.size();
    }
}



