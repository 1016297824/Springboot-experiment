package com.example.experiment05.practise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@org.springframework.stereotype.Service
public class Service {
    public void addFile(){
        try {
            Files.readString(Path.of("A:/aa.aa"));
        }catch (IOException e){
            throw new MyException("文件处理错误！"+e.getMessage());
        }
    }
}
