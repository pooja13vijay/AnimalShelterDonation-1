package kiriel.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccountOverview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_overview);
    }

    public void sendMessage_Button1(View view){

        final Button button = (Button)findViewById(R.id.button16);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountOverview.this, About.class));
            }
        });
    }

    public void sendMessage_Button2(View view){

        final Button button = (Button)findViewById(R.id.button18);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountOverview.this, UserAccount.class));
            }
        });
    }

    public void sendMessage_Button3(View view){

        final Button button = (Button)findViewById(R.id.button19);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountOverview.this, DonateMoney.class));
            }
        });
    }

    public void sendMessage_Button4(View view){

        final Button button = (Button)findViewById(R.id.button20);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountOverview.this, AnimalShelter.class));
            }
        });
    }

    public void sendMessage_Button5(View view){

        final Button button = (Button)findViewById(R.id.button21);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountOverview.this, Feedback.class));
            }
        });
    }

    public void sendMessage_Logout(View view){

        final Button button = (Button)findViewById(R.id.button23);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountOverview.this, MainActivity.class));
            }
        });
    }

}
