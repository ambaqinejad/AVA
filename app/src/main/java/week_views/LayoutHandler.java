package week_views;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import data.CourseDetailSerializable;
import ir.ambaqi.musicevent.ava.R;

public abstract class LayoutHandler {
    protected ArrayList<Integer> listsCurrentItemIndex;
    protected LinearLayout layout;
    protected TextView time;
    protected ImageButton left, right, remove;
    protected CourseNameViews courseNameViews;
    protected ArrayList<CourseDetailSerializable> courseList;

    //parent
    public LayoutHandler(LinearLayout layout, CourseNameViews courseNameViews,
                         ArrayList<CourseDetailSerializable> courseList) {
        this.listsCurrentItemIndex = new ArrayList<>();
        this.layout = layout;
        this.courseNameViews = courseNameViews;
        this.courseList = courseList;
        for (int i = 0; i < this.courseNameViews.getListOfCourseLists().size(); i++)
            listsCurrentItemIndex.add(0);
    }


    //parent
    protected void setTextForCourseNameAtFirst() {
        CourseDetailSerializable course;
        course = courseList.get(0);
        String courseName = course.getCourseName();
        String classCode = course.getClassId();
        String courseFirstDay = course.getCourseDays().get(0);
        String courseSecondDay;
        String courseTime = course.getCourseTime();
        if (course.getCourseDays().size() > 1) {
            courseSecondDay = course.getCourseDays().get(1);
            CourseProperties courseProperties1 = getCourseProperties(course, courseFirstDay, courseTime);
            CourseProperties courseProperties2 = getCourseProperties(course, courseSecondDay, courseTime);
            if (courseProperties1.getCourseTextView().getText().toString().equalsIgnoreCase("") &&
                    courseProperties2.getCourseTextView().getText().toString().equalsIgnoreCase("")) {
                courseProperties1.getCourseTextView().setText(courseName + "\n" + "کد کلاس:" + classCode);
                courseProperties2.getCourseTextView().setText(courseName + "\n" + "کد کلاس:" + classCode);
            }
        } else {
            CourseProperties courseProperties1 = getCourseProperties(course, courseFirstDay, courseTime);
            if (courseProperties1.getCourseTextView().getText().toString().equalsIgnoreCase("")) {
                courseProperties1.getCourseTextView().setText(courseName + "\n" + "کد کلاس:" + classCode);
            }
        }
    }

