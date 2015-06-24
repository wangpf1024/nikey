package com.api.controllers;

import com.api.bean.Visitor;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.paramresolver.ParamMetaData;
import net.paoding.rose.web.paramresolver.ParamResolver;

/**
 * Created by arvin on 2015/6/24.
 *
 */
public class VisitorBeanResolver implements ParamResolver {

    public boolean supports(ParamMetaData metaData) {
        return Visitor.class == metaData.getParamType();
    }

    public Object resolve(Invocation inv, ParamMetaData metaData) throws Exception {

        for (String paramName : metaData.getParamNames()) {
            if (paramName != null) {
                Visitor visitor = new Visitor();
                String value1 = inv.getParameter("name");
                visitor.setName(value1);
                return visitor;
            }
        }
        return null;
    }
}
