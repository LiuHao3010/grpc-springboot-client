package com.linshen.grpcclient;

import com.google.protobuf.ByteString;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;


@Service
public class GrpcClientService {

    @GrpcClient("local-grpc-server111")
    private Channel serverChannel;

    public String sendMessage(String name,String URL)throws Exception {
        GreeterGrpc.GreeterBlockingStub stub= GreeterGrpc.newBlockingStub(serverChannel);
        String reply="";
        File file = new File(name);
      //  GreeterOuterClass.HelloRequest request=GreeterGrpc.getSayHelloMethod();
        if(!file.isDirectory()){
            uploadImag(file,URL,reply,stub);
        }
        else {
            File[] filelist = file.listFiles();
            for (File f:filelist){
                String temp[]=f.toString().split("/");
                String fn=temp[temp.length-1];
                uploadImag(f,URL+"/"+fn,reply,stub);
            }
        }
        return reply;
    }
    public static void uploadImag(File file,String URL,String reply,GreeterGrpc.GreeterBlockingStub stub)throws Exception{
        byte[] fileByte = Files.readAllBytes(file.toPath());
        ByteString bytes=ByteString.copyFrom(fileByte);
        System.out.println("Success "+file.getName());
        reply = stub.sayHello(GreeterOuterClass.HelloRequest.newBuilder().setUrl(URL).setImage(bytes).build()).getMessage();
    }
}
