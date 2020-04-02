package cn.stevekung.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class People {
    @Value("stevekung")
    private String name;
    @Autowired
    private Dog dog;
}
