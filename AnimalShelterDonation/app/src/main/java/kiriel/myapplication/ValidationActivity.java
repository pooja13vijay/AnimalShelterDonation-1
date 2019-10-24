package kiriel.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import static kiriel.myapplication.CardValidation.CheckLuhn;

public class ValidationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation);
    }

    public void ThankYou(View view){
        EditText first_name = (EditText)findViewById(R.id.firstName);
        EditText last_name = (EditText)findViewById(R.id.lastName);
        EditText card_number = (EditText)findViewById(R.id.cardNum);
        EditText ex_month = (EditText)findViewById(R.id.exMon);
        EditText ex_year = (EditText)findViewById(R.id.exY);
        EditText security_code = (EditText)findViewById(R.id.secCode);

        String f = first_name.getText().toString();
        String l = last_name.getText().toString();
        String c = card_number.getText().toString();
        String em = ex_month.getText().toString();
        String ey = ex_year.getText().toString();
        String sc = security_code.getText().toString();

        if(f.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please Enter Your First Name" ,Toast.LENGTH_SHORT).show();
        }else
        if(l.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please Enter Your Last Name" ,Toast.LENGTH_SHORT).show();
        }else
        if(c.trim().length() < 16 || em.trim().length() < 2 || ey.trim().length() < 2 || sc.trim().length() < 3
                || (((ey.charAt(0) <= '1' && ey.charAt(1) <= '7') || (ey.charAt(0) == '0' && ey.charAt(1) >= '8'))
                || ((em.charAt(0) =='0' && em.charAt(1) =='0') || (em.charAt(0) >'1' ) || (em.charAt(0) == '1' && em.charAt(1) > '2')))){
            Toast.makeText(getApplicationContext(),"Please Enter Valid Visa Card Information" ,Toast.LENGTH_SHORT).show();
        }else
        if(f.isEmpty() || l.isEmpty() || c.isEmpty() || em.isEmpty() || ey.isEmpty() || sc.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please Fill In All The Information" ,Toast.LENGTH_SHORT).show();
        }else
        if(CheckLuhn(c) == false){
            Toast.makeText(getApplicationContext(),"Please Re-Enter The Correct Card Number" ,Toast.LENGTH_SHORT).show();
        }else
        {
            Intent intent = new Intent(ValidationActivity.this, ThankYouActivity.class);
            startActivity(intent);
        }
    }

}


