package week_views.tuesday;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import select_course_recycler_view_handler.data.CourseDetailSerializable;
import ir.ambaqi.musicevent.ava.R;
import week_views.CourseNameViews;
import week_views.LayoutHandler;

public class Tue13_30_15LayoutHandler extends LayoutHandler {
    public Tue13_30_15LayoutHandler(LinearLayout layout, CourseNameViews courseNameViews, ArrayList<CourseDetailSerializable> courseList) {
        super(layout, courseNameViews, courseList);
    }

    public void init() {
        time = (TextView) layout.findViewById(R.id.tuesday_13_30_15);
        left = (ImageButton) layout.findViewById(R.id.tue_13_30_15_left_button);
        right = (ImageButton) layout.findViewById(R.id.tue_13_30_15_right_button);
        remove = (ImageButton) layout.findViewById(R.id.tue_13_30_15_delete_button);
        if (courseList == null|| courseList.size() == 0) {
            right.setVisibility(View.INVISIBLE);
            left.setVisibility(View.INVISIBLE);
            remove.setVisibility(View.INVISIBLE);
        }
        if(courseList.size() > 0) {
            setTextForCourseNameAtFirst();
            setOnClickForButtons(18);
        }
    }
}
