package com.chen.crm.workbench.dao;

import com.chen.crm.workbench.domain.ClueRemark;

import java.util.List;

public interface ClueRemarkDao {

    List<String> getByClueId(String clueId);

    int delete(String clueId);
}
