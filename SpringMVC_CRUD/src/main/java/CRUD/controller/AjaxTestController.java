package CRUD.controller;

import CRUD.Bean.Employee;
import CRUD.DAO.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

/**
 * @Description
 * @date 2020/12/10 0010-19:33
 */
@Controller
public class AjaxTestController {
    @Autowired
    EmployeeDao employeeDao;

    /**
     * SpringMVC文件下载
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
        //1 得到要下载的文件流，找到要下载的文件的真实路径
        String realPath= request.getServletPath();
        FileInputStream is = new FileInputStream(realPath);

        byte[] tmp=new byte[is.available()];
        is.read(tmp);
        is.close();
        //2 将要下载的文件流返回
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.set("Context-Disposition","attachment;filename="+"hgf.js");
        new ResponseEntity<byte[]>(tmp,httpHeaders,HttpStatus.OK);
        return new ResponseEntity<byte[]>(tmp,httpHeaders,HttpStatus.OK);
    }


    @RequestMapping("/testRequestBody")
    public String testRequestBody(String body){
        System.out.println("请求体："+body);
        return "success";
    }
    /**
     * 将返回的数据放在响应体中，如果是对象，Jackson包自动将对象转为json格式
     * @return
     */
    @ResponseBody
    @RequestMapping("/getallajax")
    public Collection<Employee> ajaxGetAll(){
        Collection<Employee> all = employeeDao.getAll();
        return all;
    }
    //@ResponseBody
    @RequestMapping("/hahah")
    public ResponseEntity<String> hahah(){
        String body="<h1>success<h1/>";
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Set-cookie","username=hahaha");
        return new ResponseEntity<String>(body,headers,HttpStatus.OK);
    }
}
