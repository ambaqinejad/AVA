package week_views.tuesday;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import data.CourseDetailSerializable;
import ir.ambaqi.musicevent.ava.R;
import week_views.CourseNameViews;
import week_views.LayoutHandler;

public class Tue9_10_30LayoutHandler extends LayoutHandler {
    public Tue9_10_30LayoutHandler(LinearLayout layout, CourseNameViews courseNameViews, ArrayList<CourseDetailSerializable> courseList) {
        super(layout, courseNameViews, courseList);
    }

    public void init() {
        time = (TextView) layout.findViewById(R.id.tuesday_9_10_30);
        left = (ImageButton) layout.findViewById(R.id.tue_9_10_30_left_button);
        right = (ImageButton) layout.findViewById(R.id.tue_9_10_30_right_button);
        remove = (ImageButton) layout.findViewById(R.id.tue_9_10_30_delete_button);
        if (courseList == null|| courseList.size() == 0) {
            right.setVisibility(View.INVISIBLE);
            left.setVisibility(View.INVISIBLE);
            remove.setVisibility(View.INVISIBLE);
        }
        if(courseList.size() > 0) {
            setTextForCourseNameAtFirst();setOnClickForButtons(16);
        }
    }
}
