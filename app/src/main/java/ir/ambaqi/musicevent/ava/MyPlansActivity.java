package ir.ambaqi.musicevent.ava;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import data.url.UrlClass;
import my_plans_recycler_view_handler.data.PlansData;
import my_plans_recycler_view_handler.logic.RowPlanAdapter;
import select_course_recycler_view_handler.data.CourseDetailSerializable;

public class MyPlansActivity extends AppCompatActivity {

    private ArrayList<PlansData> classesInPlans;
    private RecyclerView recyclerView;
    private String stno;
    private RequestQueue queue;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plans);
        init();
        getPlansFromServer();
    }

    private void init() {
        stno = getIntent().getStringExtra("stno");
        recyclerView = (RecyclerView) findViewById(R.id.my_plans_recycler_view);
        classesInPlans = new ArrayList<>();
        queue = Volley.newRequestQueue(MyPlansActivity.this);
    }

   // @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void getPlansFromServer() {
        StringRequest request = new StringRequest(Request.Method.POST, UrlClass.getPlansURL,
                response -> {
                    try {
                        response = new String(response.getBytes("ISO-8859-1"), "UTF-8");
                        JSONArray responseArray = new JSONArray(response);
                        parseData(responseArray);
                    } catch (Exception e) {
                        Toast.makeText(MyPlansActivity.this, "خطا در نحوه ی دریافت اطلاعات",
                                Toast.LENGTH_LONG).show();
                    }
                },
                error -> Toast.makeText(MyPlansActivity.this, "خطا در برقراری ارتباط با سرور",
                        Toast.LENGTH_LONG).show()) {
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> params = new HashMap<>();
                params.put("student_number", stno);
                return params;
            }
        };
        queue.add(request);
    }

    private void parseData(JSONArray responseArray) throws JSONException {
        for (int i = 0; i < responseArray.length(); i++) {
            PlansData onePlanCourses = new PlansData();
            JSONObject planObject = responseArray.getJSONObject(i);
            String id = planObject.getString("id");
            onePlanCourses.setPlanId(id);
            JSONArray classesInOnePlan = planObject.getJSONArray("classes");
            for(int j = 0; j < classesInOnePlan.length(); j ++) {
                CourseDetailSerializable course = new CourseDetailSerializable();
                getEveryClass(course, classesInOnePlan.getJSONObject(j));
                onePlanCourses.getCourses().add(course);
            }
            classesInPlans.add(onePlanCourses);
        }
        RowPlanAdapter adapter = new RowPlanAdapter(classesInPlans, MyPlansActivity.this, stno);
        LinearLayoutManager manager = new LinearLayoutManager(MyPlansActivity.this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void getEveryClass(CourseDetailSerializable course, JSONObject _class) throws JSONException {
        course.setClassId(_class.getString("classId"));
        course.setExamTime(_class.getString("examTime"));
        course.setExamDay(_class.getString("examDay"));
        course.setCourseTime(_class.getString("courseTime"));
        String courseDays = _class.getString("courseDay");
        String[] courseDaysArray = courseDays.split(":");
        ArrayList<String> courseDaysArrayList = new ArrayList<>();
        String courseFirstDay = courseDaysArray[0];
        courseDaysArrayList.add(courseFirstDay);
        if(courseDaysArray.length > 1) {
            String courseSecondDay = courseDaysArray[1];
            courseDaysArrayList.add(courseSecondDay);
        }
        course.setCourseDays(courseDaysArrayList);
        course.setCapacity(_class.getString("capacity"));
        course.setRegistered(_class.getString("registered"));
        course.setSemester(_class.getString("semester"));
        JSONObject teacherObject = _class.getJSONObject("teacher");
        course.setTeacherId(teacherObject.getString("teacherId"));
        course.setTeacherName(teacherObject.getString("teacherName"));
        JSONObject courseObject = _class.getJSONObject("course");
        course.setCourseId(courseObject.getString("courseId"));
        course.setCourseName(courseObject.getString("courseName"));
        course.setUnitNumber(courseObject.getString("units"));
        course.setHavePreCourse(courseObject.getString("havePreCourse"));
        course.setHavePeriCourse(courseObject.getString("havePeriCourse"));
    }
}
