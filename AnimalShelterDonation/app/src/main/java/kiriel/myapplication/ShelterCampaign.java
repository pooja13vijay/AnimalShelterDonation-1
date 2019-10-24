package kiriel.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ShelterCampaign extends AppCompatActivity {

    boolean adoptionStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_campaign);
    }

    public void sendMessage_Button1(View view){

        adoptionStatus = true;

        final Button button = (Button)findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adoptionStatus) {
                    startActivity(new Intent(ShelterCampaign.this, AdoptedAnimal.class));
                    adoptionStatus = false;
                }
                else {
                    button.setEnabled(false);
                    Toast.makeText(getApplicationContext(), "This Pet Is No Longer Available For Adoption!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void sendMessage_Button2(View view){

        adoptionStatus = true;

        final Button button = (Button)findViewById(R.id.button8);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adoptionStatus) {
                    startActivity(new Intent(ShelterCampaign.this, AdoptedAnimal1.class));
                    adoptionStatus = false;
                }
                else {
                    button.setEnabled(false);
                    Toast.makeText(getApplicationContext(), "This Pet Is No Longer Available For Adoption!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void sendMessage_Button3(View view){

        adoptionStatus = true;

        final Button button = (Button)findViewById(R.id.button7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adoptionStatus) {
                    startActivity(new Intent(ShelterCampaign.this, AdoptedAnimal2.class));
                    adoptionStatus = false;
                }
                else {
                    button.setEnabled(false);
                    Toast.makeText(getApplicationContext(), "This Pet Is No Longer Available For Adoption!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
