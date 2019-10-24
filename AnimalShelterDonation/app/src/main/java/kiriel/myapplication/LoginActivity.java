package kiriel.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button login;
    TextView register;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupViews();
        myDb = new DatabaseHelper(this);

    }

    public void userLogin(View view) {
        myDb.getWritableDatabase();
        Boolean valid = validate();
        if (valid == true) {
            String Email = email.getText().toString();
            String Password = password.getText().toString();
            Boolean veri = myDb.validLogin(Email, Password);

            if (veri == true) {
                Toast.makeText(getApplicationContext(), "Login Successfully!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(LoginActivity.this, AccountOverview.class));
            } else {
                Toast.makeText(getApplicationContext(), "Invalid Login!", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void perform_action(View view){
        register = (TextView)findViewById(R.id.signup);
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    private void setupViews(){
        email= (EditText) findViewById(R.id.etemail);
        password = (EditText) findViewById(R.id.etpassword);
        login = (Button) findViewById(R.id.loginbt);
        register = (TextView) findViewById(R.id.signup);
    }

    private Boolean validate(){
        Boolean check = false;
        String p = password.getText().toString();
        String e = email.getText().toString();

        if(p.isEmpty() && e.isEmpty()){
            Toast.makeText(this, "Please Fill In All The Details", Toast.LENGTH_SHORT).show();
        } else {
            check = true;
        }
        return check;
    }

}


