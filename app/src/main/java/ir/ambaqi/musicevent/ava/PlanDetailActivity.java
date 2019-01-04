package ir.ambaqi.musicevent.ava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import data.url.UrlClass;
import my_plans_recycler_view_handler.data.PlansData;
import select_course_recycler_view_handler.data.CourseDetailSerializable;

public class PlanDetailActivity extends AppCompatActivity {

    private String stno;
    private PlansData plansData;
    private ArrayList<CourseDetailSerializable> courses;
    private String planId;
    private LinearLayout sat, sun, mon, tue, wed;
    private Button sendPlanToServer, sendAlternativePlanToServer;
    private TextView courseNameSat7_30_9, courseNameSat9_10_30, courseNameSat10_30_12, courseNameSat13_30_15, courseNameSat15_30_17;
    private TextView courseNameSun7_30_9, courseNameSun9_10_30, courseNameSun10_30_12, courseNameSun13_30_15, courseNameSun15_30_17;
    private TextView courseNameMon7_30_9, courseNameMon9_10_30, courseNameMon10_30_12, courseNameMon13_30_15, courseNameMon15_30_17;
    private TextView courseNameTue7_30_9, courseNameTue9_10_30, courseNameTue10_30_12, courseNameTue13_30_15, courseNameTue15_30_17;
    private TextView courseNameWed7_30_9, courseNameWed9_10_30, courseNameWed10_30_12, courseNameWed13_30_15, courseNameWed15_30_17;
    private ArrayList<TextView> textViewArrayList;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_detail);
        Intent intent = getIntent();
        stno = intent.getStringExtra("stno");
        plansData = (PlansData) intent.getSerializableExtra("courses");
        courses = plansData.getCourses();
        planId = plansData.getPlanId();
        init();
        setCoursesToTextViews();
    }

    private void setCoursesToTextViews() {
        for (int i = 0; i < courses.size(); i++) {
            CourseDetailSerializable course;
            course = courses.get(i);
            String courseName = course.getCourseName();
            String courseTime = course.getCourseTime();
            ArrayList<String> days = course.getCourseDays();
            String firstDay = days.get(0);
            getCourseTextView(firstDay, courseTime).setText(courseName);
            if (days.size() > 1) {
                String secondDay = days.get(1);
                getCourseTextView(secondDay, courseTime).setText(courseName);
            }
        }
    }

    private void init() {
        queue = Volley.newRequestQueue(PlanDetailActivity.this);
        sendPlanToServer = (Button) findViewById(R.id.sendPlanToServer);
        sendAlternativePlanToServer = (Button) findViewById(R.id.sendAlternativePlanToServer);
        sendPlanToServer.setOnClickListener(v -> sendPlan());
        sendAlternativePlanToServer.setOnClickListener(v -> sendAlternativePlan());
        initLayout();
        initCourseName();
        setTextViewArrayList();
    }

    private void initLayout() {
        sat = (LinearLayout) findViewById(R.id.saturday_layoutp);
        sun = (LinearLayout) findViewById(R.id.sunday_layoutp);
        mon = (LinearLayout) findViewById(R.id.monday_layoutp);
        tue = (LinearLayout) findViewById(R.id.tuesday_layoutp);
        wed = (LinearLayout) findViewById(R.id.wednesday_layoutp);
    }

    private void initCourseName() {
        courseNameSat7_30_9 = (TextView) sat.findViewById(R.id.course_name_sat_7_30_9p);
        courseNameSat9_10_30 = (TextView) sat.findViewById(R.id.course_name_sat_9_10_30p);
        courseNameSat10_30_12 = (TextView) sat.findViewById(R.id.course_name_sat_10_30_12p);
        courseNameSat13_30_15 = (TextView) sat.findViewById(R.id.course_name_sat_13_30_15p);
        courseNameSat15_30_17 = (TextView) sat.findViewById(R.id.course_name_sat_15_30_17p);
        courseNameSun7_30_9 = (TextView) sun.findViewById(R.id.course_name_sun_7_30_9p);
        courseNameSun9_10_30 = (TextView) sun.findViewById(R.id.course_name_sun_9_10_30p);
        courseNameSun10_30_12 = (TextView) sun.findViewById(R.id.course_name_sun_10_30_12p);
        courseNameSun13_30_15 = (TextView) sun.findViewById(R.id.course_name_sun_13_30_15p);
        courseNameSun15_30_17 = (TextView) sun.findViewById(R.id.course_name_sun_15_30_17p);
        courseNameMon7_30_9 = (TextView) mon.findViewById(R.id.course_name_mon_7_30_9p);
        courseNameMon9_10_30 = (TextView) mon.findViewById(R.id.course_name_mon_9_10_30p);
        courseNameMon10_30_12 = (TextView) mon.findViewById(R.id.course_name_mon_10_30_12p);
        courseNameMon13_30_15 = (TextView) mon.findViewById(R.id.course_name_mon_13_30_15p);
        courseNameMon15_30_17 = (TextView) mon.findViewById(R.id.course_name_mon_15_30_17p);
        courseNameTue7_30_9 = (TextView) tue.findViewById(R.id.course_name_tue_7_30_9p);
        courseNameTue9_10_30 = (TextView) tue.findViewById(R.id.course_name_tue_9_10_30p);
        courseNameTue10_30_12 = (TextView) tue.findViewById(R.id.course_name_tue_10_30_12p);
        courseNameTue13_30_15 = (TextView) tue.findViewById(R.id.course_name_tue_13_30_15p);
        courseNameTue15_30_17 = (TextView) tue.findViewById(R.id.course_name_tue_15_30_17p);
        courseNameWed7_30_9 = (TextView) wed.findViewById(R.id.course_name_wed_7_30_9p);
        courseNameWed9_10_30 = (TextView) wed.findViewById(R.id.course_name_wed_9_10_30p);
        courseNameWed10_30_12 = (TextView) wed.findViewById(R.id.course_name_wed_10_30_12p);
        courseNameWed13_30_15 = (TextView) wed.findViewById(R.id.course_name_wed_13_30_15p);
        courseNameWed15_30_17 = (TextView) wed.findViewById(R.id.course_name_wed_15_30_17p);
    }

    private void setTextViewArrayList() {
        textViewArrayList = new ArrayList<>();
        textViewArrayList.add(courseNameSat7_30_9);
        textViewArrayList.add(courseNameSat9_10_30);
        textViewArrayList.add(courseNameSat10_30_12);
        textViewArrayList.add(courseNameSat13_30_15);
        textViewArrayList.add(courseNameSat15_30_17);
        textViewArrayList.add(courseNameSun7_30_9);
        textViewArrayList.add(courseNameSun9_10_30);
        textViewArrayList.add(courseNameSun10_30_12);
        textViewArrayList.add(courseNameSun13_30_15);
        textViewArrayList.add(courseNameSun15_30_17);
        textViewArrayList.add(courseNameMon7_30_9);
        textViewArrayList.add(courseNameMon9_10_30);
        textViewArrayList.add(courseNameMon10_30_12);
        textViewArrayList.add(courseNameMon13_30_15);
        textViewArrayList.add(courseNameMon15_30_17);
        textViewArrayList.add(courseNameTue7_30_9);
        textViewArrayList.add(courseNameTue9_10_30);
        textViewArrayList.add(courseNameTue10_30_12);
        textViewArrayList.add(courseNameTue13_30_15);
        textViewArrayList.add(courseNameTue15_30_17);
        textViewArrayList.add(courseNameWed7_30_9);
        textViewArrayList.add(courseNameWed9_10_30);
        textViewArrayList.add(courseNameWed10_30_12);
        textViewArrayList.add(courseNameWed13_30_15);
        textViewArrayList.add(courseNameWed15_30_17);
    }

    public TextView getCourseTextView(String day, String courseTime) {
        if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("7:30"))
            return textViewArrayList.get(0);
        else if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("9"))
            return textViewArrayList.get(1);
        else if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("10:30"))
            return textViewArrayList.get(2);
        else if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("13:30"))
            return textViewArrayList.get(3);
        else if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("15:30"))
            return textViewArrayList.get(4);
        else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("7:30"))
            return textViewArrayList.get(5);
        else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("9"))
            return textViewArrayList.get(6);
        else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("10:30"))
            return textViewArrayList.get(7);
        else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("13:30"))
            return textViewArrayList.get(8);
        else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("15:30"))
            return textViewArrayList.get(9);
        else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("7:30"))
            return textViewArrayList.get(10);
        else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("9"))
            return textViewArrayList.get(11);
        else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("10:30"))
            return textViewArrayList.get(12);
        else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("13:30"))
            return textViewArrayList.get(13);
        else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("15:30"))
            return textViewArrayList.get(14);
        else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("7:30"))
            return textViewArrayList.get(15);
        else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("9"))
            return textViewArrayList.get(16);
        else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("10:30"))
            return textViewArrayList.get(17);
        else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("13:30"))
            return textViewArrayList.get(18);
        else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("15:30"))
            return textViewArrayList.get(19);
        else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("7:30"))
            return textViewArrayList.get(20);
        else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("9"))
            return textViewArrayList.get(21);
        else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("10:30"))
            return textViewArrayList.get(22);
        else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("13:30"))
            return textViewArrayList.get(23);
        else
            return textViewArrayList.get(24);
    }

    private void sendPlan() {
        StringRequest request = new StringRequest(Request.Method.POST, UrlClass.registerPlansURL,
                response -> {
                    StringBuilder reg = new StringBuilder();
                    String alreadyReg = "\"The student was registered recently\"";
                    reg.append("\"Student ").append(stno).
                            append(" is registered in classes successfully\"");
                    if (response.equalsIgnoreCase(reg.toString())) {
                        Toast.makeText(PlanDetailActivity.this,
                                R.string.register_successfully, Toast.LENGTH_LONG).show();
                    } else if (response.equalsIgnoreCase(alreadyReg)) {
                        Toast.makeText(PlanDetailActivity.this,
                                R.string.you_already_register, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(PlanDetailActivity.this,
                                R.string.planIsNotFound, Toast.LENGTH_LONG).show();
                    }
                },
                error -> Toast.makeText(PlanDetailActivity.this,
                        "خطا در برقراری ارتباط با سرور", Toast.LENGTH_LONG).show()) {
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> params = new HashMap<>();
                params.put("student_number", stno);
                params.put("id", planId);
                return params;
            }
        };
        queue.add(request);
    }

    private void sendAlternativePlan() {
        StringRequest request = new StringRequest(Request.Method.POST, UrlClass.uRegisterPlansURL,
                response -> {
                    String updateSuccessfully = "\"The registeration is updated successfully\"";
                    String alreadyReg = "\"The registeration is not changed\"";
                    String wasNotRegBefore = "\"The student was not registered before\"";
                    if (response.equalsIgnoreCase(updateSuccessfully)) {
                        Toast.makeText(PlanDetailActivity.this,
                                R.string.updateRegSuccessfully, Toast.LENGTH_LONG).show();
                    } else if (response.equalsIgnoreCase(alreadyReg)) {
                        Toast.makeText(PlanDetailActivity.this,
                                R.string.alreadyRegThisPlan, Toast.LENGTH_LONG).show();
                    } else if (response.equalsIgnoreCase(wasNotRegBefore)) {
                        Toast.makeText(PlanDetailActivity.this,
                                "شما قبلا ثبت نام نکرده اید", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(PlanDetailActivity.this,
                                R.string.planIsNotFound, Toast.LENGTH_LONG).show();
                    }
                },
                error -> Toast.makeText(PlanDetailActivity.this,
                        "خطا در برقراری ارتباط با سرور", Toast.LENGTH_LONG).show()) {
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> params = new HashMap<>();
                params.put("student_number", stno);
                params.put("id", planId);
                return params;
            }
        };
        queue.add(request);

    }
}
