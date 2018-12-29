package comment_recycler_view_handler.data;

import android.os.Parcel;
import android.os.Parcelable;

public class CourseTeacherForComment implements Parcelable{

    private String courseId;
    private String courseName;
    private String teacherId;
    private String teacherName;

    public CourseTeacherForComment() {

    }

    public CourseTeacherForComment(String courseId, String courseName, String teacherId, String teacherName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

    protected CourseTeacherForComment(Parcel in) {
        this.courseId = in.readString();
        this.courseName = in.readString();
        this.teacherId = in.readString();
        this.teacherName = in.readString();
    }

    public static final Creator<CourseTeacherForComment> CREATOR = new Creator<CourseTeacherForComment>() {
        @Override
        public CourseTeacherForComment createFromParcel(Parcel in) {
            return new CourseTeacherForComment(in);
        }

        @Override
        public CourseTeacherForComment[] newArray(int size) {
            return new CourseTeacherForComment[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public static Creator<CourseTeacherForComment> getCREATOR() {
        return CREATOR;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
