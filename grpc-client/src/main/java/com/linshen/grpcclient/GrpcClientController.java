package com.linshen.grpcclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GrpcClientController {

    @Autowired
    private GrpcClientService grpcClientService;

    @RequestMapping("/")
    public String printMessage(@RequestParam(defaultValue = "/Users/lh/Downloads/2fec491f61292e6ea8a60efcd75a87d7.jpg") String name,String URL)throws Exception {
        return grpcClientService.sendMessage(name,URL);
    }
}
