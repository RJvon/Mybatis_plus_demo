package com.von.demo.mod.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author xueqing
 * @since 2021-07-31
 */

@EqualsAndHashCode(callSuper = false)
@Data
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Boolean sex;

    private LocalDateTime birth;

    private String tel;

    private String school;


}
