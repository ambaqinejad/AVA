package recyclerview_handler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import data.CourseDetail;
import data.CourseForRecyclerView;
import ir.ambaqi.musicevent.ava.R;

public class ChildAdapter extends ExpandableRecyclerViewAdapter<ParentViewHolder, ChildViewHolder> {

    Context context;
    public ChildAdapter(List<? extends ExpandableGroup> groups, Context context) {
        super(groups);
        this.context = context;
    }

    @Override
    public ParentViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_title_in_recycler_view_as_parent,parent,false);
        return new ParentViewHolder(view);
    }

    @Override
    public ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_detail_in_rcycler_view_as_child, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final CourseDetail courseDetail = (CourseDetail) group.getItems().get(childIndex);
        holder.bind(courseDetail, context);
    }

    @Override
    public void onBindGroupViewHolder(ParentViewHolder holder, int flatPosition, ExpandableGroup group) {
        final CourseForRecyclerView courseForRecyclerView = (CourseForRecyclerView) group;
        CourseDetail courseDetail = courseForRecyclerView.getCourseDetail();
        holder.bind(courseForRecyclerView, courseDetail, context);
    }
}
