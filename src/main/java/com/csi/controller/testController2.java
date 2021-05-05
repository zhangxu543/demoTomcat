/*
package com.csi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/backend")
public class testController2 {
    @Autowired
    private TypeService typeService;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;


    @RequestMapping("/insertcomment")
    public void insertcomment(Comment comment) {
        commentService.inserComment(comment);
    }

    @RequestMapping("/findcommentbyid")
    public List findcommentbyid(int commentfoodid) {
        List<Comment> findcommentbyid = commentService.findcommentbyid(commentfoodid);
        return findcommentbyid;
    }

    @RequestMapping("/deletecomment")
    public void deletecomment(int commentid) {
       commentService.deleteComment(commentid);
    }


    @RequestMapping("/finduserbyid")
    public User finduserbyid(int u_id) {
        User findbyuserid = userService.findbyuserid(u_id);
        return findbyuserid;

    }

    @RequestMapping("/forzenuser")
    public List forzenuser(int u_role) {
        List<User> forzen = userService.forzen(u_role);
        return forzen;

    }

    @RequestMapping("/findfoodbyid")
    public Food findfoodbyid(int foodid) {
        Food findbyid = foodService.findbyid(foodid);
        return findbyid;

    }

    @RequestMapping("/updateforzenuser")
    public Map updateforzenuser(int u_id) {
        User findbyuserid = userService.findbyuserid(u_id);
        if(findbyuserid.getU_frozen()==0){
            userService.updateFrozen(1,u_id);
        }else {
            userService.updateFrozen(0,u_id);
        }
        Map map=new HashMap();
        map.put("code",200);
        return map;

    }

    @RequestMapping("/findalltype")
    public List findalltype() {
        List<Type> typefindall = typeService.Typefindall();
        return typefindall;

    }
    @RequestMapping("/findallfood")
    public List findallfood() {
        List<Food> findall = foodService.findall();
        return findall;

    }

    @RequestMapping("/findfoodbytype")
    public List findfoodbytype(int foodtypeid) {
        int id= foodtypeid+1;
        List<Food> findbytype = foodService.findbytype(id);
        return findbytype;

    }

    @RequestMapping("/login")
    public Map<String,Object> login(String email,String password) {
        User login = userService.login(email, password);
        Map map=new HashMap();
        if(login!=null && login.getU_frozen()==0){
            map.put("code",200);
            map.put("userid",login.getU_id());
        }else {
            map.put("code",400);
        }



        return map;

    }
    @RequestMapping("/register")
    public Map<String,Object> register(String zhanghao,String mima,String nicheng,String sex,String singnature) {
        User user=new User();
        user.setU_email(zhanghao);
        user.setU_password(mima);
        user.setU_nickname(nicheng);
        user.setU_sex(sex);
        user.setU_singnature(singnature);
        user.setU_frozen(0);
        user.setU_role(0);

        userService.inseruser(user);


        Map map=new HashMap();

        map.put("code",200);


        return map;

    }

    @RequestMapping(value = "/insertfood",method = RequestMethod.POST)
    public Result insertfood(String name,String description,String imgpath,int id) {

        Food food=new Food();
        food.setF_name(name);
        food.setF_description(description);
        food.setF_cover(imgpath);
        food.setF_t_id(id);
        System.out.println(food);
        foodService.inserFood(food);

        Result result = new Result() ;
        result.setCode(200);
        result.setMessage("成功!");
        return result ;

    }

    //上传图片
    @RequestMapping("/insertPicture")
    public Map<String,Object> insertPicture(@RequestParam() MultipartFile file)  {
        Map<String,Object> map=null;
        try {
            String path="/img/";
            String realPath=servletContext.getRealPath(path);
            //创建文件夹地址
            File folder=new File(realPath);
            if(!folder.exists()){
                folder.mkdirs();
            }
            String fileName=file.getOriginalFilename();//得到上传时的文件名
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            String newFile= UUID.randomUUID().toString().replace("-","");
            String newFileName=newFile+suffix;
            file.transferTo(new File(realPath,newFileName));
            path=path+newFileName;

            map = new HashMap();
            map.put("code",200);
            map.put("path",path);
            map.put("msg","上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            map = new HashMap();
            map.put("code",0);
            map.put("msg","上传失败");
        }finally {
            return map;
        }
    }
}
*/
