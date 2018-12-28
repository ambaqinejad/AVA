package data.comment;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import data.comment.CourseTeacherForComment;

public class CourseNameForCommentRecyclerView extends ExpandableGroup<CourseTeacherForComment> {

    public CourseNameForCommentRecyclerView(String title, List<CourseTeacherForComment> items) {
        super(title, items);
    }
}
