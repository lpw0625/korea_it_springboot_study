package com.study.mvc.Model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Builder
@Getter
public class HelloModel {
    // 값은 get으로 가져오고 쓸땐 set으로 들고오자.
    //
          private String name1;
          private String name2;
          private String name3;
}



