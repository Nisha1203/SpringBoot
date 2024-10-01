package com.luv2code.curddemo.dao;

import com.luv2code.curddemo.entity.Instructor;

public interface AppDao {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
