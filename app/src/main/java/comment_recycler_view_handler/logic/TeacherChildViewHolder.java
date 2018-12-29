package comment_recycler_view_handler.logic;


import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import comment_recycler_view_handler.data.CourseTeacherForComment;
import ir.ambaqi.musicevent.ava.CommentsDetails;
import ir.ambaqi.musicevent.ava.R;

public class TeacherChildViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder {

    private TextView teacherNameTextView;
    private LinearLayout teacherChildLineaLinearLayout;

    public TeacherChildViewHolder(View itemView) {
        super(itemView);
        teacherNameTextView = (TextView) itemView.findViewById(R.id.teacher_name_in_child_text_view);
        teacherChildLineaLinearLayout = (LinearLayout) itemView.findViewById(R.id.teacher_name_in_child_linear_layout);
    }

    public void bind(final CourseTeacherForComment courseTeacherForComment, final Context context, final String stno) {
        teacherNameTextView.setText(courseTeacherForComment.getTeacherName());
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "Fonts/Far_Naskh.ttf");
        teacherNameTextView.setTypeface(typeface);
        teacherChildLineaLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CommentsDetails.class);
                intent.putExtra("courseId", courseTeacherForComment.getCourseId());
                intent.putExtra("teacherId", courseTeacherForComment.getTeacherId());
                intent.putExtra("courseName", courseTeacherForComment.getCourseName());
                intent.putExtra("teacherName", courseTeacherForComment.getTeacherName());
                intent.putExtra("stno", stno);
                context.startActivity(intent);
            }
        });
    }
}
