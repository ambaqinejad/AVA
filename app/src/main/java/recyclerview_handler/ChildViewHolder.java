package recyclerview_handler;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import data.CourseDetail;
import ir.ambaqi.musicevent.ava.CourseDetailActivity;
import ir.ambaqi.musicevent.ava.R;
import ir.ambaqi.musicevent.ava.SelectCourseActivity;

public class ChildViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder {
    private TextView teacherName;
    private LinearLayout childLineaLinearLayout;
    public ChildViewHolder(View itemView) {
        super(itemView);
        teacherName = (TextView) itemView.findViewById(R.id.teacher_name_in_child);
        childLineaLinearLayout = (LinearLayout) itemView.findViewById(R.id.child_linear_layout);
    }

    public void bind(final CourseDetail courseDetail, final Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "Fonts/Far_Naskh.ttf");
        teacherName.setTypeface(typeface);
        teacherName.setText(courseDetail.getTeacherName());
        childLineaLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CourseDetailActivity.class);
                intent.putExtra("CourseDetail", courseDetail);
                context.startActivity(intent);
            }
        });
    }
}