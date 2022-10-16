package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vod.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2022-10-16
 */
@Api(tags = "讲师管理接口")   //swagger的，作用在类上，起提示信息的作用
@RestController     //Controller和ResponseBody，生成对象交给Spring管理，返回json数据
@RequestMapping(value = "/admin/vod/teacher")
public class TeacherController {
    //注入Service
    @Autowired
    private TeacherService teacherService;

    //http://localhost:8301/admin/vod/teacher/findAll
    //1. 查询所有讲师列表
//    @ApiOperation("查询所有讲师")     //swagger的，作用在方法上
//    @GetMapping("findAll")
//    public List<Teacher> findAllTeacher(){
//        //调用Service方法
//        List<Teacher> list = teacherService.list();
//        return list;
//    }

    @ApiOperation("查询所有讲师")
    @GetMapping("findAll")
    public Result findAllTeacher(){
        //调用Service方法
        List<Teacher> list = teacherService.list();
        return Result.ok(list).message("查询所有讲师成功");
    }

    //2. 逻辑删除讲师
//    @ApiOperation("逻辑删除讲师")
//    @DeleteMapping("remove/{id}")
//    public boolean removeTeacher(
//            @ApiParam(name = "id", value = "ID", required = true)   //swagger的，作用在参数上
//            @PathVariable Long id){
//        boolean isSuccess = teacherService.removeById(id);
//        return isSuccess;
//    }

    //2. 逻辑删除讲师
    @ApiOperation("逻辑删除讲师")
    @DeleteMapping("remove/{id}")
    public Result removeTeacher(
            @ApiParam(name = "id", value = "ID", required = true)   //swagger的，作用在参数上
            @PathVariable Long id){
        boolean isSuccess = teacherService.removeById(id);
        if (isSuccess){
            return Result.ok(null);
        }else {
            return Result.fail(null);
        }
    }

}

