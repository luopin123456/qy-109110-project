package com.aaa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_dict")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Dict {
    /**
     * 字典ID
     */
    @Id
    @Column(name = "DICT_ID")
    private Long dictId;

    /**
     * 键
     */
    @Column(name = "KEYY")
    private Long keyy;

    /**
     * 值
     */
    @Column(name = "VALUEE")
    private String valuee;

    /**
     * 字段名称
     */
    @Column(name = "FIELD_NAME")
    private String fieldName;

    /**
     * 表名
     */
    @Column(name = "TABLE_NAME")
    private String tableName;


}