package com.csi.service.impl;


import com.csi.dao.CourseDao;
import com.csi.domain.Course;
import com.csi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/3/27 18:06
 */

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

   @Autowired
   private CourseDao dao;

   @Override
   public List<Course> findByClass(String classroom) {
      return dao.findByClass(classroom);
   }

   @Override
   public void insert(Course course) {
      dao.insert(course);
   }

   @Override
   public void updateById(Course course) {
      dao.updateById(course);
   }
}