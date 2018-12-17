package data;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;
import java.util.List;

public class CourseForRecyclerView extends ExpandableGroup<CourseDetail>{

    public CourseDetail getCourseDetail() {
        return courseDetail;
    }

    CourseDetail courseDetail;
    public CourseForRecyclerView(String title, List<CourseDetail> items) {
        super(title, items);
        courseDetail = items.get(0);
    }
}
