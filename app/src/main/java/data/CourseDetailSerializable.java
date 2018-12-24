package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class CourseDetailSerializable implements Serializable{

    private static final long serialVersionUID = 1L;
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
        this.courseDays = courseDays;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseDetailSerializable that = (CourseDetailSerializable) o;
        return classId.equalsIgnoreCase(that.classId) &&
                examTime.equalsIgnoreCase(that.examTime) &&
                examDay.equalsIgnoreCase(that.examDay) &&
                courseTime.equalsIgnoreCase(that.courseTime) &&
                courseDays.equals(that.courseDays) &&
                capacity.equalsIgnoreCase(that.capacity) &&
                registered.equalsIgnoreCase(that.registered) &&
                semester.equalsIgnoreCase(that.semester) &&
                teacherId.equalsIgnoreCase(that.teacherId) &&
                teacherName.equalsIgnoreCase(that.teacherName) &&
                courseId.equalsIgnoreCase(that.courseId) &&
                courseName.equalsIgnoreCase(that.courseName) &&
                unitNumber.equalsIgnoreCase(that.unitNumber) &&
                havePreCourse.equalsIgnoreCase(that.havePreCourse) &&
                havePeriCourse.equalsIgnoreCase(that.havePeriCourse);
    }

    @Override
    public int hashCode() {

        return Objects.hash(classId, examTime, examDay, courseTime, courseDays, capacity, registered, semester, teacherId, teacherName, courseId, courseName, unitNumber, havePreCourse, havePeriCourse);
    }
}
