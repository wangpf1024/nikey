package com.api.validator;

import com.api.annotations.NotBlank;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.ParamValidator;
import net.paoding.rose.web.paramresolver.ParamMetaData;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;


/**
 * Created by arvin on 2015/6/24.
 * 统一的参数非空验证办法
 * @author 王鹏飞
 * @since  2015/6/24
 */
public class NotBlankParamValidator implements ParamValidator {


    public boolean supports(ParamMetaData metaData) {
        return metaData.getAnnotation(NotBlank.class) != null;
    }


    public Object validate(ParamMetaData metaData, Invocation inv, Object target, Errors errors) {
        String paramName = metaData.getParamName();
        String value = inv.getParameter(paramName);
        if (StringUtils.isBlank(value)) {
            return "@参数不能为空";
        }
        return null;
    }
}
