package com.atguigu.springcloud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Beacon
 */
@Data
public class Payment implements Serializable {
    /**主键id*/
    private Long id;
    /**流水号*/
    private String serial;
}