    public CourseProperties getCourseProperties(CourseDetailSerializable course, String day, String courseTime) {
        CourseProperties courseProperties = new CourseProperties();
        ArrayList<ArrayList<CourseDetailSerializable>> coursesLists = courseNameViews.getListOfCourseLists();
        if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("7:30"))
            setCourseProperties(0, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("9"))
            setCourseProperties(1, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("10:30"))
            setCourseProperties(2, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("13:30"))
            setCourseProperties(3, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("15:30"))
            setCourseProperties(4, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("7:30"))
            setCourseProperties(5, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("9"))
            setCourseProperties(6, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("10:30"))
            setCourseProperties(7, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("13:30"))
            setCourseProperties(8, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("15:30"))
            setCourseProperties(9, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("7:30"))
            setCourseProperties(10, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("9"))
            setCourseProperties(11, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("10:30"))
            setCourseProperties(12, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("13:30"))
            setCourseProperties(13, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("15:30"))
            setCourseProperties(14, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("7:30"))
            setCourseProperties(15, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("9"))
            setCourseProperties(16, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("10:30"))
            setCourseProperties(17, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("13:30"))
            setCourseProperties(18, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("15:30"))
            setCourseProperties(19, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("7:30"))
            setCourseProperties(20, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("9"))
            setCourseProperties(21, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("10:30"))
            setCourseProperties(22, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("13:30"))
            setCourseProperties(23, courseProperties, course, coursesLists);
        else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("15:30"))
            setCourseProperties(24, courseProperties, course, coursesLists);
        return courseProperties;
    }

    private void setCourseProperties(int i, CourseProperties courseProperties, CourseDetailSerializable course,
                                     ArrayList<ArrayList<CourseDetailSerializable>> coursesLists) {
        courseProperties.setCourseTextView(courseNameViews.getTextViewArrayList().get(i));
        courseProperties.setArrayListIndex(i);
        courseProperties.setItemIndex(findCourseIndex(course, coursesLists.get(i)));
        listsCurrentItemIndex.set(i, courseProperties.getItemIndex());
    }

    private int findCourseIndex(CourseDetailSerializable course, ArrayList<CourseDetailSerializable> courseDetailSerializables) {
        for (int i = 0; i < courseDetailSerializables.size(); i++) {
            if (course.equals(courseDetailSerializables.get(i)))
                return i;
        }
        return -1;
    }


    protected void setOnClickForButtons(int dayTimeTag) {
        leftOnClick(dayTimeTag);
        rightOnClick(dayTimeTag);
        removeOnClick(dayTimeTag);
    }

    private void rightOnClick(int dayTimeTag) {
        removeCurrentText(dayTimeTag);
        int currentIndex = listsCurrentItemIndex.get(dayTimeTag) + 1;
        if(currentIndex == courseList.size()) {
            listsCurrentItemIndex.set(dayTimeTag, 0);
        } else {
            listsCurrentItemIndex.set(dayTimeTag, currentIndex);
        }
        setNextText(dayTimeTag);
    }

    private void setNextText(int dayTimeTag) {
        CourseDetailSerializable nextCourse;
        nextCourse = courseList.get(listsCurrentItemIndex.get(dayTimeTag));
        String nextCourseFirstDay = nextCourse.getCourseDays().get(0);
        String nextCourseSecondDay;


    }

    private void removeCurrentText(int dayTimeTag) {
        CourseDetailSerializable currentCourse;
        currentCourse = courseList.get(listsCurrentItemIndex.get(dayTimeTag));
        String currentCourseFirstDay = currentCourse.getCourseDays().get(0);
        String currentCourseSecondDay;
        String currentCourseTime = currentCourse.getCourseTime();
        CourseProperties courseProperties1 = getCourseProperties(currentCourse, currentCourseFirstDay, currentCourseTime);
        courseProperties1.getCourseTextView().setText("");
        if(currentCourse.getCourseDays().size() > 1) {
            currentCourseSecondDay = currentCourse.getCourseDays().get(1);
            CourseProperties courseProperties2 = getCourseProperties(currentCourse, currentCourseSecondDay, currentCourseTime);
            courseProperties2.getCourseTextView().setText("");
        }

//        String classCode = course.getClassId();
//        String courseFirstDay = course.getCourseDays().get(0);
//        String courseSecondDay;
//        String courseTime = course.getCourseTime();
//        if (course.getCourseDays().size() > 1) {
//            courseSecondDay = course.getCourseDays().get(1);
//            CourseProperties courseProperties1 = getCourseProperties(course, courseFirstDay, courseTime);
//            CourseProperties courseProperties2 = getCourseProperties(course, courseSecondDay, courseTime);
//            if (courseProperties1.getCourseTextView().getText().toString().equalsIgnoreCase("") &&
//                    courseProperties2.getCourseTextView().getText().toString().equalsIgnoreCase("")) {
//                courseProperties1.getCourseTextView().setText(courseName + "\n" + "کد کلاس:" + classCode);
//                courseProperties2.getCourseTextView().setText(courseName + "\n" + "کد کلاس:" + classCode);
//            }
//        } else {
//            CourseProperties courseProperties1 = getCourseProperties(course, courseFirstDay, courseTime);
//            if (courseProperties1.getCourseTextView().getText().toString().equalsIgnoreCase("")) {
//                courseProperties1.getCourseTextView().setText(courseName + "\n" + "کد کلاس:" + classCode);
//            }
//        }
    }

    private void leftOnClick(int dayTimeTag) {

    }

    private void removeOnClick(int dayTimeTag) {

    }
}
