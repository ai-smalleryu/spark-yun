package com.isxcode.star.modules.work.mapper;

import com.alibaba.fastjson.JSON;
import com.isxcode.star.api.instance.pojos.res.QueryInstanceRes;
import com.isxcode.star.api.work.pojos.req.AddWorkReq;
import com.isxcode.star.api.work.pojos.req.UpdateWorkReq;
import com.isxcode.star.api.work.pojos.res.PageWorkRes;
import com.isxcode.star.modules.work.entity.WorkEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Map;

@Mapper(componentModel = "spring")
public interface WorkMapper {

    WorkEntity addWorkReqToWorkEntity(AddWorkReq addWorkReq);

    @Mapping(source = "updateWorkReq.remark", target = "remark")
    @Mapping(source = "updateWorkReq.name", target = "name")
    @Mapping(source = "workEntity.id", target = "id")
    @Mapping(source = "workEntity.workType", target = "workType")
    WorkEntity updateWorkReqToWorkEntity(UpdateWorkReq updateWorkReq, WorkEntity workEntity);

    @Mapping(target = "createDateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    PageWorkRes workEntityToPageWorkRes(WorkEntity workEntity);

    default QueryInstanceRes mapToWoiQueryInstanceRes(Map map) {

        return JSON.parseObject(JSON.toJSONString(map), QueryInstanceRes.class);
    }
}
