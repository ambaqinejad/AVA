package ir.ambaqi.musicevent.ava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity implements ComponentInitialize {

    EditText nameSignUp, familySignUp, stnoSignUp, nationalIdSignUp;
    EditText majorSignUp, entryYearSignUp, averageSignUp;
    Button registerSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
    }

    @Override
    public void init() {
        nameSignUp = findViewById(R.id.sign_up_name);
        familySignUp = findViewById(R.id.sign_up_family);
        stnoSignUp = findViewById(R.id.sign_up_stno);
        nationalIdSignUp = findViewById(R.id.sign_up_national_id);
        majorSignUp = findViewById(R.id.sign_up_major);
        entryYearSignUp = findViewById(R.id.sign_up_entry_year);
        averageSignUp = findViewById(R.id.sign_up_average);
        registerSignUp = findViewById(R.id.register_sign_up);
    }
}
