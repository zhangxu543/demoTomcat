package com.csi.controller;

import com.csi.domain.Nation;
import com.csi.service.NationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 张旭
 * @version 1.0
 * @date 2021/4/11 13:36
 */
@RestController
@RequestMapping("/nation")
public class NationController {
    private static final Logger logger = LoggerFactory.getLogger(NationController.class);

    @Autowired
    private NationService service;


    @RequestMapping("findAll")
    public List<Nation> findAll(){
        List<Nation> cities = service.list();
        logger.info("民族个数======"+cities.size());
        return cities;
    }


}