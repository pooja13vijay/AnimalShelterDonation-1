package kiriel.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AdoptedAnimal4 extends AppCompatActivity {

    AdoptionHelper myDb;
    TextView name, age, gender, weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopted_animal4);
        myDb = new AdoptionHelper(this);

        name = (TextView)findViewById(R.id.textView12);
        age = (TextView)findViewById(R.id.textView13);
        gender = (TextView)findViewById(R.id.textView14);
        weight = (TextView)findViewById(R.id.textView15);
        height = (TextView)findViewById(R.id.textView16);

        String animalName = name.getText().toString();
        String animalAge = age.getText().toString();
        String animalGender = gender.getText().toString();
        String animalWeight = weight.getText().toString();
        String animalHeight = height.getText().toString();

        myDb.addAnimal(animalName, animalAge, animalGender, animalWeight, animalHeight);
    }
}
