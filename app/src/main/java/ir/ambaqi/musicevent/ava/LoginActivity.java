package ir.ambaqi.musicevent.ava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements ComponentInitialize{

    EditText loginNationalId, loginStno;
    Button loginRegisterBtn, loginEnterBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }



    public void loginBtnClick(View view) {
        if(view.getId() == R.id.login_enter_btn)
            loginEnterBtnEventHandler();
        else if(view.getId() == R.id.login_register_btn)
            loginRegisterBtnEventHandler();
    }

    private void loginRegisterBtnEventHandler() {
        if(loginNationalId.getText().toString().equals("") ||
                loginStno.getText().toString().equals(""))
            Toast.makeText(getApplicationContext(), "لطفا موارد خواسته شده را وارد نمایید!",
                    Toast.LENGTH_LONG).show();
        else {

        }
    }

    private void loginEnterBtnEventHandler() {
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        finish();
    }

    @Override
    public void init() {
        loginNationalId = findViewById(R.id.login_national_id);
        loginStno = findViewById(R.id.login_stno);
        loginRegisterBtn = findViewById(R.id.login_register_btn);
        loginEnterBtn = findViewById(R.id.login_enter_btn);
    }
}
