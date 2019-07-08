package com.zym.demo.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zhuyamin
 * @Date: 2019/4/9 08 12
 */
@Entity           //是指这个类映射有数据库表
@DynamicInsert    //动态插入
@DynamicUpdate    //动态删除
@Data             //lombok工具
public class Area implements Serializable {
    /*类实现Serializable接口的目的是为了可持久化，比如网络传输或本地存储，
    为系统的分布和异构部署提供先决支持条件。若没有序列化，现在我们熟悉的远
    程调用、对象数据库都不可能存在，*/

    // 主键ID 类型用基础类型的包装类型，方便做非空的校验
    @Id
    private Integer areaId;

    // 名称
    private String areaName;

    // 权重，越大越排名靠前
    private Integer priority;

    // 创建时间
    private Date createTime;

    // 最近一次修改时间
    private Date lastEditTime;
}
