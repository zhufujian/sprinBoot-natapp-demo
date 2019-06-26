package com.stduy.springBoot.bean;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import lombok.Data;

/**
 *  基础类
 * @author zhu_f
 *
 */
@Data
public abstract class BaseReq implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(notes = "日志跟踪序列号", required = false)
    protected String correlationID;//序列号
    public abstract String validateLogic();
}
