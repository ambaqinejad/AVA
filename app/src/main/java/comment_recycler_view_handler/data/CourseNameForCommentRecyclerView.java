package comment_recycler_view_handler.data;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class CourseNameForCommentRecyclerView extends ExpandableGroup<CourseTeacherForComment> {

    public CourseNameForCommentRecyclerView(String title, List<CourseTeacherForComment> items) {
        super(title, items);
    }
}
