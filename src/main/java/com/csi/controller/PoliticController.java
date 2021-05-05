package com.csi.controller;

import com.csi.domain.Politic;
import com.csi.service.PoliticService;
import com.csi.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/4/13 20:10
 */
@RestController
@RequestMapping("/politic")
public class PoliticController {
    private static final Logger logger = LoggerFactory.getLogger(PoliticController.class);

    @Autowired
    private PoliticService service;
    @RequestMapping("/findAll")
    public List<Politic> findAll(){
        List<Politic> list = service.list();
        logger.info("政治个数======"+list.size());
        return list;
    }

    @RequestMapping("/insert")
    public Result insert(@RequestBody Politic politic){
        Result result = new Result() ;
        service.save(politic);
        logger.info("新增政治面貌======"+politic);
        result.setMessage("添加成功！");
        return result;
    }

    @RequestMapping("/delete")
    public Result delete(@RequestBody Politic politic){
        logger.info("删除政治面貌信息======"+politic);
        Result result = new Result() ;
        service.delete(politic.getId());
        result.setMessage("删除成功！");
        return result;
    }


}