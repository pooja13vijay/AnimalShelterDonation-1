package kiriel.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AdoptedAnimal2 extends AppCompatActivity {

    AdoptionHelper myDb;
    TextView name, age, gender, weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopted_animal2);
        myDb = new AdoptionHelper(this);

        name = (TextView)findViewById(R.id.textView6);
        age = (TextView)findViewById(R.id.textView9);
        gender = (TextView)findViewById(R.id.textView7);
        weight = (TextView)findViewById(R.id.textView10);
        height = (TextView)findViewById(R.id.textView11);

        String animalName = name.getText().toString();
        String animalAge = age.getText().toString();
        String animalGender = gender.getText().toString();
        String animalWeight = weight.getText().toString();
        String animalHeight = height.getText().toString();

        myDb.addAnimal(animalName, animalAge, animalGender, animalWeight, animalHeight);
    }
}
