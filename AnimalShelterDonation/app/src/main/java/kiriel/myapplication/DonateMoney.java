package kiriel.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DonateMoney extends AppCompatActivity {

    DonationHelper myDb;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_money);
        myDb = new DonationHelper(this);

        radioButton1 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton5);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton);

        String amount1 = radioButton1.getText().toString();
        String amount2 = radioButton2.getText().toString();
        String amount3 = radioButton3.getText().toString();
        String amount4 = radioButton4.getText().toString();

        if(radioButton1.isChecked()){
            myDb.addDonation(amount1);
        }
        else if(radioButton2.isChecked()){
            myDb.addDonation(amount2);
        }
        else if(radioButton3.isChecked()){
            myDb.addDonation(amount3);
        }
        else{
            myDb.addDonation(amount4);
        }
    }

    public void sendMessage(View view){
        final RadioGroup radio1 = (RadioGroup)findViewById(R.id.radioGroup);

        if (radio1.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please Select An Amount!",
                    Toast.LENGTH_SHORT).show();
        }

        else{
            Intent intent = new Intent(DonateMoney.this, ValidationActivity.class);
            startActivity(intent);
        }
    }

}


