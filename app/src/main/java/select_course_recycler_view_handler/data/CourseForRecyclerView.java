package select_course_recycler_view_handler.data;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

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
