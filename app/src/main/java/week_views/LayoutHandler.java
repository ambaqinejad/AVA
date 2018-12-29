package week_views;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import select_course_recycler_view_handler.data.CourseDetailSerializable;

public abstract class LayoutHandler {
    protected int currentItemIndex;
    protected LinearLayout layout;
    protected TextView time;
    protected ImageButton left, right, remove;
    protected CourseNameViews courseNameViews;
    protected ArrayList<CourseDetailSerializable> courseList;

    //parent
    public LayoutHandler(LinearLayout layout, CourseNameViews courseNameViews,
                         ArrayList<CourseDetailSerializable> courseList) {
        this.currentItemIndex = 0;
        this.layout = layout;
        this.courseNameViews = courseNameViews;
        this.courseList = courseList;
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
            if (getCourseTextView(courseFirstDay, courseTime).getText().toString().equalsIgnoreCase("") &&
                    getCourseTextView(courseSecondDay, courseTime).getText().toString().equalsIgnoreCase("")){
                getCourseTextView(courseFirstDay, courseTime).setText(courseName + "\n" + "کد کلاس:" + classCode);
                getCourseTextView(courseSecondDay, courseTime).setText(courseName + "\n" + "کد کلاس:" + classCode);
                int tag1 = (int) getCourseTextView(courseSecondDay, courseTime).getTag();
                int tag2 = (int) getCourseTextView(courseFirstDay, courseTime).getTag();
                getCourseTextView(courseFirstDay, courseTime).setTag(tag1);
                getCourseTextView(courseSecondDay, courseTime).setTag(tag2);
            }
        } else {
            if (getCourseTextView(courseFirstDay, courseTime).getText().toString().equalsIgnoreCase("")) {
                getCourseTextView(courseFirstDay, courseTime).setText(courseName + "\n" + "کد کلاس:" + classCode);
            }
        }
    }

    public TextView getCourseTextView(String day, String courseTime) {
        if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("7:30"))
            return  courseNameViews.getTextViewArrayList().get(0);
        else if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("9"))
            return courseNameViews.getTextViewArrayList().get(1);
        else if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("10:30"))
            return courseNameViews.getTextViewArrayList().get(2);
        else if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("13:30"))
            return courseNameViews.getTextViewArrayList().get(3);
        else if (day.equalsIgnoreCase("0") && courseTime.equalsIgnoreCase("15:30"))
            return courseNameViews.getTextViewArrayList().get(4);
        else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("7:30"))
            return courseNameViews.getTextViewArrayList().get(5);
        else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("9"))
            return courseNameViews.getTextViewArrayList().get(6);
        else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("10:30"))
            return courseNameViews.getTextViewArrayList().get(7);
        else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("13:30"))
            return courseNameViews.getTextViewArrayList().get(8);
        else if (day.equalsIgnoreCase("1") && courseTime.equalsIgnoreCase("15:30"))
            return courseNameViews.getTextViewArrayList().get(9);
        else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("7:30"))
            return courseNameViews.getTextViewArrayList().get(10);
        else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("9"))
            return courseNameViews.getTextViewArrayList().get(11);
        else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("10:30"))
            return courseNameViews.getTextViewArrayList().get(12);
        else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("13:30"))
            return courseNameViews.getTextViewArrayList().get(13);
        else if (day.equalsIgnoreCase("2") && courseTime.equalsIgnoreCase("15:30"))
            return courseNameViews.getTextViewArrayList().get(14);
        else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("7:30"))
            return courseNameViews.getTextViewArrayList().get(15);
        else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("9"))
            return courseNameViews.getTextViewArrayList().get(16);
        else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("10:30"))
            return courseNameViews.getTextViewArrayList().get(17);
        else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("13:30"))
            return courseNameViews.getTextViewArrayList().get(18);
        else if (day.equalsIgnoreCase("3") && courseTime.equalsIgnoreCase("15:30"))
            return courseNameViews.getTextViewArrayList().get(19);
        else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("7:30"))
            return courseNameViews.getTextViewArrayList().get(20);
        else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("9"))
            return courseNameViews.getTextViewArrayList().get(21);
        else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("10:30"))
            return courseNameViews.getTextViewArrayList().get(22);
        else if (day.equalsIgnoreCase("4") && courseTime.equalsIgnoreCase("13:30"))
            return courseNameViews.getTextViewArrayList().get(23);
        else
            return courseNameViews.getTextViewArrayList().get(24);
    }


    protected void setOnClickForButtons(int timeIndex) {
        leftOnClick();
        rightOnClick();
        removeOnClick(timeIndex);
    }

    private void rightOnClick() {
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //removeCurrentText();
                currentItemIndex++;
                if (currentItemIndex == courseList.size())
                    currentItemIndex = 0;
                setNextText();
            }
        });
    }

    private void leftOnClick() {
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentItemIndex--;
                if (currentItemIndex == -1)
                    currentItemIndex = courseList.size() - 1;
                setNextText();
            }
        });
    }

    private void removeOnClick(final int timeIndex) {
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseNameViews.getTextViewArrayList().get(timeIndex).setText("");
                int secondTextViewTag = (int) courseNameViews.getTextViewArrayList().get(timeIndex).getTag();
                courseNameViews.getTextViewArrayList().get(secondTextViewTag).setText("");
            }
        });
    }

    private void setNextText() {
        CourseDetailSerializable nextCourse;
        nextCourse = courseList.get(currentItemIndex);
        String nextCourseFirstDay = nextCourse.getCourseDays().get(0);
        String nextCourseSecondDay = "";
        String nextCourseTime = nextCourse.getCourseTime();
        String courseName = nextCourse.getCourseName();
        String classCode = nextCourse.getClassId();
        int whomDoesFirstDayTextViewSee = (int) getCourseTextView(nextCourseFirstDay, nextCourseTime).getTag();
        int firstDayTextViewRealTag = (int) courseNameViews.getTextViewArrayList().get(whomDoesFirstDayTextViewSee).getTag();
        getCourseTextView(nextCourseFirstDay, nextCourseTime).setTag(firstDayTextViewRealTag);
        getTextViewByTag(whomDoesFirstDayTextViewSee).setTag(whomDoesFirstDayTextViewSee);
        getTextViewByTag(whomDoesFirstDayTextViewSee).setText("");
        if(nextCourse.getCourseDays().size() > 1) {
            int whomDoesSecondDayTextViewSee;
            nextCourseSecondDay = nextCourse.getCourseDays().get(1);
            whomDoesSecondDayTextViewSee = (int) getCourseTextView(nextCourseSecondDay, nextCourseTime).getTag();
            int secondDayTextViewRealTag = (int) courseNameViews.getTextViewArrayList().get(whomDoesSecondDayTextViewSee).getTag();
            getCourseTextView(nextCourseSecondDay, nextCourseTime).setTag(secondDayTextViewRealTag);
            getTextViewByTag(whomDoesSecondDayTextViewSee).setTag(whomDoesSecondDayTextViewSee);
            getTextViewByTag(whomDoesSecondDayTextViewSee).setText("");
        }
        getCourseTextView(nextCourseFirstDay, nextCourseTime).setText(courseName + "\n" + "کد کلاس:" + classCode);
        if (nextCourse.getCourseDays().size() > 1) {
            getCourseTextView(nextCourseSecondDay, nextCourseTime).setText(courseName + "\n" + "کد کلاس:" + classCode);
            int firstDayNewTag = (int) getCourseTextView(nextCourseSecondDay, nextCourseTime).getTag();
            int secondDayNewTag = (int) getCourseTextView(nextCourseFirstDay, nextCourseTime).getTag();
            getCourseTextView(nextCourseFirstDay, nextCourseTime).setTag(firstDayNewTag);
            getCourseTextView(nextCourseSecondDay, nextCourseTime).setTag(secondDayNewTag);
        }
    }

    private TextView getTextViewByTag(int tag) {
        return courseNameViews.getTextViewArrayList().get(tag);
    }
}
