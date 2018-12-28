package data.select_course;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import data.select_course.CourseDetail;

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
