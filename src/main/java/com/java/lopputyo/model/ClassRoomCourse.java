package com.java.lopputyo.model;

public class ClassRoomCourse extends Course {
    private String courseClassRoom;

    public ClassRoomCourse() {
        this("def", "def", "def");
    }

    public ClassRoomCourse(String courseName, String courseTeacher, String courseClassRoom) {
        super(courseName, courseTeacher);
        this.courseClassRoom = courseClassRoom;
    }

    public String getCourseClassRoom() {
        return this.courseClassRoom;
    }

    public void setCourseClassRoom(String courseClassRoom) {
        this.courseClassRoom = courseClassRoom;
    }

}
