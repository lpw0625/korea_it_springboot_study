package com.study.mvc.Model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Builder
@Getter
public class HelloModel {

          private String name1;
          private String name2;
          private String name3;


}



