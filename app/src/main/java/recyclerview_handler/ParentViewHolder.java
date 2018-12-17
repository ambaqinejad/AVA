package recyclerview_handler;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.HashMap;

import data.CourseDetail;
import data.CourseForRecyclerView;
import ir.ambaqi.musicevent.ava.R;


public class ParentViewHolder extends GroupViewHolder {
    private TextView courseName;
    private CheckBox selectCheckBox;
    public static HashMap<String, CourseDetail> selectedClasses = new HashMap<>();
    public ParentViewHolder(View itemView) {
        super(itemView);
        courseName = (TextView) itemView.findViewById(R.id.course_name_parent_id);
        selectCheckBox = (CheckBox) itemView.findViewById(R.id.select_checkbox);
    }

    public void bind(CourseForRecyclerView course, final CourseDetail courseDetail, final Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "Fonts/Far_Naskh.ttf");
        courseName.setTypeface(typeface);
        courseName.setText(course.getTitle());
        selectCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    selectedClasses.put(courseDetail.getClassId(), courseDetail);
                else
                    selectedClasses.remove(courseDetail.getClassId());
            }
        });
    }
}
