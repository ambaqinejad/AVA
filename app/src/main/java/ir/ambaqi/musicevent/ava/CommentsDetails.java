package ir.ambaqi.musicevent.ava;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Interfaces.ComponentMethod;
import comment_recycler_view_handler.data.CourseTeacherForComment;
import comment_recycler_view_handler.data.RowCommentDetail;
import comment_recycler_view_handler.logic.RowCommentAdapter;
import data.url.UrlClass;

public class CommentsDetails extends AppCompatActivity implements ComponentMethod {

    private TextView courseNameInCommentDetail;
    private TextView teacherNameInCommentDetail;
    private RecyclerView commentDetailsRecyclerView;
    private EditText contentForSend;
    private ImageButton sendImageButton;
    private ArrayList<RowCommentDetail> rowCommentDetailArrayList;
    private RequestQueue queue;
    private final String Get_COMMENT_URL = UrlClass.getCommentURL;
    private final String Set_COMMENT_URL = UrlClass.setCommentURL;
    private String teacherId;
    private String courseId;
    private String teacherName;
    private String courseName;
    private String stno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments_details);
        init();
        setTypeFaceToComponent();
        Intent intent = getIntent();
        teacherId = intent.getStringExtra("teacherId");
        courseId = intent.getStringExtra("courseId");
        teacherName = intent.getStringExtra("teacherName");
        courseName = intent.getStringExtra("courseName");
        stno = intent.getStringExtra("stno");
        courseNameInCommentDetail.setText("نام درس: " + courseName);
        teacherNameInCommentDetail.setText("نام استاد: " + teacherName);
        sendRequestToServer(courseId, teacherId);

    }

    @Override
    public void init() {
        courseNameInCommentDetail = (TextView) findViewById(R.id.courseNameInCommentDetail);
        teacherNameInCommentDetail = (TextView) findViewById(R.id.teacherNameInCommentDetail);
        commentDetailsRecyclerView = (RecyclerView) findViewById(R.id.commentDetailsRecyclerView);
        contentForSend = (EditText) findViewById(R.id.content_for_send);
        sendImageButton = (ImageButton) findViewById(R.id.send_image_button);
        sendImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendComment();
            }
        });
        rowCommentDetailArrayList = new ArrayList<>();
        queue = Volley.newRequestQueue(CommentsDetails.this);
    }

    @Override
    public void changeVisibility(boolean isVisible) {

    }

    @Override
    public void setTypeFaceToComponent() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Fonts/Far_Naskh.ttf");
        courseNameInCommentDetail.setTypeface(typeface);
        teacherNameInCommentDetail.setTypeface(typeface);
        contentForSend.setTypeface(typeface);
    }

    private void sendRequestToServer(final String courseId, final String teacherId) {
        StringRequest getCommentRequest = new StringRequest(Request.Method.POST,
                Get_COMMENT_URL,
                response -> {
                    try {
                        JSONArray responseArray = new JSONArray(response);
                        parseData(responseArray);
                        setUiProperty();
                    } catch (JSONException e) {
                        Toast.makeText(CommentsDetails.this,
                                "خطا در نحوه ی دریافت اطلاعات",
                                Toast.LENGTH_LONG).show();
                    }
                },
                error -> Toast.makeText(CommentsDetails.this, "عدم برقراری ارتباط با سرور",
                        Toast.LENGTH_LONG).show()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> getCommentData = new HashMap<>();
                getCommentData.put("teacherId", teacherId);
                getCommentData.put("courseId", courseId);
                return getCommentData;
            }
        };
        queue.add(getCommentRequest);
    }

    private void parseData(JSONArray responseArray) throws JSONException {
        rowCommentDetailArrayList.clear();
        for (int i = 0; i < responseArray.length(); i++) {
            RowCommentDetail rowCommentDetail = new RowCommentDetail();
            rowCommentDetail.setContent(responseArray.getJSONObject(i).getString("content"));
            rowCommentDetail.setId(responseArray.getJSONObject(i).getString("id"));
            rowCommentDetail.setTime(responseArray.getJSONObject(i).getString("time"));
            JSONObject studentObject = responseArray.getJSONObject(i).getJSONObject("student");
            rowCommentDetail.setFirstName(studentObject.getString("firstName"));
            rowCommentDetail.setLastName(studentObject.getString("lastName"));
            rowCommentDetail.setStudentNumber(studentObject.getString("student_number"));
            rowCommentDetailArrayList.add(rowCommentDetail);


        }
    }

    private void setUiProperty() {
        RowCommentAdapter rowCommentAdapter = new RowCommentAdapter(rowCommentDetailArrayList,
                CommentsDetails.this, stno);
        LinearLayoutManager manager = new LinearLayoutManager(CommentsDetails.this);
        commentDetailsRecyclerView.setLayoutManager(manager);
        commentDetailsRecyclerView.setAdapter(rowCommentAdapter);
        rowCommentAdapter.notifyDataSetChanged();
    }

    private void sendComment() {
        String comment = contentForSend.getText().toString();
        if (!comment.equalsIgnoreCase("")) {
            sendCommentToServer(comment);
        }
    }

    private void sendCommentToServer(final String comment) {
        StringRequest request = new StringRequest(Request.Method.POST, Set_COMMENT_URL
                , response -> {
                    if (response.equalsIgnoreCase("\"The comment is saved successfuly\"")) {
                        sendRequestToServer(courseId, teacherId);
                        contentForSend.setText("");
                        Toast.makeText(CommentsDetails.this,
                                "نظر شما با موفقیت ثبت شد", Toast.LENGTH_LONG).show();
                    } else {

                    }
                },
                error -> Toast.makeText(CommentsDetails.this,
                        "اتصال برقرار نشد.", Toast.LENGTH_LONG).show()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                try {
                    HashMap<String, String> params = new HashMap<>();
                    params.put("teacherId", teacherId);
                    params.put("courseId", courseId);
                    params.put("studentNumber", stno);
                    params.put("content", URLEncoder.encode(comment, "utf-8"));
                    return params;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        queue.add(request);
    }
}
