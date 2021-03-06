package ir.ambaqi.musicevent.ava;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
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
import java.util.HashMap;
import java.util.Iterator;

import Interfaces.ComponentMethod;
import select_course_recycler_view_handler.data.CourseDetail;
import select_course_recycler_view_handler.data.CourseDetailSerializable;
import select_course_recycler_view_handler.data.CourseForRecyclerView;
import data.url.UrlClass;
import select_course_recycler_view_handler.logic.ChildAdapter;
import select_course_recycler_view_handler.logic.ClassesHashMap;

public class SelectCourseActivity extends AppCompatActivity implements ComponentMethod {

    private final String GET_CLASSES_URL = UrlClass.getClassesURL;
    private RequestQueue queue;
    private ArrayList<CourseDetail> courseDetails;
    private RecyclerView selectCourseRecyclerView;
    private ArrayList<CourseForRecyclerView> courses;
    public HashMap<String, CourseDetailSerializable> selectedClasses;
    private Button scheduleButton;
    private String stno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_course_activity);
        stno = getIntent().getStringExtra("stno");
        init();
        sendRequestToServer();
    }

    @Override
    public void init() {
        selectCourseRecyclerView = (RecyclerView) findViewById(R.id.select_course_recycler_view);
        queue = Volley.newRequestQueue(SelectCourseActivity.this);
        courseDetails = new ArrayList<>();
        courses = new ArrayList<>();
        scheduleButton = (Button) findViewById(R.id.schedule_selected_class);
        selectedClasses = new HashMap<>();
    }

    @Override
    public void changeVisibility(boolean isVisible) {

    }

    @Override
    public void setTypeFaceToComponent() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Fonts/Far_Naskh.ttf");
        scheduleButton.setTypeface(typeface);
    }

    private void sendRequestToServer() {
        JsonArrayRequest request = new JsonArrayRequest(GET_CLASSES_URL,
                response -> {
                    parseData(response);
                    fillCourses(courseDetails,courses);
                    setUiProperties();
                },
                error -> Toast.makeText(SelectCourseActivity.this, "عدم برقرای ارتباط با سرور",
                        Toast.LENGTH_LONG).show()
        );
        queue.add(request);
    }

    private void parseData(JSONArray response) {
        for (int i = 0; i < response.length(); i++) {
            CourseDetail courseDetail = new CourseDetail();
            try {
                JSONObject classObject = response.getJSONObject(i);
                getClassObjectProperties(courseDetail, classObject);
                JSONObject teacherObject = classObject.getJSONObject("teacher");
                getTeacherObjectProperties(courseDetail, teacherObject);
                JSONObject courseObject = classObject.getJSONObject("course");
                getCourseObjectProperties(courseDetail, courseObject);
                courseDetails.add(courseDetail);
            } catch (JSONException e) {
                Toast.makeText(SelectCourseActivity.this, "خطا در نحوه ی گرفتن اطلاعات",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    private void getClassObjectProperties(CourseDetail courseDetail, JSONObject classObject) throws JSONException {
        courseDetail.setClassId(classObject.getString("classId"));
        courseDetail.setExamTime(classObject.getString("examTime"));
        courseDetail.setExamDay(classObject.getString("examDay"));
        courseDetail.setCourseTime(classObject.getString("courseTime"));
        String courseDays = classObject.getString("courseDay");
        String[] courseDaysArray = courseDays.split(":");
        ArrayList<String> courseDaysArrayList = new ArrayList<>();
        String courseFirstDay = courseDaysArray[0];
        courseDaysArrayList.add(courseFirstDay);
        if(courseDaysArray.length > 1) {
            String courseSecondDay = courseDaysArray[1];
            courseDaysArrayList.add(courseSecondDay);
        }
        courseDetail.setCourseDays(courseDaysArrayList);
        courseDetail.setCapacity(classObject.getString("capacity"));
        courseDetail.setRegistered(classObject.getString("registered"));
        courseDetail.setSemester(classObject.getString("semester"));
        courseDetail.setCapacity(classObject.getString("capacity"));
    }

    private void getTeacherObjectProperties(CourseDetail courseDetail, JSONObject teacherObject) throws JSONException {
        courseDetail.setTeacherId(teacherObject.getString("teacherId"));
        courseDetail.setTeacherName(teacherObject.getString("teacherName"));
    }

    private void getCourseObjectProperties(CourseDetail courseDetail, JSONObject courseObject) throws JSONException {
        courseDetail.setCourseId(courseObject.getString("courseId"));
        courseDetail.setCourseName(courseObject.getString("courseName"));
        courseDetail.setUnitNumber(courseObject.getString("units"));
        courseDetail.setHavePreCourse(courseObject.getString("havePreCourse"));
        courseDetail.setHavePeriCourse(courseObject.getString("havePeriCourse"));
    }

    private void fillCourses(ArrayList<CourseDetail> courseDetails, ArrayList<CourseForRecyclerView> courses) {
        for (int i = 0; i < courseDetails.size(); i++) {
            ArrayList<CourseDetail> courseDetail = new ArrayList<>();
            courseDetail.add(courseDetails.get(i));
            CourseForRecyclerView courseForRecyclerView = new CourseForRecyclerView(courseDetails.get(i).getCourseName(),
                    courseDetail);
            courses.add(courseForRecyclerView);
        }
    }

    private void setUiProperties() {
        ClassesHashMap.selectedClasses.clear();
        ChildAdapter adapter = new ChildAdapter(courses, SelectCourseActivity.this);
        selectCourseRecyclerView.setLayoutManager(new LinearLayoutManager(SelectCourseActivity.this));
        selectCourseRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        scheduleButton.setOnClickListener(v -> {
            selectedClasses = ClassesHashMap.selectedClasses;
            ArrayList<CourseDetailSerializable> selectedClassesList = new ArrayList<>();
            mapSCHMToSCAL(selectedClasses, selectedClassesList);
            Intent i = new Intent(SelectCourseActivity.this, ScheduleActivity.class);
            i.putExtra("selectedClasses", selectedClassesList);
            i.putExtra("stno", stno);
            startActivity(i);
        });
    }

    private void mapSCHMToSCAL(HashMap<String, CourseDetailSerializable> selectedClasses, ArrayList<CourseDetailSerializable> selectedClassesList) {
        Iterator i = selectedClasses.keySet().iterator();
        while (i.hasNext()) {
            String key = (String) i.next();
            selectedClassesList.add(selectedClasses.get(key));
        }
    }

}
