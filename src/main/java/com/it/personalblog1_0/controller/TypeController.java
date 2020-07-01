package com.it.personalblog1_0.controller;

import com.github.pagehelper.Page;
import com.it.personalblog1_0.entity.Type;
import com.it.personalblog1_0.services.impl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.print.Pageable;

/**
 * @author lls
 * @version 1.0
 * @date 2020/6/6 17:50
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeServiceImpl typeService;

    @RequestMapping(value = "/types/{pageNum}")
    public String getTypeList(@PathVariable(value = "pageNum",required = false) Integer pageNum, Model model){

        if (pageNum==null){
            pageNum = 1;
        }
        Page<Type> types = typeService.getTypeList(pageNum,2);
        System.out.println(types.getPages()+":"+types.getPageNum()+":"+types.getPageSize());
        model.addAttribute("types",types);
        return "admin/type";
    }

    @RequestMapping(value = "/types")
    public String getTypeList01(Model model){

        Page<Type> types = typeService.getTypeList(1,2);
        System.out.println(types.getPages()+":"+types.getPageNum()+":"+types.getPageSize());
        model.addAttribute("types",types);
        return "admin/type";
    }

    @GetMapping("/types/add")
    public String toAddTypePage(){

        return "admin/addType";
    }

    @PostMapping("/addType")
    public String addType(Type type, RedirectAttributes attributes){
        String message = null;
        boolean flag = typeService.addType(type);
        if (flag){
            attributes.addFlashAttribute("message","新增成功!");
            return "redirect:/admin/types";
        }
        else{
            attributes.addFlashAttribute("message","新增失败!");
            return "redirect:/admin/types";
        }
    }
}
