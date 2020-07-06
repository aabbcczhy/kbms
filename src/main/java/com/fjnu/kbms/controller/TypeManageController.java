package com.fjnu.kbms.controller;

import com.fjnu.kbms.bean.Type;
import com.fjnu.kbms.response.Response;
import com.fjnu.kbms.serviceimpl.TypeManageServiceImpl;
import com.fjnu.kbms.vo.TableVO;
import org.apache.shiro.authz.annotation.RequiresRoles;
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
@RequiresRoles("1")
public class TypeManageController {

    private final TypeManageServiceImpl typeManageService;

    @Autowired
    public TypeManageController(TypeManageServiceImpl typeManageService) {
        this.typeManageService = typeManageService;
    }

    @RequestMapping("/initypeList")
    public TableVO initTable(){
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
    public ModelAndView typeAddView(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Type_Add");
        return mav;
    }

    @RequestMapping("/TypeManager/TypeAdd")
    public Response typeAdd(Type type){
        if(typeManageService.typeAdd(type)==1){
            return Response.create(null,"200");
        }else{
            return Response.create(null,"500");
        }
    }

    @RequestMapping("/TypeManager/TypeEdit")
    public Response typeEdit(Type type){
        System.out.println(type.getTypeId()+type.getTypeTitle()+type.getTypeWeight());
        if(typeManageService.typeEdit(type)==1){
            return Response.create(null,"200");
        }else{
            return Response.create(null,"500");
        }
    }

    @RequestMapping("/TypeManager/TypeSearch")
    public Type typeSearch(int typeId){
        return typeManageService.typeSearch(typeId);
    }

    @RequestMapping("/TypeManager/EditView")
    public ModelAndView typeEditView(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Type_Edit");
        return mav;
    }


}
