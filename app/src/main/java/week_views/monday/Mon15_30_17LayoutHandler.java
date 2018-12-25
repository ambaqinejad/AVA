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

public class Mon15_30_17LayoutHandler extends LayoutHandler {
    public Mon15_30_17LayoutHandler(LinearLayout layout, CourseNameViews courseNameViews, ArrayList<CourseDetailSerializable> courseList) {
        super(layout, courseNameViews, courseList);
    }

    public void init() {
        time = (TextView) layout.findViewById(R.id.monday_15_30_17);
        left = (ImageButton) layout.findViewById(R.id.mon_15_30_17_left_button);
        right = (ImageButton) layout.findViewById(R.id.mon_15_30_17_right_button);
        remove = (ImageButton) layout.findViewById(R.id.mon_15_30_17_delete_button);
        if (courseList == null|| courseList.size() == 0) {
            right.setVisibility(View.INVISIBLE);
            left.setVisibility(View.INVISIBLE);
            remove.setVisibility(View.INVISIBLE);
        }
        if(courseList.size() > 0) {
            setTextForCourseNameAtFirst();
            setOnClickForButtons(14);
        }
    }
}
