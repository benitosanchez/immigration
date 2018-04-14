package ai.immigration.immigration.mainScreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import ai.immigration.immigration.R;
import ai.immigration.immigration.questionsScreen.QuestionsActivity;

public class MainActivity extends AppCompatActivity {

    ImageButton mDacaRenewal, mTravelVisa, mGreenCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreenCard = (ImageButton) findViewById(R.id.green_card);
        mGreenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuestionsActivity.class);
                startActivity(intent);
            }
        });
    }
}
