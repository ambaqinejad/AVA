package week_views.monday;

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

public class Mon10_30_12LayoutHandler extends LayoutHandler {
    public Mon10_30_12LayoutHandler(LinearLayout layout, CourseNameViews courseNameViews, ArrayList<CourseDetailSerializable> courseList) {
        super(layout, courseNameViews, courseList);
    }

    public void init() {
        time = (TextView) layout.findViewById(R.id.monday_10_30_12);
        left = (ImageButton) layout.findViewById(R.id.mon_10_30_12_left_button);
        right = (ImageButton) layout.findViewById(R.id.mon_10_30_12_right_button);
        remove = (ImageButton) layout.findViewById(R.id.mon_10_30_12_delete_button);
        if (courseList == null|| courseList.size() == 0 || courseList.size() == 1) {
            right.setVisibility(View.INVISIBLE);
            left.setVisibility(View.INVISIBLE);
        }
        if(courseList.size() > 0) {
            setTextForCourseNameAtFirst();
        }
    }
}
