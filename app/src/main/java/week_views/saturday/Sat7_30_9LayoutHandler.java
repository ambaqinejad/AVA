package week_views.saturday;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import select_course_recycler_view_handler.data.CourseDetailSerializable;
import ir.ambaqi.musicevent.ava.R;
import week_views.CourseNameViews;
import week_views.LayoutHandler;

public class Sat7_30_9LayoutHandler extends LayoutHandler {

    public Sat7_30_9LayoutHandler(LinearLayout layout, CourseNameViews courseNameViews, ArrayList<CourseDetailSerializable> courseList) {
        super(layout, courseNameViews, courseList);
    }

    public void init() {
        time = (TextView) layout.findViewById(R.id.saturday_7_30_9);
        left = (ImageButton) layout.findViewById(R.id.sat_7_30_9_left_button);
        right = (ImageButton) layout.findViewById(R.id.sat_7_30_9_right_button);
        remove = (ImageButton) layout.findViewById(R.id.sat_7_30_9_delete_button);
        if (courseList == null|| courseList.size() == 0) {
            right.setVisibility(View.INVISIBLE);
            left.setVisibility(View.INVISIBLE);
            remove.setVisibility(View.INVISIBLE);
        }
        if(courseList.size() > 0) {
            setTextForCourseNameAtFirst();
            setOnClickForButtons(0);
        }

    }
}
