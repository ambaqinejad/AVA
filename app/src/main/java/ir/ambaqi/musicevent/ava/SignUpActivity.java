package ir.ambaqi.musicevent.ava;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import data.UrlClass;

public class SignUpActivity extends AppCompatActivity implements ComponentMethod {

    EditText nameSignUp, familySignUp, stnoSignUp, nationalIdSignUp;
    TextView necessaryMessageText;
    EditText majorSignUp, entryYearSignUp, averageSignUp;
    Button registerSignUp;
    ProgressBar signUpProgressBar;
    RequestQueue signUpQueue;
    String SIGN_UP_URL = UrlClass.signUpURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
    }

    @Override
    public void init() {
        nameSignUp = (EditText) findViewById(R.id.sign_up_name);
        familySignUp = (EditText) findViewById(R.id.sign_up_family);
        stnoSignUp = (EditText) findViewById(R.id.sign_up_stno);
        nationalIdSignUp = (EditText) findViewById(R.id.sign_up_national_id);
        necessaryMessageText = (TextView) findViewById(R.id.necessaryMessage);
        majorSignUp = (EditText) findViewById(R.id.sign_up_major);
        entryYearSignUp = (EditText) findViewById(R.id.sign_up_entry_year);
        averageSignUp = (EditText) findViewById(R.id.sign_up_average);
        registerSignUp = (Button) findViewById(R.id.register_sign_up);
        signUpProgressBar = (ProgressBar) findViewById(R.id.progress_bar_sign_up);
        signUpQueue = Volley.newRequestQueue(SignUpActivity.this);
    }

    @Override
    public void setTypeFaceToComponent() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Fonts/Far_Naskh.ttf");
        nameSignUp.setTypeface(typeface);
        familySignUp.setTypeface(typeface);
        stnoSignUp.setTypeface(typeface);
        nationalIdSignUp.setTypeface(typeface);
        necessaryMessageText.setTypeface(typeface);
        majorSignUp.setTypeface(typeface);
        entryYearSignUp.setTypeface(typeface);
        averageSignUp.setTypeface(typeface);
        registerSignUp.setTypeface(typeface);
    }


    public void signUpBtnClick(View view) {
        if (stnoSignUp.getText().toString().equals("") || nationalIdSignUp.getText().toString().equals("")
                || entryYearSignUp.getText().toString().equals("") || averageSignUp.getText().toString().equals("")) {
            Toast.makeText(SignUpActivity.this, "لطفا موارد ستاره دار را وارد نمایید.",
                    Toast.LENGTH_LONG).show();
        } else {
            try {
                if (checkAvg()) {
                    Toast.makeText(SignUpActivity.this, "معدل وارد شده نادرست است.",
                            Toast.LENGTH_LONG).show();
                } else {
                    if (checkEntryYear()) {
                        Toast.makeText(SignUpActivity.this, "سال ورود نادرست است.",
                                Toast.LENGTH_LONG).show();
                    } else {
                        changeVisibility(false);
                        sendSignUpDataToServer();
                    }
                }
            } catch (Exception ex) {
                Toast.makeText(SignUpActivity.this, "معدل وارد شده نادرست است.",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void changeVisibility(boolean isVisible) {
        if (isVisible) {
            nameSignUp.setVisibility(View.VISIBLE);
            familySignUp.setVisibility(View.VISIBLE);
            stnoSignUp.setVisibility(View.VISIBLE);
            nationalIdSignUp.setVisibility(View.VISIBLE);
            majorSignUp.setVisibility(View.VISIBLE);
            entryYearSignUp.setVisibility(View.VISIBLE);
            averageSignUp.setVisibility(View.VISIBLE);
            registerSignUp.setVisibility(View.VISIBLE);
            signUpProgressBar.setVisibility(View.INVISIBLE);
        } else {
            nameSignUp.setVisibility(View.INVISIBLE);
            familySignUp.setVisibility(View.INVISIBLE);
            stnoSignUp.setVisibility(View.INVISIBLE);
            nationalIdSignUp.setVisibility(View.INVISIBLE);
            majorSignUp.setVisibility(View.INVISIBLE);
            entryYearSignUp.setVisibility(View.INVISIBLE);
            averageSignUp.setVisibility(View.INVISIBLE);
            registerSignUp.setVisibility(View.INVISIBLE);
            signUpProgressBar.setVisibility(View.VISIBLE);
        }
    }

    public boolean checkAvg() {
        String avg = averageSignUp.getText().toString();
        if (Double.parseDouble(avg) < 0 || Double.parseDouble(avg) > 20)
            return true;
        else
            return false;
    }

    public boolean checkEntryYear() {
        String entryYear = entryYearSignUp.getText().toString();
        if (Integer.parseInt(entryYear) < 1350 || Integer.parseInt(entryYear) > 1450)
            return true;
        else
            return false;
    }

    private void sendSignUpDataToServer() {
        StringRequest signUpRequest = new StringRequest(Request.Method.POST,
                SIGN_UP_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("\"You are signed up successfully\"")) {
                            startActivity(new Intent(SignUpActivity.this, MainPage.class));
                            finish();
                        } else if (response.equals("\"The student number or id number is used by other user!\"")) {
                            Toast.makeText(SignUpActivity.this,
                                    "کد ملی یا شماره دانشجویی از قبل وجود دارد.", Toast.LENGTH_LONG).show();
                            changeVisibility(true);
                        } else {

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SignUpActivity.this,
                                "اتصال برقرار نشد.", Toast.LENGTH_LONG).show();
                        changeVisibility(true);
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> signUpData = new HashMap<>();
                signUpData.put("firstName", nameSignUp.getText().toString());
                signUpData.put("lastName", familySignUp.getText().toString());
                signUpData.put("student_number", stnoSignUp.getText().toString());
                signUpData.put("id_number", nationalIdSignUp.getText().toString());
                signUpData.put("entery_year", entryYearSignUp.getText().toString());
                signUpData.put("average", averageSignUp.getText().toString());
                return signUpData;
            }
        };
        signUpQueue.add(signUpRequest);
    }
}