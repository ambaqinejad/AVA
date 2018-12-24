package week_views.wednesday;

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

public class Wed13_30_15LayoutHandler extends LayoutHandler {
    public Wed13_30_15LayoutHandler(LinearLayout layout, CourseNameViews courseNameViews, ArrayList<CourseDetailSerializable> courseList) {
        super(layout, courseNameViews, courseList);
    }

    public void init() {
        time = (TextView) layout.findViewById(R.id.wednesday_13_30_15);
        left = (ImageButton) layout.findViewById(R.id.wed_13_30_15_left_button);
        right = (ImageButton) layout.findViewById(R.id.wed_13_30_15_right_button);
        remove = (ImageButton) layout.findViewById(R.id.wed_13_30_15_delete_button);
        if (courseList == null|| courseList.size() == 0 || courseList.size() == 1) {
            right.setVisibility(View.INVISIBLE);
            left.setVisibility(View.INVISIBLE);
        }
        if(courseList.size() > 0) {
            setTextForCourseNameAtFirst();
        }
    }
}
