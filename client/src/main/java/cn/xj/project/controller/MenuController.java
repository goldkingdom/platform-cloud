package cn.xj.project.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Welink on 2017/7/3.
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @RequestMapping("/loadMenu")
    @CrossOrigin(maxAge = 3600, origins = "http://localhost:7777", methods = {RequestMethod.GET})
    public List<Map> loadMenu() {
        List<Map> list = Lists.newArrayList();
        Map menu1 = Maps.newHashMap();
        menu1.put("id", "menu1");
        menu1.put("name", "菜单1");
        list.add(menu1);
        Map menu2 = Maps.newHashMap();
        menu2.put("id", "menu2");
        menu2.put("name", "菜单2");
        list.add(menu2);
        Map menu3 = Maps.newHashMap();
        menu3.put("id", "menu3");
        menu3.put("name", "菜单3");
        list.add(menu3);
        return list;
    }

    @RequestMapping("/clickMenu")
    @CrossOrigin(maxAge = 3600, origins = "http://localhost:7777", methods = {RequestMethod.POST})
    public Object clickMenu(@RequestBody Map vo) {
        System.out.println(vo);
        return 1;
    }

}
