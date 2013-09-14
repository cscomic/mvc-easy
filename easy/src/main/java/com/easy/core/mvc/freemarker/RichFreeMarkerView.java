/**
 * Copyright (c) 2012-2013 All Rights Reserved.
 */
package com.easy.core.mvc.freemarker;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * 增加freemarker中常量信息
 * 
 * @author wy
 * @version v 0.1 2013-6-18 上午8:33:34 wy Exp $
 */
public class RichFreeMarkerView extends FreeMarkerView {
    /**
     * 部署路径属性名称
     */
    public static final String CONTEXT_PATH = "base";

    /**
     * 在model中增加部署路径base，方便处理部署路径问题。
     */
    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request)
                                                                                       throws Exception {
        super.exposeHelpers(model, request);
        model.put(CONTEXT_PATH, request.getContextPath());
        //增加系统的配置信息
        
        
    }
}