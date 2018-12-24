package Interfaces;

import data.CourseDetail;
import data.CourseDetailSerializable;

public interface Mapping {
    void copyCDPToCDP(CourseDetail courseDetail, CourseDetailSerializable courseDetailSerializable);
}
