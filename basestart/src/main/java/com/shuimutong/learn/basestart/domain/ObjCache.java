package com.shuimutong.learn.basestart.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Getter
@Setter
@Table(name="obj_cache")
public class ObjCache {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="obj_id")
  private String objId;

  @Column(name="parent_obj_id")
  private String parentObjId;

  @Column(name="content")
  private String content;
}