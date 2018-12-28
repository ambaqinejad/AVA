package comment_recycler_view_handler;


import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import data.comment.CourseTeacherForComment;
import ir.ambaqi.musicevent.ava.R;

public class TeacherChildViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder {

    private TextView teacherNameTextView;
    private LinearLayout teacherChildLineaLinearLayout;

    public TeacherChildViewHolder(View itemView) {
        super(itemView);
        teacherNameTextView = (TextView) itemView.findViewById(R.id.teacher_name_in_child_text_view);
        teacherChildLineaLinearLayout = (LinearLayout) itemView.findViewById(R.id.teacher_name_in_child_linear_layout);
    }

    public void bind(CourseTeacherForComment courseTeacherForComment, Context context) {
        teacherNameTextView.setText(courseTeacherForComment.getTeacherName());
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "Fonts/Far_Naskh.ttf");
        teacherNameTextView.setTypeface(typeface);
        teacherChildLineaLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
