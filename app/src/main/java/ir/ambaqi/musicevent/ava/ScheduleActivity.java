package ir.ambaqi.musicevent.ava;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import Interfaces.ComponentMethod;
import data.CourseDetailSerializable;
import week_views.CourseNameViews;
import week_views.LayoutHandler;
import week_views.monday.Mon10_30_12LayoutHandler;
import week_views.monday.Mon13_30_15LayoutHandler;
import week_views.monday.Mon15_30_17LayoutHandler;
import week_views.monday.Mon7_30_9LayoutHandler;
import week_views.monday.Mon9_10_30LayoutHandler;
import week_views.saturday.Sat10_30_12LayoutHandler;
import week_views.saturday.Sat13_30_15LayoutHandler;
import week_views.saturday.Sat15_30_17LayoutHandler;
import week_views.saturday.Sat7_30_9LayoutHandler;
import week_views.saturday.Sat9_10_30LayoutHandler;
import week_views.sunday.Sun10_30_12LayoutHandler;
import week_views.sunday.Sun13_30_15LayoutHandler;
import week_views.sunday.Sun15_30_17LayoutHandler;
import week_views.sunday.Sun7_30_9LayoutHandler;
import week_views.sunday.Sun9_10_30LayoutHandler;
import week_views.tuesday.Tue10_30_12LayoutHandler;
import week_views.tuesday.Tue13_30_15LayoutHandler;
import week_views.tuesday.Tue15_30_17LayoutHandler;
import week_views.tuesday.Tue7_30_9LayoutHandler;
import week_views.tuesday.Tue9_10_30LayoutHandler;
import week_views.wednesday.Wed10_30_12LayoutHandler;
import week_views.wednesday.Wed13_30_15LayoutHandler;
import week_views.wednesday.Wed15_30_17LayoutHandler;
import week_views.wednesday.Wed7_30_9LayoutHandler;
import week_views.wednesday.Wed9_10_30LayoutHandler;

public class ScheduleActivity extends AppCompatActivity implements ComponentMethod {

