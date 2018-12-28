package comment_recycler_view_handler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import data.comment.CourseNameForCommentRecyclerView;
import data.comment.CourseTeacherForComment;
import ir.ambaqi.musicevent.ava.R;

public class CourseTeacherChildAdapter extends ExpandableRecyclerViewAdapter<CourseParentViewHolder, TeacherChildViewHolder> {


    private Context context;
    public CourseTeacherChildAdapter(List<? extends ExpandableGroup> groups, Context context) {
        super(groups);
        this.context = context;
    }

    @Override
    public CourseParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_name_for_comment_recycler_view_as_parent
                                ,parent, false);
        return new CourseParentViewHolder(view);
    }

    @Override
    public TeacherChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teacher_title_for_comment_recycler_view_as_child,
                parent, false);
        parent.removeView(view);
        return new TeacherChildViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(TeacherChildViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        CourseTeacherForComment courseTeacherForComment = (CourseTeacherForComment) group.getItems().get(childIndex);
        holder.bind(courseTeacherForComment, context);
    }

    @Override
    public void onBindGroupViewHolder(CourseParentViewHolder holder, int flatPosition, ExpandableGroup group) {
        CourseNameForCommentRecyclerView courseNameForCommentRecyclerView = (CourseNameForCommentRecyclerView) group;
        holder.bind(courseNameForCommentRecyclerView.getTitle(), context);
    }
}
