package week_views;

import android.widget.TextView;

import java.util.ArrayList;

import select_course_recycler_view_handler.data.CourseDetailSerializable;

public class CourseNameViews {
    private ArrayList<TextView> textViewArrayList;
    private ArrayList<ArrayList<CourseDetailSerializable>> listOfCourseLists;

    public CourseNameViews(ArrayList<TextView> textViewArrayList ,
                           ArrayList<ArrayList<CourseDetailSerializable>> listOfCourseLists) {
        this.textViewArrayList = textViewArrayList;
        this.listOfCourseLists = listOfCourseLists;
    }

    public ArrayList<TextView> getTextViewArrayList() {
        return textViewArrayList;
    }

    public ArrayList<ArrayList<CourseDetailSerializable>> getListOfCourseLists() {
        return listOfCourseLists;
    }
}
