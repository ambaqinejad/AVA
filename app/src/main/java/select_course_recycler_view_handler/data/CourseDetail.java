package select_course_recycler_view_handler.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class CourseDetail implements Parcelable {
    private String classId;
    private String examTime;
    private String examDay;
    private String courseTime;
    private ArrayList<String> courseDays;
    private String capacity;
    private String registered;
    private String semester;
    private String teacherId;
    private String teacherName;
    private String courseId;
    private String courseName;
    private String unitNumber;
    private String havePreCourse;
    private String havePeriCourse;

    public CourseDetail() {

    }

    protected CourseDetail(Parcel in) {
        this.classId = in.readString();
        this.examTime = in.readString();
        this.examDay = in.readString();
        this.courseTime = in.readString();
        this.courseDays = new ArrayList<>();
        this.courseDays = in.readArrayList(String.class.getClassLoader());
        this.capacity = in.readString();
        this.semester = in.readString();
        this.teacherId = in.readString();
        this.teacherName = in.readString();
        this.courseId = in.readString();
        this.courseName = in.readString();
        this.unitNumber = in.readString();
        this.havePreCourse = in.readString();
        this.havePeriCourse = in.readString();
        this.registered = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(classId);
        dest.writeString(examTime);
        dest.writeString(examDay);
        dest.writeString(courseTime);
        dest.writeStringList(courseDays);
        dest.writeString(capacity);
        dest.writeString(semester);
        dest.writeString(teacherId);
        dest.writeString(teacherName);
        dest.writeString(courseId);
        dest.writeString(courseName);
        dest.writeString(unitNumber);
        dest.writeString(havePreCourse);
        dest.writeString(havePeriCourse);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CourseDetail> CREATOR = new Creator<CourseDetail>() {
        @Override
        public CourseDetail createFromParcel(Parcel in) {
            return new CourseDetail(in);
        }

        @Override
        public CourseDetail[] newArray(int size) {
            return new CourseDetail[size];
        }
    };

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public String getExamDay() {
        return examDay;
    }

    public void setExamDay(String examDay) {
        this.examDay = examDay;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public ArrayList<String> getCourseDays() {
        return courseDays;
    }

    public void setCourseDays(ArrayList<String> courseDays) {
        this.courseDays = new ArrayList<>();
        this.courseDays = courseDays;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getHavePreCourse() {
        return havePreCourse;
    }

    public void setHavePreCourse(String havePreCourse) {
        this.havePreCourse = havePreCourse;
    }

    public String getHavePeriCourse() {
        return havePeriCourse;
    }

    public void setHavePeriCourse(String havePeriCourse) {
        this.havePeriCourse = havePeriCourse;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }
}
