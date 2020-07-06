package com.fjnu.kbms.controller;

import com.fjnu.kbms.bean.Type;
import com.fjnu.kbms.response.Response;
import com.fjnu.kbms.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {
    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @RequestMapping("/getAllTypes")
    public Response getAllTypes(){
        List<Type> list = typeService.getAllTypes();
        return Response.create(list);
    }

}
