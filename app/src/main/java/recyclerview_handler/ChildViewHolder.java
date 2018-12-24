package recyclerview_handler;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Interfaces.Mapping;
import data.CourseDetail;
import data.CourseDetailSerializable;
import ir.ambaqi.musicevent.ava.CourseDetailActivity;
import ir.ambaqi.musicevent.ava.MainPage;
import ir.ambaqi.musicevent.ava.R;
import ir.ambaqi.musicevent.ava.SelectCourseActivity;

public class ChildViewHolder extends com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
                                                        implements Mapping{
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
        final CourseDetailSerializable courseDetailSerializable = new CourseDetailSerializable();
        copyCDPToCDP(courseDetail, courseDetailSerializable);
        childLineaLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CourseDetailActivity.class);
                intent.putExtra("courseDetail", courseDetailSerializable);
                context.startActivity(intent);
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


//    private Bundle getCourseDetailContentBundle(CourseDetail courseDetail) {
//        Bundle bundle = new Bundle();
//        bundle.putString("classId", courseDetail.getClassId());
//        bundle.putString("examTime", courseDetail.getExamTime());
//        bundle.putString("examDay", courseDetail.getExamDay());
//        bundle.putString("courseTime", courseDetail.getCourseTime());
//        bundle.putStringArrayList("courseDay", courseDetail.getCourseDays());
//        bundle.putString("capacity", courseDetail.getCapacity());
//        bundle.putString("registered", courseDetail.getRegistered());
//        bundle.putString("semester", courseDetail.getSemester());
//        bundle.putString("teacherId", courseDetail.getTeacherId());
//        bundle.putString("teacherName", courseDetail.getTeacherName());
//        bundle.putString("courseId", courseDetail.getCourseId());
//        bundle.putString("courseName", courseDetail.getCourseName());
//        bundle.putString("units", courseDetail.getUnitNumber());
//        bundle.putString("havePreCourse", courseDetail.getHavePreCourse());
//        bundle.putString("havePeriCourse", courseDetail.getHavePeriCourse());
//        return bundle;
//    }
}