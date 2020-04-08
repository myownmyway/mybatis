package com.wpw.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户类
 *
 * @author wpw
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Accessors(chain = true)
public class User implements Serializable {
    private Integer id;
    private String userName;
    private Integer userAge;
    private String userAddress;
}
