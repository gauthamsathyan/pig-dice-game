package com.example.gauthams16125;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.LinkedList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final Random RANDOM = new Random();
    public static LinkedList<String> WordList = new LinkedList<>();

    /* renamed from: l */
    public static int f41l = 0;
    private ImageView imageView1;
    private ImageView imageView2;
    private int player = 1;

    /* renamed from: s1 */
    private TextView f42s1;

    /* renamed from: s2 */
    private TextView f43s2;

    /* renamed from: s3 */
    private TextView f44s3;
    private int score = 0;
    private int score1 = 0;
    private int score2 = 0;

    /* renamed from: st */
    private TextView f45st;
    String str = "https://youtu.be/gMFMpC3mC_0";
    private int turns = 0;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0370R.layout.activity);
        this.f42s1 = (TextView) findViewById(C0370R.C0372id.textView2);
        this.f43s2 = (TextView) findViewById(C0370R.C0372id.textView3);
        this.f44s3 = (TextView) findViewById(C0370R.C0372id.textView5);
        this.f45st = (TextView) findViewById(C0370R.C0372id.f50tt);
        this.f42s1.setBackgroundColor(-16711936);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("roundCount", this.score);
        outState.putInt("player1Points", this.score1);
        outState.putInt("player2Points", this.score2);
        outState.putInt("playerTurn", this.turns);
        outState.putInt("GameNumber", f41l);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.score = savedInstanceState.getInt("roundCount");
        this.score1 = savedInstanceState.getInt("player1Points");
        this.score2 = savedInstanceState.getInt("player2Points");
        this.turns = savedInstanceState.getInt("playerTurn");
        f41l = savedInstanceState.getInt("GameNumber");
        TextView textView = this.f45st;
        textView.setText("Total Turns: " + this.turns);
        TextView textView2 = this.f44s3;
        textView2.setText("Score: " + this.score);
        TextView textView3 = this.f42s1;
        textView3.setText("Player1: " + this.score1);
        TextView textView4 = this.f43s2;
        textView4.setText("Player2: " + this.score2);
    }

    public void openWebsite(String url) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0370R.C0374menu.my_options_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case C0370R.C0372id.Instructions /*2131230724*/:
                openWebsite(this.str);
                return true;
            case C0370R.C0372id.NewGame /*2131230727*/:
                newgame();
                return true;
            case C0370R.C0372id.history /*2131230805*/:
                startActivity(new Intent(this, History.class));
                return true;
            case C0370R.C0372id.resume /*2131230857*/:
                startActivity(new Intent(this, Main2Activity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onclick(View view) {
        this.imageView1 = (ImageView) findViewById(C0370R.C0372id.imageView1);
        this.imageView2 = (ImageView) findViewById(C0370R.C0372id.imageView2);
        int value1 = randomDiceValue();
        int value2 = randomDiceValue();
        int res1 = getResources().getIdentifier("dice" + value1, "drawable", BuildConfig.APPLICATION_ID);
        int res2 = getResources().getIdentifier("dice" + value2, "drawable", BuildConfig.APPLICATION_ID);
        this.imageView1.setImageResource(res1);
        this.imageView2.setImageResource(res2);
        if (this.player == 1) {
            if (value1 == 1 && value2 == 1) {
                this.score = 0;
                this.f44s3.setText("Score: " + this.score);
                this.score1 = 0;
                this.player = 2;
                this.f42s1.setBackgroundColor(-1);
                this.f43s2.setBackgroundColor(-16711936);
                this.f42s1.setText("Player1: 0");
                this.turns++;
                this.f45st.setText("Total Turns: " + this.turns);
            } else if (value1 == 1 || value2 == 1) {
                this.score = 0;
                this.f44s3.setText("Score: " + this.score);
                this.player = 2;
                this.f42s1.setBackgroundColor(-1);
                this.f43s2.setBackgroundColor(-16711936);
                this.turns++;
                this.f45st.setText("Total Turns: " + this.turns);
            } else {
                this.score = this.score + value1 + value2;
                this.f44s3.setText("Score: " + this.score);
            }
        } else if (value1 == 1 && value2 == 1) {
            this.score = 0;
            this.f44s3.setText("Score: " + this.score);
            this.player = 1;
            this.score2 = 0;
            this.f43s2.setBackgroundColor(-1);
            this.f42s1.setBackgroundColor(-16711936);
            this.f43s2.setText("Player2: 0");
            this.turns++;
            this.f45st.setText("Total Turns: " + this.turns);
        } else if (value1 == 1 || value2 == 1) {
            this.score = 0;
            this.f44s3.setText("Score: " + this.score);
            this.player = 1;
            this.f43s2.setBackgroundColor(-1);
            this.f42s1.setBackgroundColor(-16711936);
            this.turns++;
            this.f45st.setText("Total Turns: " + this.turns);
        } else {
            this.score = this.score + value1 + value2;
            this.f44s3.setText("Score: " + this.score);
        }
        if (this.score1 + this.score >= 100 && this.score2 < 100 && this.player == 1) {
            Toast.makeText(this, "Player1 Wins!", 1).show();
            this.player = 1;
            f41l++;
            WordList.add("GAME - " + f41l + "\n\n\nWinner: Player 1\n\n\nPlayer 1 Score: " + (this.score1 + this.score) + "\n\n\nPlayer 2 Score: " + this.score2 + "\n\n\nTotal Number of Turns: " + this.turns);
            this.score1 = 0;
            this.score2 = 0;
            this.f42s1.setText("Player1: 0");
            this.f43s2.setText("Player2: 0");
            this.f44s3.setText("Score: 0");
            this.turns = 0;
            newgame();
        } else if (this.score2 + this.score >= 100 && this.score1 < 100 && this.player == 2) {
            Toast.makeText(this, "Player2 Wins", 1).show();
            f41l++;
            WordList.add("GAME - " + f41l + "\n\n\nWinner: Player 2\n\n\nPlayer 1 Score: " + this.score1 + "\n\n\nPlayer 2 Score: " + (this.score2 + this.score) + "\n\n\nTotal Number of Turns: " + this.turns);
            this.player = 1;
            this.score1 = 0;
            this.score2 = 0;
            this.f42s1.setText("Player1: 0");
            this.f43s2.setText("Player2: 0");
            this.f44s3.setText("Score: 0");
            this.turns = 0;
            newgame();
        }
    }

    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;
    }

    public void hold(View view) {
        this.turns++;
        this.f45st.setText("Total Turns: " + this.turns);
        if (this.player == 1) {
            this.score1 += this.score;
            this.f42s1.setText("Player1: " + this.score1);
            this.player = 2;
            this.score = 0;
            this.f44s3.setText("Score: 0");
            this.f42s1.setBackgroundColor(-1);
            this.f43s2.setBackgroundColor(-16711936);
            return;
        }
        this.score2 += this.score;
        this.f43s2.setText("Player2: " + this.score2);
        this.player = 1;
        this.score = 0;
        this.f44s3.setText("Score: 0");
        this.f43s2.setBackgroundColor(-1);
        this.f42s1.setBackgroundColor(-16711936);
    }

    public void newgame() {
        this.score1 = 0;
        this.score2 = 0;
        this.score = 0;
        this.turns = 0;
        this.player = 1;
        TextView textView = this.f45st;
        textView.setText("Total Turns: " + this.turns);
        this.f44s3.setText("Score: 0");
        this.f42s1.setText("Player1: 0");
        this.f43s2.setText("Player2: 0");
        this.f43s2.setBackgroundColor(-1);
        this.f42s1.setBackgroundColor(-16711936);
    }
}
