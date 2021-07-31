package com.von.demo.mod.service.impl;

import com.von.demo.mod.entity.Employees;
import com.von.demo.mod.mapper.EmployeesMapper;
import com.von.demo.mod.service.IEmployeesService;
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
public class EmployeesServiceImpl extends ServiceImpl<EmployeesMapper, Employees> implements IEmployeesService {

}
