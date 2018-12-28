package ir.ambaqi.musicevent.ava;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import Interfaces.ComponentMethod;
import data.select_course.CourseDetailSerializable;

public class CourseDetailActivity extends AppCompatActivity implements ComponentMethod {

    private TextView classInfoTextView, courseName, teacherName, classCode;
    private TextView classPlanInfoTextView, courseDays, courseTime;
    private TextView examInfoTextView, examDay, examTime;
    private TextView unitInfoTextView, unitNumber;
    private TextView capacityTextView, capacity, registeredTextView, registered;
    private TextView registeredPerCapacity;
    private ProgressBar registeredPerCapacityProgressbar;
    private CourseDetailSerializable courseDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        init();
        setTypeFaceToComponent();
        courseDetail = (CourseDetailSerializable) getIntent().getSerializableExtra("courseDetail");
        setUiProperties();

    }

//    private CourseDetail getBundleContent(Bundle bundle) {
//        CourseDetail courseDetail = new CourseDetail();
//        courseDetail.setClassId(bundle.getString("classId",""));
//        courseDetail.setExamTime(bundle.getString("examTime",""));
//        courseDetail.setExamDay(bundle.getString("examDay",""));
//        courseDetail.setCourseTime(bundle.getString("courseTime",""));
//        courseDetail.setCourseDays(bundle.getStringArrayList("courseDay"));
//        courseDetail.setCapacity(bundle.getString("capacity",""));
//        courseDetail.setRegistered(bundle.getString("registered",""));
//        courseDetail.setSemester(bundle.getString("semester",""));
//        courseDetail.setTeacherId(bundle.getString("teacherId",""));
//        courseDetail.setTeacherName(bundle.getString("teacherName",""));
//        courseDetail.setCourseId(bundle.getString("courseId",""));
//        courseDetail.setCourseName(bundle.getString("courseName",""));
//        courseDetail.setUnitNumber(bundle.getString("units",""));
//        courseDetail.setHavePreCourse(bundle.getString("havePreCourse",""));
//        courseDetail.setHavePeriCourse(bundle.getString("havePeriCourse",""));
//        return courseDetail;
//    }


    @Override
    public void init() {
        classInfoTextView = (TextView) findViewById(R.id.class_info_text_view);
        courseName = (TextView) findViewById(R.id.course_name_in_course_detail_activity);
        teacherName = (TextView) findViewById(R.id.teacher_name_in_course_detail_activity);
        classCode = (TextView) findViewById(R.id.class_code_in_course_detail_activity);
        classPlanInfoTextView = (TextView) findViewById(R.id.class_plan_info_text_view);
        courseDays = (TextView) findViewById(R.id.course_days_in_course_detail_activity);
        courseTime = (TextView) findViewById(R.id.course_time_in_course_detail_activity);
        examInfoTextView = (TextView) findViewById(R.id.exam_info_text_view);
        examDay = (TextView) findViewById(R.id.exam_day_in_course_detail_activity);
        examTime = (TextView) findViewById(R.id.exam_time_in_course_detail_activity);
        unitInfoTextView = (TextView) findViewById(R.id.unit_info_text_view);
        unitNumber = (TextView) findViewById(R.id.unit_number_in_course_detail_activity);
        capacityTextView = (TextView) findViewById(R.id.capacity_text_view);
        capacity = (TextView) findViewById(R.id.capacity_in_course_detail);
        registeredTextView = (TextView) findViewById(R.id.registered_text_in_course_detail);
        registered = (TextView) findViewById(R.id.registered_in_course_detail);
        registeredPerCapacity = (TextView) findViewById(R.id.registered_per_capacity_in_course_detail);
        registeredPerCapacityProgressbar = (ProgressBar) findViewById(R.id.registered_per_capacity_progressbar_in_course_detail);
        courseDetail = new CourseDetailSerializable();
    }

    @Override
    public void changeVisibility(boolean isVisible) {

    }

    @Override
    public void setTypeFaceToComponent() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Fonts/Far_Naskh.ttf");
        classInfoTextView.setTypeface(typeface);
        courseName.setTypeface(typeface);
        teacherName.setTypeface(typeface);
        classCode.setTypeface(typeface);
        classPlanInfoTextView.setTypeface(typeface);
        courseDays.setTypeface(typeface);
        courseTime.setTypeface(typeface);
        classPlanInfoTextView.setTypeface(typeface);
        examInfoTextView.setTypeface(typeface);
        examDay.setTypeface(typeface);
        examTime.setTypeface(typeface);
        unitInfoTextView.setTypeface(typeface);
        capacityTextView.setTypeface(typeface);
        capacity.setTypeface(typeface);
        registeredTextView.setTypeface(typeface);
        registered.setTypeface(typeface);
        unitNumber.setTypeface(typeface);
        registeredPerCapacity.setTypeface(typeface);
    }

    private void setUiProperties() {
        courseName.setText(new StringBuilder().append("نام درس: ").append(courseDetail.getCourseName()).toString());
        teacherName.setText(new StringBuilder().append("نام استاد: ").append(courseDetail.getTeacherName()).toString());
        classCode.setText(new StringBuilder().append("کد کلاس: ").append(courseDetail.getClassId()).toString());
        setCourseDays();
        courseTime.setText(new StringBuilder().append("ساعت ارائه کلاس: ").append(courseDetail.getCourseTime()).toString());
        examDay.setText(new StringBuilder().append("تاریخ آزمون: ").append(courseDetail.getExamDay()).toString());
        examTime.setText(new StringBuilder().append("ساعت آزمون: ").append(courseDetail.getExamTime()).toString());
        unitNumber.setText(new StringBuilder().append(courseDetail.getUnitNumber()).append(" واحد").toString());
        capacity.setText(new StringBuilder().append(courseDetail.getCapacity()).append(" نفر").toString());
        registered.setText(new StringBuilder().append(courseDetail.getRegistered()).append(" نفر").toString());
        registeredPerCapacity.setText(new StringBuilder().append(courseDetail.getRegistered())
                .append("/").append(courseDetail.getCapacity()).toString());
        registeredPerCapacityProgressbar.setMax(Integer.parseInt(courseDetail.getCapacity()));
        registeredPerCapacityProgressbar.setProgress(Integer.parseInt(courseDetail.getRegistered()));

    }

    private void setCourseDays() {
        if(courseDetail.getCourseDays().size() > 1) {
            String fDay = courseDetail.getCourseDays().get(0)+" شنبه";
            String sDay = courseDetail.getCourseDays().get(1)+"شنبه";
            if(fDay.equalsIgnoreCase("0 شنبه")) {
                fDay = "شنبه";
            }
            if (sDay.equalsIgnoreCase("0 شنبه")) {
                sDay = "شنبه";
            }
            courseDays.setText(fDay+" و "+sDay);
        } else {
            String fDay = courseDetail.getCourseDays().get(0)+" شنبه";
            if(fDay.equalsIgnoreCase("0 شنبه")) {
                fDay = "شنبه";
            }
            courseDays.setText(fDay);
        }
    }

    private boolean hasSaturday() {
        return courseDetail.getCourseDays().contains("0");
    }
}
