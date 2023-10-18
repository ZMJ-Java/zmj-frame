package com.zmj.user.designPattern.templatePattern.prod;

import com.zmj.bean.Result;
import com.zmj.bean.ResultCode;

/**
 * @author ZMJ
 * @Package com.zmj.user.designPattern.templatePattern.prod
 * @date 2023/10/17 15:00
 */
public class ApiTemplate {

    public void execute(Result result, final Action action){
        try {
            action.validate();
            action.execute();
            action.after();
            result.setSuccess(true);
            result.setCode(1024);
        }catch (Exception e){
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
        }
    }

}
