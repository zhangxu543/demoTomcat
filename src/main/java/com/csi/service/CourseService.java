package com.csi.service;

import com.csi.domain.Course;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 18:06
 */

public interface CourseService {
   List<Course> findByClass(String classroom);
   void insert(Course course);
   void updateById(Course course);
}