    private ArrayList<CourseDetailSerializable> selectedClasses = new ArrayList<>();
    private LinearLayout sat, sun, mon, tue, wed;
    private TextView courseNameSat7_30_9, courseNameSat9_10_30, courseNameSat10_30_12, courseNameSat13_30_15, courseNameSat15_30_17;
    private TextView courseNameSun7_30_9, courseNameSun9_10_30, courseNameSun10_30_12, courseNameSun13_30_15, courseNameSun15_30_17;
    private TextView courseNameMon7_30_9, courseNameMon9_10_30, courseNameMon10_30_12, courseNameMon13_30_15, courseNameMon15_30_17;
    private TextView courseNameTue7_30_9, courseNameTue9_10_30, courseNameTue10_30_12, courseNameTue13_30_15, courseNameTue15_30_17;
    private TextView courseNameWed7_30_9, courseNameWed9_10_30, courseNameWed10_30_12, courseNameWed13_30_15, courseNameWed15_30_17;
    private ArrayList<TextView> textViewArrayList;
    private ArrayList<CourseDetailSerializable> courseSat7_30_9, courseSat9_10_30, courseSat10_30_12, courseSat13_30_15, courseSat15_30_17;
    private ArrayList<CourseDetailSerializable> courseSun7_30_9, courseSun9_10_30, courseSun10_30_12, courseSun13_30_15, courseSun15_30_17;
    private ArrayList<CourseDetailSerializable> courseMon7_30_9, courseMon9_10_30, courseMon10_30_12, courseMon13_30_15, courseMon15_30_17;
    private ArrayList<CourseDetailSerializable> courseTue7_30_9, courseTue9_10_30, courseTue10_30_12, courseTue13_30_15, courseTue15_30_17;
    private ArrayList<CourseDetailSerializable> courseWed7_30_9, courseWed9_10_30, courseWed10_30_12, courseWed13_30_15, courseWed15_30_17;
    private ArrayList<ArrayList<CourseDetailSerializable>> listOfCourseLists;
    private CourseNameViews courseNameViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Intent i = getIntent();
        selectedClasses = (ArrayList<CourseDetailSerializable>) i.getSerializableExtra("selectedClasses");
        init();
    }

    @Override
    public void init() {
        initLayout();
        initCourseName();
        setTextViewArrayList();
        createArrayLists();
        setListOfCourseLists();
        initCourseNameViews();
        initLayoutHandler();
    }

    private void initLayout() {
        sat = (LinearLayout) findViewById(R.id.saturday_layout);
        sun = (LinearLayout) findViewById(R.id.sunday_layout);
        mon = (LinearLayout) findViewById(R.id.monday_layout);
        tue = (LinearLayout) findViewById(R.id.tuesday_layout);
        wed = (LinearLayout) findViewById(R.id.wednesday_layout);
    }

    private void initCourseName() {
        courseNameSat7_30_9 = (TextView) sat.findViewById(R.id.course_name_sat_7_30_9);
        courseNameSat9_10_30 = (TextView) sat.findViewById(R.id.course_name_sat_9_10_30);
        courseNameSat10_30_12 = (TextView) sat.findViewById(R.id.course_name_sat_10_30_12);
        courseNameSat13_30_15 = (TextView) sat.findViewById(R.id.course_name_sat_13_30_15);
        courseNameSat15_30_17 = (TextView) sat.findViewById(R.id.course_name_sat_15_30_17);
        courseNameSun7_30_9 = (TextView) sun.findViewById(R.id.course_name_sun_7_30_9);
        courseNameSun9_10_30 = (TextView) sun.findViewById(R.id.course_name_sun_9_10_30);
        courseNameSun10_30_12 = (TextView) sun.findViewById(R.id.course_name_sun_10_30_12);
        courseNameSun13_30_15 = (TextView) sun.findViewById(R.id.course_name_sun_13_30_15);
        courseNameSun15_30_17 = (TextView) sun.findViewById(R.id.course_name_sun_15_30_17);
        courseNameMon7_30_9 = (TextView) mon.findViewById(R.id.course_name_mon_7_30_9);
        courseNameMon9_10_30 = (TextView) mon.findViewById(R.id.course_name_mon_9_10_30);
        courseNameMon10_30_12 = (TextView) mon.findViewById(R.id.course_name_mon_10_30_12);
        courseNameMon13_30_15 = (TextView) mon.findViewById(R.id.course_name_mon_13_30_15);
        courseNameMon15_30_17 = (TextView) mon.findViewById(R.id.course_name_mon_15_30_17);
        courseNameTue7_30_9 = (TextView) tue.findViewById(R.id.course_name_tue_7_30_9);
        courseNameTue9_10_30 = (TextView) tue.findViewById(R.id.course_name_tue_9_10_30);
        courseNameTue10_30_12 = (TextView) tue.findViewById(R.id.course_name_tue_10_30_12);
        courseNameTue13_30_15 = (TextView) tue.findViewById(R.id.course_name_tue_13_30_15);
        courseNameTue15_30_17 = (TextView) tue.findViewById(R.id.course_name_tue_15_30_17);
        courseNameWed7_30_9 = (TextView) wed.findViewById(R.id.course_name_wed_7_30_9);
        courseNameWed9_10_30 = (TextView) wed.findViewById(R.id.course_name_wed_9_10_30);
        courseNameWed10_30_12 = (TextView) wed.findViewById(R.id.course_name_wed_10_30_12);
        courseNameWed13_30_15 = (TextView) wed.findViewById(R.id.course_name_wed_13_30_15);
        courseNameWed15_30_17 = (TextView) wed.findViewById(R.id.course_name_wed_15_30_17);
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

    private void createArrayLists() {
        courseSat7_30_9 = new ArrayList<>();
        courseSat9_10_30 = new ArrayList<>();
        courseSat10_30_12 = new ArrayList<>();
        courseSat13_30_15 = new ArrayList<>();
        courseSat15_30_17 = new ArrayList<>();
        courseSun7_30_9 = new ArrayList<>();
        courseSun9_10_30 = new ArrayList<>();
        courseSun10_30_12 = new ArrayList<>();
        courseSun13_30_15 = new ArrayList<>();
        courseSun15_30_17 = new ArrayList<>();
        courseMon7_30_9 = new ArrayList<>();
        courseMon9_10_30 = new ArrayList<>();
        courseMon10_30_12 = new ArrayList<>();
        courseMon13_30_15 = new ArrayList<>();
        courseMon15_30_17 = new ArrayList<>();
        courseTue7_30_9 = new ArrayList<>();
        courseTue9_10_30 = new ArrayList<>();
        courseTue10_30_12 = new ArrayList<>();
        courseTue13_30_15 = new ArrayList<>();
        courseTue15_30_17 = new ArrayList<>();
        courseWed7_30_9 = new ArrayList<>();
        courseWed9_10_30 = new ArrayList<>();
        courseWed10_30_12 = new ArrayList<>();
        courseWed13_30_15 = new ArrayList<>();
        courseWed15_30_17 = new ArrayList<>();

    }

    private void setListOfCourseLists() {
        listOfCourseLists = new ArrayList<>();
        listOfCourseLists.add(courseSat7_30_9);
        listOfCourseLists.add(courseSat9_10_30);
        listOfCourseLists.add(courseSat10_30_12);
        listOfCourseLists.add(courseSat13_30_15);
        listOfCourseLists.add(courseSat15_30_17);
        listOfCourseLists.add(courseSun7_30_9);
        listOfCourseLists.add(courseSun9_10_30);
        listOfCourseLists.add(courseSun10_30_12);
        listOfCourseLists.add(courseSun13_30_15);
        listOfCourseLists.add(courseSun15_30_17);
        listOfCourseLists.add(courseMon7_30_9);
        listOfCourseLists.add(courseMon9_10_30);
        listOfCourseLists.add(courseMon10_30_12);
        listOfCourseLists.add(courseMon13_30_15);
        listOfCourseLists.add(courseMon15_30_17);
        listOfCourseLists.add(courseTue7_30_9);
        listOfCourseLists.add(courseTue9_10_30);
        listOfCourseLists.add(courseTue10_30_12);
        listOfCourseLists.add(courseTue13_30_15);
        listOfCourseLists.add(courseTue15_30_17);
        listOfCourseLists.add(courseWed7_30_9);
        listOfCourseLists.add(courseWed9_10_30);
        listOfCourseLists.add(courseWed10_30_12);
        listOfCourseLists.add(courseWed13_30_15);
        listOfCourseLists.add(courseWed15_30_17);
        setArrayLists();
    }


    private void setArrayLists() {
        for (int i = 0; i < selectedClasses.size(); i++) {
            for (int j = 0; j < selectedClasses.get(i).getCourseDays().size(); j++) {
                String day = selectedClasses.get(i).getCourseDays().get(j);
                String courseTime = selectedClasses.get(i).getCourseTime();
                if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("7:30"))
                    listOfCourseLists.get(0).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("9"))
                    listOfCourseLists.get(1).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("10:30"))
                    listOfCourseLists.get(2).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("13:30"))
                    listOfCourseLists.get(3).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("15:30"))
                    listOfCourseLists.get(4).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("7:30"))
                    listOfCourseLists.get(5).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("9"))
                    listOfCourseLists.get(6).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("10:30"))
                    listOfCourseLists.get(7).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("13:30"))
                    listOfCourseLists.get(8).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("15:30"))
                    listOfCourseLists.get(9).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("7:30"))
                    listOfCourseLists.get(10).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("9"))
                    listOfCourseLists.get(11).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("10:30"))
                    listOfCourseLists.get(12).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("13:30"))
                    listOfCourseLists.get(13).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("15:30"))
                    listOfCourseLists.get(14).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("7:30"))
                    listOfCourseLists.get(15).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("9"))
                    listOfCourseLists.get(16).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("10:30"))
                    listOfCourseLists.get(17).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("13:30"))
                    listOfCourseLists.get(18).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("15:30"))
                    listOfCourseLists.get(19).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("7:30"))
                    listOfCourseLists.get(20).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("9"))
                    listOfCourseLists.get(21).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("10:30"))
                    listOfCourseLists.get(22).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("13:30"))
                    listOfCourseLists.get(23).add(selectedClasses.get(i));
                else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("15:30"))
                    listOfCourseLists.get(24).add(selectedClasses.get(i));
            }
        }
    }

    private void initCourseNameViews() {
        courseNameViews = new CourseNameViews(textViewArrayList, listOfCourseLists);
    }

    private void initLayoutHandler() {
        Sat7_30_9LayoutHandler sat7_30_9LayoutHandler = new Sat7_30_9LayoutHandler(sat,
                courseNameViews, courseSat7_30_9);
        sat7_30_9LayoutHandler.init();
        Sat9_10_30LayoutHandler sat9_10_30LayoutHandler = new Sat9_10_30LayoutHandler(sat,
                courseNameViews, courseSat9_10_30);
        sat9_10_30LayoutHandler.init();
        Sat10_30_12LayoutHandler sat10_30_12LayoutHandler = new Sat10_30_12LayoutHandler(sat,
                courseNameViews, courseSat10_30_12);
        sat10_30_12LayoutHandler.init();
        Sat13_30_15LayoutHandler sat13_30_15LayoutHandler = new Sat13_30_15LayoutHandler(sat,
                courseNameViews, courseSat13_30_15);
        sat13_30_15LayoutHandler.init();
        Sat15_30_17LayoutHandler sat15_30_17LayoutHandler = new Sat15_30_17LayoutHandler(sat,
                courseNameViews, courseSat15_30_17);
        sat15_30_17LayoutHandler.init();
        Sun7_30_9LayoutHandler sun7_30_9LayoutHandler = new Sun7_30_9LayoutHandler(sun,
                courseNameViews, courseSun7_30_9);
        sun7_30_9LayoutHandler.init();
        Sun9_10_30LayoutHandler sun9_10_30LayoutHandler = new Sun9_10_30LayoutHandler(sun,
                courseNameViews, courseSun9_10_30);
        sun9_10_30LayoutHandler.init();
        Sun10_30_12LayoutHandler sun10_30_12LayoutHandler = new Sun10_30_12LayoutHandler(sun,
                courseNameViews, courseSun10_30_12);
        sun10_30_12LayoutHandler.init();
        Sun13_30_15LayoutHandler sun13_30_15LayoutHandler = new Sun13_30_15LayoutHandler(sun,
                courseNameViews, courseSun13_30_15);
        sun13_30_15LayoutHandler.init();
        Sun15_30_17LayoutHandler sun15_30_17LayoutHandler = new Sun15_30_17LayoutHandler(sun,
                courseNameViews, courseSun15_30_17);
        sun15_30_17LayoutHandler.init();
        Mon7_30_9LayoutHandler mon7_30_9LayoutHandler = new Mon7_30_9LayoutHandler(mon,
                courseNameViews, courseMon7_30_9);
        mon7_30_9LayoutHandler.init();
        Mon9_10_30LayoutHandler mon9_10_30LayoutHandler = new Mon9_10_30LayoutHandler(mon,
                courseNameViews, courseMon9_10_30);
        mon9_10_30LayoutHandler.init();
        Mon10_30_12LayoutHandler mon10_30_12LayoutHandler = new Mon10_30_12LayoutHandler(mon,
                courseNameViews, courseMon10_30_12);
        mon10_30_12LayoutHandler.init();
        Mon13_30_15LayoutHandler mon13_30_15LayoutHandler = new Mon13_30_15LayoutHandler(mon,
                courseNameViews, courseMon13_30_15);
        mon13_30_15LayoutHandler.init();
        Mon15_30_17LayoutHandler mon15_30_17LayoutHandler = new Mon15_30_17LayoutHandler(mon,
                courseNameViews, courseMon15_30_17);
        mon15_30_17LayoutHandler.init();
        Tue7_30_9LayoutHandler tue7_30_9LayoutHandler = new Tue7_30_9LayoutHandler(tue,
                courseNameViews, courseTue7_30_9);
        tue7_30_9LayoutHandler.init();
        Tue9_10_30LayoutHandler tue9_10_30LayoutHandler = new Tue9_10_30LayoutHandler(tue,
                courseNameViews, courseTue9_10_30);
        tue9_10_30LayoutHandler.init();
        Tue10_30_12LayoutHandler tue10_30_12LayoutHandler = new Tue10_30_12LayoutHandler(tue,
                courseNameViews, courseTue10_30_12);
        tue10_30_12LayoutHandler.init();
        Tue13_30_15LayoutHandler tue13_30_15LayoutHandler = new Tue13_30_15LayoutHandler(tue,
                courseNameViews, courseTue13_30_15);
        tue13_30_15LayoutHandler.init();
        Tue15_30_17LayoutHandler tue15_30_17LayoutHandler = new Tue15_30_17LayoutHandler(tue,
                courseNameViews, courseTue15_30_17);
        tue15_30_17LayoutHandler.init();
        Wed7_30_9LayoutHandler wed7_30_9LayoutHandler = new Wed7_30_9LayoutHandler(wed,
                courseNameViews, courseWed7_30_9);
        wed7_30_9LayoutHandler.init();
        Wed9_10_30LayoutHandler wed9_10_30LayoutHandler = new Wed9_10_30LayoutHandler(wed,
                courseNameViews, courseWed9_10_30);
        wed9_10_30LayoutHandler.init();
        Wed10_30_12LayoutHandler wed10_30_12LayoutHandler = new Wed10_30_12LayoutHandler(wed,
                courseNameViews, courseWed10_30_12);
        wed10_30_12LayoutHandler.init();
        Wed13_30_15LayoutHandler wed13_30_15LayoutHandler = new Wed13_30_15LayoutHandler(wed,
                courseNameViews, courseWed13_30_15);
        wed13_30_15LayoutHandler.init();
        Wed15_30_17LayoutHandler wed15_30_17LayoutHandler = new Wed15_30_17LayoutHandler(wed,
                courseNameViews, courseWed15_30_17);
        wed15_30_17LayoutHandler.init();
    }

    @Override
    public void changeVisibility(boolean isVisible) {

    }

    @Override
    public void setTypeFaceToComponent() {

    }
}
