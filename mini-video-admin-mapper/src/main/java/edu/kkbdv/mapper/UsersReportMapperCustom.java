package edu.kkbdv.mapper;

import java.util.List;

import edu.kkbdv.pojo.vo.Reports;

public interface UsersReportMapperCustom {
    List<Reports> selectAllVideoReport();

    void deleteByPrimaryKey(String id);
}