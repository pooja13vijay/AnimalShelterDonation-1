package kiriel.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText name, password, email, contact, age;
    RadioGroup rbtg;
    RadioButton male, female;
    Button rgbt;
    TextView login;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupViews();
        myDb = new DatabaseHelper(this);
    }

    public void userRegister(View view) {
        myDb.getWritableDatabase();
        Boolean verify = validate();
        Boolean pass = plength();
        String emailType = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (verify == true) {
            String Name = name.getText().toString();
            String Password = password.getText().toString();
            String Email = email.getText().toString();
            String Contact = contact.getText().toString();
            String Age = age.getText().toString();
            int gcheck = rbtg.getCheckedRadioButtonId();
            RadioButton rb = (RadioButton)findViewById(gcheck);
            String gender = rb.getText().toString();

            if (Email.matches(emailType)) {
                Boolean validEmail = myDb.validEmail(Email);
                if (validEmail == true) {
                    if (pass == true) {
                        myDb.addUser(Name, Password, Email, Contact, Age, gender);
                        Toast.makeText(getApplicationContext(), "Registered Successfully!", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Email Already Exists, Please Try A Different Email!", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void perform_action(View view) {
        login = (TextView) findViewById(R.id.rlogin);
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }

    private void setupViews() {
        name = (EditText) findViewById(R.id.edName);
        password = (EditText) findViewById(R.id.edPassword);
        email = (EditText) findViewById(R.id.edEmail);
        contact = (EditText) findViewById(R.id.edPhone);
        age = (EditText) findViewById(R.id.edAge);
        rbtg = (RadioGroup) findViewById(R.id.rbtgroup);
        male = (RadioButton) findViewById(R.id.rmale);
        female = (RadioButton) findViewById(R.id.rfemale);
        rgbt = (Button) findViewById(R.id.rgbt);
        login = (TextView) findViewById(R.id.rlogin);
    }

    private Boolean validate() {
        Boolean check = false;
        String n = name.getText().toString();
        String p = password.getText().toString();
        String e = email.getText().toString();
        String c = contact.getText().toString();
        String a = age.getText().toString();

        if (n.isEmpty() || p.isEmpty() || e.isEmpty() || c.isEmpty() || a.isEmpty() || rbtg.getCheckedRadioButtonId()==-1) {
            Toast.makeText(this, "Please Fill In All The Details", Toast.LENGTH_SHORT).show();
        } else {
            check = true;
        }
        return check;
    }

    private Boolean plength(){
        Boolean check = false;
        String p = password.getText().toString();

        if(p.length()<7){
            Toast.makeText(getApplicationContext(),"Password Must Contain At Least 8 Characters!",Toast.LENGTH_LONG).show();
        } else {
            check=true;
        }
        return check;
    }

}

