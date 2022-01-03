package io.pan.cookbook.plugin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPluginApplication {

  public static void main(String[] args) {

    new SpringApplication(SpringPluginApplication.class).run(args);

  }

}
