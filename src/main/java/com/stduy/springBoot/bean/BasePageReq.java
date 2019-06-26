package com.stduy.springBoot.bean;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页基础类
 * @author zhu_f
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BasePageReq extends BaseReq {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 查询开始时间
     */
    @ApiModelProperty(notes = "查询开始时间", required = false)
    protected Date startTime;
    /**
     * 查询结束时间
     */
    @ApiModelProperty(notes = "查询结束时间", required = false)
    protected Date endTime;
    /**
     * 分页起始位置，默认值"0"
     */
    @ApiModelProperty(notes = "分页起始位置，默认值'0'", required = false)
    protected int start = 0;
    /**
     * 分页大小，默认值"10"
     */
    @ApiModelProperty(notes = "分页大小，默认值'10'", required = false)
    protected int size = 10;

    /**
     * 查询时间参数标识 "1" 根据创建时间条件查询；"2"根据发布时间条件查询 ，默认值"1"
     */
    @ApiModelProperty(notes = "查询时间参数标识 '1' 根据创建时间条件查询；'2'根据发布时间条件查询 ，默认值'1'", required = false)
    protected String selectTimeFlag;
}
