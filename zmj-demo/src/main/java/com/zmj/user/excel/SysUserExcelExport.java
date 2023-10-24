package com.zmj.user.excel;

import com.zmj.bean.PageResponse;
import com.zmj.tool.excel.BaseEasyExcelExport;
import com.zmj.user.entity.SysUser;
import com.zmj.user.entity.req.SysUserReq;
import com.zmj.user.service.SysUserService;
import org.apache.commons.collections4.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author ZMJ
 * @Package com.zmj.user.excel
 * @date 2023/10/24 19:21
 */
public class SysUserExcelExport extends BaseEasyExcelExport {

    @Resource
    private SysUserService sysUserService;

    @Override
    protected List<List<String>> getExcelHead() {
        List<List<String>> head = new ArrayList<>();
        head.add(Collections.singletonList("用户编号"));
        head.add(Collections.singletonList("用户姓名"));
        return head;
    }

    @Override
    protected Long eachSheetTotalCount() {
        return 5000L;
    }

    @Override
    protected Long eachTimesWriteSheetTotalCount() {
        return 2000L;
    }

    @Override
    protected void buildDataList(List resultList, Map queryCondition, Long pageNo, Long pageSize) {
        SysUserReq sysUserReq = new SysUserReq();
        //可以根据condition设置条件
        sysUserReq.setPageNo(pageNo);
        sysUserReq.setPageSize(pageSize);
        PageResponse<SysUser> pageResponse = sysUserService.queryByPage(sysUserReq);
        List<SysUser> sysUserList = pageResponse.getResult();
        if (CollectionUtils.isNotEmpty(sysUserList)) {
            sysUserList.forEach(sysUser -> {
                resultList.add(Arrays.asList(sysUser.getId().toString(), sysUser.getName()));
            });
        }
    }

    @Override
    protected Long dataTotalCount(Map conditions) {
        return sysUserService.queryCount(conditions);
    }
}
