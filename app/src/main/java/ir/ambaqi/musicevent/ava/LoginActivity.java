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

import Interfaces.ComponentMethod;
import data.url.UrlClass;

public class LoginActivity extends AppCompatActivity implements ComponentMethod {

    EditText loginNationalId, loginStno;
    Button loginEnterBtn;
    TextView loginRegisterTextView, welcome;
    ProgressBar loginProgressBar;
    RequestQueue queue;
    String LOGIN_URL = UrlClass.loginURL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    @Override
    public void init() {
        loginNationalId = (EditText) findViewById(R.id.login_national_id);
        loginStno = (EditText) findViewById(R.id.login_stno);
        loginRegisterTextView = (TextView) findViewById(R.id.login_register_btn);
        welcome = (TextView) findViewById(R.id.welcome);
        loginEnterBtn = (Button) findViewById(R.id.login_enter_btn);
        loginProgressBar = (ProgressBar) findViewById(R.id.progress_bar_login);
        queue = Volley.newRequestQueue(LoginActivity.this);
        setTypeFaceToComponent();
    }

    @Override
    public void setTypeFaceToComponent() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Fonts/Far_Naskh.ttf");
        loginNationalId.setTypeface(typeface);
        loginStno.setTypeface(typeface);
        loginRegisterTextView.setTypeface(typeface);
        welcome.setTypeface(typeface);
        loginEnterBtn.setTypeface(typeface);
    }

    public void loginBtnClick(View view) {
        if (view.getId() == R.id.login_enter_btn)
            loginEnterBtnEventHandler();
        else if (view.getId() == R.id.login_register_btn)
            loginRegisterBtnEventHandler();
    }

    private void loginEnterBtnEventHandler() {
        if (loginNationalId.getText().toString().equals("") ||
                loginStno.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), "لطفا موارد خواسته شده را وارد نمایید!",
                    Toast.LENGTH_LONG).show();
        else {
            changeVisibility(false);
            sendDataToServer();
        }
    }

    private void loginRegisterBtnEventHandler() {
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
    }

    private void sendDataToServer() {
        StringRequest request = new StringRequest(
                Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("\"You are loged in successfully\"")) {
                            startActivity(new Intent(LoginActivity.this, MainPage.class));
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this,
                                    "اطلاعات ورودی صحیح نمی باشد.", Toast.LENGTH_LONG).show();
                            changeVisibility(true);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this,
                                "اتصال برقرار نشد.", Toast.LENGTH_LONG).show();
                        changeVisibility(true);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> loginData = new HashMap<>();
                String nationalIdStr = loginNationalId.getText().toString();
                String stnoStr = loginStno.getText().toString();
                loginData.put("id_number", nationalIdStr);
                loginData.put("student_number", stnoStr);
                return loginData;
            }
        };
        queue.add(request);
    }

    @Override
    public void changeVisibility(boolean isVisible) {
        if (isVisible) {
            loginNationalId.setVisibility(View.VISIBLE);
            loginStno.setVisibility(View.VISIBLE);
            loginRegisterTextView.setVisibility(View.VISIBLE);
            loginEnterBtn.setVisibility(View.VISIBLE);
            loginProgressBar.setVisibility(View.INVISIBLE);
        } else {
            loginNationalId.setVisibility(View.INVISIBLE);
            loginStno.setVisibility(View.INVISIBLE);
            loginRegisterTextView.setVisibility(View.INVISIBLE);
            loginEnterBtn.setVisibility(View.INVISIBLE);
            loginProgressBar.setVisibility(View.VISIBLE);
        }
    }
}
