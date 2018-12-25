package recyclerview_handler;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.HashMap;

import Interfaces.Mapping;
import data.CourseDetail;
import data.CourseDetailSerializable;
import data.CourseForRecyclerView;
import ir.ambaqi.musicevent.ava.R;


public class ParentViewHolder extends GroupViewHolder implements Mapping{
    private TextView courseName;
    private TextView classID;
    private CheckBox selectCheckBox;

    public ParentViewHolder(View itemView) {
        super(itemView);
        courseName = (TextView) itemView.findViewById(R.id.course_name_parent_id);
        classID = (TextView) itemView.findViewById(R.id.class_code_parent_id);
        selectCheckBox = (CheckBox) itemView.findViewById(R.id.select_checkbox);
    }

    public void bind(CourseForRecyclerView course, final CourseDetail courseDetail, final Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "Fonts/Far_Naskh.ttf");
        courseName.setTypeface(typeface);
        classID.setTypeface(typeface);
        courseName.setText(course.getTitle());
        classID.setText("کد کلاس: "+courseDetail.getClassId());
        final CourseDetailSerializable courseDetailSerializable = new CourseDetailSerializable();
        copyCDPToCDP(courseDetail, courseDetailSerializable);
        selectCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    ClassesHashMap.selectedClasses.put(courseDetail.getClassId(), courseDetailSerializable);
                    Log.v("amanamanama", ClassesHashMap.selectedClasses.size()+"");
                }
                else
                    ClassesHashMap.selectedClasses.remove(courseDetail.getClassId());
            }
        });
    }

    @Override
    public void copyCDPToCDP(CourseDetail courseDetail, CourseDetailSerializable courseDetailSerializable) {
        courseDetailSerializable.setClassId(courseDetail.getClassId());
        courseDetailSerializable.setExamTime(courseDetail.getExamTime());
        courseDetailSerializable.setExamDay(courseDetail.getExamDay());
        courseDetailSerializable.setCourseTime(courseDetail.getCourseTime());
        courseDetailSerializable.setCourseDays(courseDetail.getCourseDays());
        courseDetailSerializable.setCapacity(courseDetail.getCapacity());
        courseDetailSerializable.setRegistered(courseDetail.getRegistered());
        courseDetailSerializable.setSemester(courseDetail.getSemester());
        courseDetailSerializable.setTeacherId(courseDetail.getTeacherId());
        courseDetailSerializable.setTeacherName(courseDetail.getTeacherName());
        courseDetailSerializable.setCourseId(courseDetail.getCourseId());
        courseDetailSerializable.setCourseName(courseDetail.getCourseName());
        courseDetailSerializable.setUnitNumber(courseDetail.getUnitNumber());
        courseDetailSerializable.setHavePreCourse(courseDetail.getHavePreCourse());
        courseDetailSerializable.setHavePeriCourse(courseDetail.getHavePeriCourse());
    }
}
