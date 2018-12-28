package Interfaces;

import data.select_course.CourseDetail;
import data.select_course.CourseDetailSerializable;

public interface Mapping {
    void copyCDPToCDP(CourseDetail courseDetail, CourseDetailSerializable courseDetailSerializable);
}
