package ir.ambaqi.musicevent.ava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import comment_recycler_view_handler.CourseTeacherChildAdapter;
import data.comment.CourseNameForCommentRecyclerView;
import data.comment.CourseTeacherForComment;
import data.url.UrlClass;

public class CommentActivity extends AppCompatActivity {

    private final String GET_CLASSES_URL = UrlClass.getClassesURL;
    private RequestQueue queue;
    private ArrayList<CourseTeacherForComment> courseTeacherForCommentArrayList;
    private RecyclerView courseTeacherForCommentRecyclerView;
    private ArrayList<CourseNameForCommentRecyclerView> coursesNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        init();
        sendRequestToServer();
    }

    private void init() {
        courseTeacherForCommentRecyclerView = (RecyclerView) findViewById(R.id.comment_recycler_view);
        queue = Volley.newRequestQueue(CommentActivity.this);
        courseTeacherForCommentArrayList = new ArrayList<>();
        coursesNames = new ArrayList<>();
    }

    private void sendRequestToServer() {
        JsonArrayRequest request = new JsonArrayRequest(GET_CLASSES_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        parsData(response);
                        fillCoursesNames();
                        setUiProperties();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(CommentActivity.this, "عدم برقرای ارتباط با سرور",
                                Toast.LENGTH_LONG).show();
                    }
                }
        );
        queue.add(request);
    }

    private void parsData(JSONArray response) {
        for (int i = 0; i < response.length(); i++) {
            CourseTeacherForComment courseTeacherForComment = new CourseTeacherForComment();
            try {
                JSONObject object = response.getJSONObject(i);
                JSONObject courseObject = object.getJSONObject("course");
                courseTeacherForComment.setCourseId(courseObject.getString("courseId"));
                courseTeacherForComment.setCourseName(courseObject.getString("courseName"));
                JSONObject teacherObject = object.getJSONObject("teacher");
                courseTeacherForComment.setTeacherId(teacherObject.getString("teacherId"));
                courseTeacherForComment.setTeacherName(teacherObject.getString("teacherName"));
                courseTeacherForCommentArrayList.add(courseTeacherForComment);
            } catch (JSONException e) {
                Toast.makeText(CommentActivity.this, "خطا در نحوه ی گرفتن اطلاعات",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    private void fillCoursesNames() {
        for (int i = 0; i < courseTeacherForCommentArrayList.size(); i++) {
            ArrayList<CourseTeacherForComment> courseTeacherForComments = new ArrayList<>();
            courseTeacherForComments.add(courseTeacherForCommentArrayList.get(i));
            CourseNameForCommentRecyclerView courseNameForCommentRecyclerView =
                    new CourseNameForCommentRecyclerView(courseTeacherForCommentArrayList.get(i).getCourseName(),
                            courseTeacherForComments);
            coursesNames.add(courseNameForCommentRecyclerView);
        }
    }

    private void setUiProperties() {
        CourseTeacherChildAdapter adapter = new CourseTeacherChildAdapter(coursesNames, CommentActivity.this);
        courseTeacherForCommentRecyclerView.setLayoutManager(new LinearLayoutManager(CommentActivity.this));
        courseTeacherForCommentRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
