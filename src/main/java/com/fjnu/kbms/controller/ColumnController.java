package com.fjnu.kbms.controller;

import com.fjnu.kbms.bean.Column;
import com.fjnu.kbms.response.Response;
import com.fjnu.kbms.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/column")
public class ColumnController {
    private final ColumnService columnService;

    @Autowired
    public ColumnController(ColumnService columnService) {
        this.columnService = columnService;
    }

    @RequestMapping("/getAllColumns")
    public Response getAllColumns(){
        List<Column> list = columnService.getAllColumns();
        return Response.create(list);
    }
}
