package com.fjnu.kbms.controller;

import com.fjnu.kbms.bean.Type;
import com.fjnu.kbms.response.Response;
import com.fjnu.kbms.serviceimpl.TypeManageServiceImpl;
import com.fjnu.kbms.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Vector;

/**
 * <h3>kbms</h3>
 * <p>分类管理controller</p>
 *
 * @author : guoweicheng
 * @date : 2020-07-05 23:25
 **/

@RestController
@RequestMapping("/manager")
public class TypeManageController {

    @Autowired
    TypeManageServiceImpl typeManageService;

    @RequestMapping("/initypeList")
    public TableVO InitTable(){
        System.out.println("初始化分类列表");
        Vector<Type> types=typeManageService.getAllType();
        return new TableVO(types.size(),types);
    }

    @RequestMapping("/TypeManager")
    public ModelAndView toTypeManage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("TypeManager");
        return mav;
    }
    @RequestMapping("/TypeManager/AddView")
    public ModelAndView TypeAddView(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Type_Add");
        return mav;
    }

    @RequestMapping("/TypeManager/TypeAdd")
    public Response TypeAdd(Type type){
        if(typeManageService.typeAdd(type)==1){
            return Response.create(null,"200");
        }else{
            return Response.create(null,"500");
        }
    }



    @RequestMapping("/TypeManager/TypeEdit")
    public Response TypeEdit(Type type){
        System.out.println(type.getTypeId()+type.getTypeTitle()+type.getTypeWeight());
        if(typeManageService.typeEdit(type)==1){

            return Response.create(null,"200");
        }else{
            return Response.create(null,"500");
        }
        // return Response.create();
    }

    @RequestMapping("/TypeManager/TypeSearch")
    public Type TypeSearch(int typeId){
        return typeManageService.typeSearch(typeId);
    }

    @RequestMapping("/TypeManager/EditView")
    public ModelAndView TypeEditView(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Type_Edit");
        return mav;
    }


}
