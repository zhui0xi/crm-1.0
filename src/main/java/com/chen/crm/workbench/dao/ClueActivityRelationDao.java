package com.chen.crm.workbench.dao;

import com.chen.crm.workbench.domain.ClueActivityRelation;

import java.util.List;

public interface ClueActivityRelationDao {

    List<String> getByClueId(String clueId);

    int delete(String clueId);
}
