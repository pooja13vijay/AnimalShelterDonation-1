package kiriel.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserAccount extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editContact, editAge;
    Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        myDb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editName);
        editContact = (EditText)findViewById(R.id.editContact);
        editAge = (EditText)findViewById(R.id.editAge);
        updateButton = (Button)findViewById(R.id.updateButton);
    }

    public void UpdateData(View view) {
        updateButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String n = editName.getText().toString();
                        String c = editContact.getText().toString();
                        String a = editAge.getText().toString();

                        boolean isUpdate = myDb.updateData(editName.getText().toString(),
                               editContact.getText().toString(),editAge.getText().toString());
                        if(isUpdate == true && !n.isEmpty() && !c.isEmpty() && !a.isEmpty())
                            Toast.makeText(UserAccount.this,"Your Data Has Been Updated",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(UserAccount.this,"Error, Data Cannot Be Updated!",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}

