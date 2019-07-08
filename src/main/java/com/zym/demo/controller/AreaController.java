package com.zym.demo.controller;

import com.zym.demo.entity.Area;
import com.zym.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zym
 * @Date 2019-06-30-22:01
 */

@RestController                    //是@Controller @ResponseBody 两个注解组成的
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping(value = "/listarea")
    private Map<String, Object> listArea() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Area> list = areaService.getAreaList();
        modelMap.put("areaList", list);
        return modelMap;
    }

    @GetMapping(value = "/getareabyid")
    private Map<String, Object> getAreaById(Integer areaId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Area area = areaService.getAreaById(areaId);
        modelMap.put("area", area);
        return modelMap;

    }

    @PostMapping(value = "/addarea")
    private Map<String, Object> addArea(@RequestBody Area area) {     //@RequestBody了解一下 传json对象
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", areaService.addArea(area));
        return modelMap;
    }

    @PostMapping(value = "/modifyarea")  //GET把参数包含在URL中，POST通过request body传递参数
    private Map<String,Object> modifyarea (@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        //修改区域信息
        modelMap.put("success", areaService.modifyArea(area));
        return modelMap;
    }
    @GetMapping(value = "/removearea")
    private Map<String,Object> removearea(Integer areaId){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success", areaService.deleteArea(areaId));
        return modelMap;
    }
}