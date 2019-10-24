package kiriel.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AnimalAdoption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_adoption);
    }

    public void sendMessage_BunnyButton(View view) {

        final Button bunnyButton = (Button) findViewById(R.id.button13);

        bunnyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AnimalAdoption.this, ShelterCampaign.class));
            }
        });
    }

    public void sendMessage_KittenButton(View view) {

        final Button kittenButton = (Button) findViewById(R.id.button15);

        kittenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AnimalAdoption.this, ShelterCampaign2.class));
            }
        });
    }

    public void sendMessage_PuppyButton(View view) {

        final Button puppyButton = (Button) findViewById(R.id.button14);

        puppyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AnimalAdoption.this, ShelterCampaign1.class));
            }
        });
    }

}
