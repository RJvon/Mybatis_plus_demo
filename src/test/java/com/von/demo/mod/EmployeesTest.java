package com.von.demo.mod;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.von.demo.mod.entity.Employees;
import com.von.demo.mod.mapper.EmployeesMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

/**
 * @author xueqing f
 * @version 1.0
 * @date 2021/7/31 17:15
 */
@SpringBootTest
public class EmployeesTest {
    @Autowired
    EmployeesMapper employeesMapper;

    @Test
    public void getSelect1() {
        System.out.println(employeesMapper.selectById(101));
    }

    @Test
    public void getSelect2() {
        List<Employees> employees = employeesMapper.selectBatchIds(Arrays.asList(101, 102, 103));
        for (Employees employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void insertTest1() {
        Employees employees = new Employees();
        employees.setId(109);
        employees.setBirth(LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56));
        employees.setName("冯北航");
        employees.setSex(false);
        employees.setSchool("北京航空航天大学");
        employees.setTel("12345678910");
        int insert = employeesMapper.insert(employees);
        System.out.println(employees);
        System.out.println("=======================");
        System.out.println(insert);
        System.out.println("=======================");
    }

    @Test
    public void deleteTest() {
        Employees employees = new Employees();
        employees.setId(110);
        employees.setBirth(LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56));
        employees.setName("陈中山");
        employees.setSex(false);
        employees.setSchool("中山大学");
        employees.setTel("12345676910");
        int insert = employeesMapper.insert(employees);
        if (insert == 1) {
            System.out.println(employees);
        }
        int i = employeesMapper.deleteById(110);
        System.out.println("=======================");
        System.out.println(insert);
        System.out.println(i);
        System.out.println("=======================");
    }
    @Test
    public void updateTest(){
        Employees employees = new Employees();
        employees.setId(101);
        employees.setTel("00000000000");
        int i = employeesMapper.updateById(employees);
        System.out.println(i);
    }

    // 条件构造器
    /*
        查询名字叫王某某且性别为男的人
    */
    @Test
    public void selectWrapper01() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.likeRight("name", "王");
        queryWrapper.eq("sex", true);
        List list = employeesMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    /**
     * 查询姓赵的，出生日期在1995-10-1-14-46-56到2019-10-1-14-46-56出生的人
     */
    @Test
    public void selectWrapper02() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.likeRight("name", "赵");
        LocalDateTime time1 = LocalDateTime.of(1995, Month.SEPTEMBER, 10, 14, 46, 56);
        LocalDateTime time2 = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56);
        queryWrapper.between("birth", time1, time2);
        List list = employeesMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }
    /**
     * 查询姓李的，电话号码不为空的人
     */
    @Test
    public void selectWrapper03() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.likeRight("name", "李");
        queryWrapper.isNotNull("tel");
        List list = employeesMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }
}
