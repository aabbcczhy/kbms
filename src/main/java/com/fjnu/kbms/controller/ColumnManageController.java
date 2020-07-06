package com.fjnu.kbms.controller;


import com.fjnu.kbms.bean.Column;
import com.fjnu.kbms.response.Response;
import com.fjnu.kbms.serviceimpl.ColumnManageServiceImpl;
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

    @RequestMapping("/ColumnManager/ColumnAdd")
    public Response ColumnAdd(Column column){
        if(columnManageService.columnAdd(column)==1){
            return Response.create(null,"200");
        }else{
            return Response.create(null,"500");
        }
    }



    @RequestMapping("/ColumnManager/ColumnEdit")
    public Response ColumnEdit(Column column){
        System.out.println("columnid="+column.getColumnId()+column.getColumnName()+column.getColumnDesc());
        if(columnManageService.columnEdit(column)==1){

            return Response.create(null,"200");
        }else{
            return Response.create(null,"500");
        }
        // return Response.create();
    }

    @RequestMapping("/ColumnManager/ColumnSearch")
    public Column ColumnSearch(int columnId){
        return columnManageService.columnSearch(columnId);
    }

    @RequestMapping("/ColumnManager/EditView")
    public ModelAndView ColumnEditView(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Column_Edit");
        return mav;
    }
}
