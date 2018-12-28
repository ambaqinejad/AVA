package comment_recycler_view_handler;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import ir.ambaqi.musicevent.ava.R;

public class CourseParentViewHolder  extends GroupViewHolder {

    private TextView courseNameTextView;


    public CourseParentViewHolder(View itemView) {
        super(itemView);
        courseNameTextView = (TextView) itemView.findViewById(R.id.course_name_comment_parent_id);
    }

    public void bind(String courseName, Context context) {
        courseNameTextView.setText(courseName);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "Fonts/Far_Naskh.ttf");
        courseNameTextView.setTypeface(typeface);
    }
}
