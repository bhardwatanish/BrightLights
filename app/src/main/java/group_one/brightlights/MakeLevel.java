package group_one.brightlights;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

public class MakeLevel extends AppCompatActivity implements View.OnClickListener {
    private Button[][] buttons = new Button[3][3];
    private TextView textViewPlayer1;
    private int[][] color= new int[3][3];
    private int[][] clicked=new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_level);
        textViewPlayer1 = findViewById(R.id.text1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
                setarray(i,j);
                setboardcolor(i,j);
            }
        }
        Button reset;
        reset=findViewById(R.id.reset);
        reset.setOnClickListener(this);
        Button ss;
        ss=findViewById(R.id.ss);
        ss.setOnClickListener(this);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                clicked[i][j]=0;
            }
        }
        clicked[1][1]=1;

    }

    @Override
    public void onClick(View v) {
        //if (((Button) v).getText().toString().equals("x")){
        switch(v.getId()){
            case R.id.button_00:
                swap(0,0);
                break;
            case R.id.button_01:
                swap(0,1);
                break;
            case R.id.button_02:
                swap(0,2);
                break;
            case R.id.button_10:
                swap(1,0);
                break;
            case R.id.button_12:
                swap(1,2);
                break;
            case R.id.button_11:
                swap(1,1);
                break;
            case R.id.button_20:
                swap(2,0);
                break;
            case R.id.button_21:
                swap(2,1);
                break;
            case R.id.button_22:
                swap(2,2);
                break;
            case R.id.reset:
                resetarray();
            case R.id.ss:
                submitLevel();
        }

    }
    private void setboardcolor(int i,int j){
        // Random rand = new Random();
        // color[i][j]= rand.nextInt(2) + 0;
        if(color[i][j]==1) {
            buttons[i][j].setBackgroundColor(Color.parseColor("red"));
            buttons[i][j].setTextColor(Color.parseColor("red"));
            buttons[i][j].setText("x");

        }
        else{
            buttons[i][j].setBackgroundColor(Color.parseColor("#a4c639"));
            buttons[i][j].setTextColor(Color.parseColor("#a4c639"));
            buttons[i][j].setText("0");
        }

    }
    private void setarray(int i,int j){
//        Random rand = new Random();
        //color[i][j]= rand.nextInt(2) + 0;
        color[i][j]=1;
        setboardcolor(i,j);
    }
    private void resetarray(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                setarray(i,j);
            }
        }
    }

    private void swap(int i,int j){
        if(i-1>=0){
            if (color[i-1][j]==1){
                color[i-1][j]=0;
            }
            else{
                color[i-1][j]=1;
            }
        }
        if(i+1<=2){
            if (color[i+1][j]==1){
                color[i+1][j]=0;
            }
            else{
                color[i+1][j]=1;
            }
        }
        if(j-1>=0){
            if (color[i][j-1]==1){
                color[i][j-1]=0;
            }
            else{
                color[i][j-1]=1;
            }
        }
        if(j+1<=2){
            if (color[i][j+1]==1){
                color[i][j+1]=0;
            }
            else{
                color[i][j+1]=1;
            }
        }
        if (color[i][j]==1){
            color[i][j]=0;
        }
        else{
            color[i][j]=1;
        }

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {

                setboardcolor(k,l);
            }
        }

    }

    private static class levelSubmission {
        int[][] color;
        String username;
    }
    protected void submitLevel(){
        levelSubmission output = new levelSubmission();
        output.color = color;
        EditText name = findViewById(R.id.username);
        output.username = name.getText().toString();
        System.out.print("\n\n10000\n\n\n\n\n\n\n\n\n");
        System.out.print(output.username);
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                System.out.print(output.color[i][j]);
            }
        }
//        return output;
        return;
    }

}

