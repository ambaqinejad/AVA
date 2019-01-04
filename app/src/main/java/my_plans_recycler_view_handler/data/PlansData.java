package my_plans_recycler_view_handler.data;

import java.io.Serializable;
import java.util.ArrayList;

import select_course_recycler_view_handler.data.CourseDetailSerializable;

public class PlansData implements Serializable {
    private String planId;
    private ArrayList<CourseDetailSerializable> courses;

    public PlansData() {
        courses = new ArrayList<>();
    }

    public PlansData(String planId, ArrayList<CourseDetailSerializable> courses) {
        this.planId = planId;
        this.courses = courses;
    }

    public String getPlanId() {
        return planId;
    }

    public ArrayList<CourseDetailSerializable> getCourses() {
        return courses;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public void setCourses(ArrayList<CourseDetailSerializable> courses) {
        this.courses = courses;
    }
}
