package com.aaa.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class TokeVo implements Serializable {
    private String toke;
    private Boolean ifSuccess;
    /**
     * 1账号不存在
     * 2 密码错
     *3 账号被锁定
     * 4 系统异常
     */
    private Integer type;
}
