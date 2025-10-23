package com.springboot.main.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Properties;

@RestController
public class ResourcesController {

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/resources")
    public ResponseEntity<String> resource() throws IOException {
        String content = this.resourceLoader.getResource("classpath:resource.xml")
                .getContentAsString(Charset.defaultCharset());
        return ResponseEntity.ok(content);
    }

    // TODO. 打包成jar后通过InputStream流来加载属性文件
    @GetMapping("/resource-properties")
    public String getName() throws IOException {
        Resource resource = new ClassPathResource("resource-property.xml");
        Properties props = new Properties();
        try (InputStream input = resource.getInputStream()) {
            props.loadFromXML(input);
        }
        System.out.println(props.getProperty("email.support"));
        return props.getProperty("http.server");
    }

    // TODO. ResourceUtils.getFile()找的是文件系统上物理文件, 适合开发阶段
    //  打包成jar后classpath资源存在于jar内部, 不再有真实路径, 无法转成File文件
    public void testResourceUtils() throws IOException {
        File file = ResourceUtils.getFile("classpath:resource-property.xml");
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(file)) {
            props.loadFromXML(input);
        }
        System.out.println(props.getProperty("email.support"));
    }

}
