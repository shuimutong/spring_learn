package com.shuimutong.learn.mybatis.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class User {
  private Long id;

  private String name;

  private Integer age;

}