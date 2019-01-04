package ir.ambaqi.musicevent.ava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import data.url.UrlClass;

public class UpdateActivity extends AppCompatActivity {

    private TextView name, family, nationalId, major, entryYear, studentNumber;
    private EditText average;
    private Button updateButton;
    private String stno;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        init();
        stno = getIntent().getStringExtra("stno");
        getInfoFromServer();
    }

    private void init() {
        name = (TextView) findViewById(R.id.update_name);
        family = (TextView) findViewById(R.id.update_family);
        nationalId = (TextView) findViewById(R.id.update_national_id);
        major = (TextView) findViewById(R.id.update_major);
        entryYear = (TextView) findViewById(R.id.update_entry_year);
        average = (EditText) findViewById(R.id.update_average);
        studentNumber = (TextView) findViewById(R.id.update_stno);
        updateButton = (Button) findViewById(R.id.register_update);
        updateButton.setOnClickListener(v -> updateRegister());
        queue = Volley.newRequestQueue(UpdateActivity.this);
    }

    private void getInfoFromServer() {
        StringRequest request = new StringRequest(Request.Method.POST, UrlClass.getInfoURL,
                response -> {
                    try {
                        JSONObject object = new JSONObject(response);
                        name.setText("نام: " + URLDecoder.decode(object.getString("firstName"), "utf-8"));
                        family.setText("نام خانوادگی: " + URLDecoder.decode(object.getString("lastName"), "utf-8"));
                        studentNumber.setText("شماره دانشجویی: "+object.getString("student_number"));
                        nationalId.setText("کد ملی: " + object.getString("id_number"));
                        major.setText("رشته: " + object.getString("major"));
                        entryYear.setText("سال ورود: " + object.getString("entery_year"));
                        average.setText(object.getString("average"));
                    } catch (JSONException e) {
                        Toast.makeText(UpdateActivity.this,
                                "خطا در نحوه ی دریافت اطلاعات", Toast.LENGTH_LONG).show();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                },
                error -> Toast.makeText(UpdateActivity.this,
                        "خطا در برقراری ارتباط با سرور", Toast.LENGTH_LONG).show()) {
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> params = new HashMap<>();
                params.put("student_number", stno);
                return params;
            }
        };
        queue.add(request);
    }

    private void updateRegister() {
        if(studentNumber.getText().toString().equals("")){
            Toast.makeText(UpdateActivity.this, "عدم توانایی در برقراری ارتباط.",
                    Toast.LENGTH_LONG).show();
        }
        else if (average.getText().toString().equals("")) {
            Toast.makeText(UpdateActivity.this, "لطفا معدل را وارد نمایید.",
                    Toast.LENGTH_LONG).show();
        } else {
            if (checkAvg()) {
                Toast.makeText(UpdateActivity.this, "معدل وارد شده نادرست است.",
                        Toast.LENGTH_LONG).show();
            } else {
                sendUpdateInfo();
            }
        }

    }

    public boolean checkAvg() {
        String avg = average.getText().toString();
        try {
            if (Double.parseDouble(avg) < 0 || Double.parseDouble(avg) > 20)
                return true;
            else
                return false;
        } catch (Exception ex) {
            return true;
        }

    }

    private void sendUpdateInfo() {
        StringRequest request = new StringRequest(Request.Method.POST,UrlClass.updateInfoURL,
                response -> {
                    if(response.equalsIgnoreCase("\"Info updated successfully\"")) {
                        Toast.makeText(UpdateActivity.this, "اطلاعات با موفقیت تغییر کرد.",
                                Toast.LENGTH_LONG).show();
                        //getInfoFromServer();
                    }
                },
                error -> Toast.makeText(UpdateActivity.this, "خطا در برقراری ارتباط با سرور!",
                        Toast.LENGTH_LONG).show()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("student_number", stno);
                params.put("average", average.getText().toString());
                return params;
            }
        };
        queue.add(request);
    }


}
