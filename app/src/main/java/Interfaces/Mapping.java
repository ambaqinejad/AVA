package Interfaces;

import select_course_recycler_view_handler.data.CourseDetail;
import select_course_recycler_view_handler.data.CourseDetailSerializable;

public interface Mapping {
    void copyCDPToCDP(CourseDetail courseDetail, CourseDetailSerializable courseDetailSerializable);
}
