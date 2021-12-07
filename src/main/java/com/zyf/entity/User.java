package com.zyf.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author zyf
 * @since 2021-12-05 13:13:46
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 493037757369567116L;

    private String id;

    private String username;

    private String password;

    private String gender;
}

