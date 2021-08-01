package com.von.demo.mod.service.impl;

import com.von.demo.mod.entity.Student;
import com.von.demo.mod.mapper.StudentMapper;
import com.von.demo.mod.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xueqing
 * @since 2021-07-31
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
