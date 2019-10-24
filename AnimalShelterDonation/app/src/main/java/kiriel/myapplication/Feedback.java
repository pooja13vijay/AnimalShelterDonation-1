package kiriel.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
    }

    public void validData(View view){
        EditText name = (EditText)findViewById(R.id.editText);
        EditText email = (EditText)findViewById(R.id.editText2);
        EditText message = (EditText)findViewById(R.id.editText3);
        RadioGroup radio1 = (RadioGroup)findViewById(R.id.radioGroup);

        String n = name.getText().toString();
        String e = email.getText().toString().trim();
        String m = message.getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (radio1.getCheckedRadioButtonId() == -1 || n.isEmpty() || e.isEmpty() || m.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please Fill In All The Information!",
                    Toast.LENGTH_SHORT).show();
        }else
        if(!e.matches(emailPattern)){
            Toast.makeText(getApplicationContext(), "Please Enter Valid Email Address!",
                    Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(this, InformationReceived.class );
            startActivity(intent);
        }
    }
}
