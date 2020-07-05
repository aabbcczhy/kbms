package com.fjnu.kbms.controller;


import com.fjnu.kbms.bean.Column;
import com.fjnu.kbms.response.Response;
import com.fjnu.kbms.service.ColumnManageServiceImpl;
import com.fjnu.kbms.vo.ColumnListVO;
import com.fjnu.kbms.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Vector;

@RestController
@RequestMapping("/manager")
public class ColumnManageController {

    @Autowired
    ColumnManageServiceImpl columnManageService;

    @RequestMapping("/initable")
    public TableVO InitTable(){
        System.out.println("初始化专栏列表");
        Vector<ColumnListVO> columns=columnManageService.getAllColumn();
        return new TableVO(columns.size(),columns);
    }

    @RequestMapping("/ColumnManager")
    public ModelAndView toColumnManage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("ColumnManager");
        return mav;
    }
    @RequestMapping("/ColumnManager/AddView")
    public ModelAndView ColumnAddView(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Column_Add");
        return mav;
    }
/*
    @RequestMapping("/ColumnManager/ColumnAdd")
    public ModelAndView ColumnAdd(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Column_Add");
        return mav;
    }
*/
    @RequestMapping("/ColumnManager/ColumnEdit")
    public Response ColumnEdit(Column column){

       // return Response.create();
    }

    @RequestMapping("/ColumnManager/EditView")
    public ModelAndView ColumnEditView(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Column_Edit");
        return mav;
    }
}
