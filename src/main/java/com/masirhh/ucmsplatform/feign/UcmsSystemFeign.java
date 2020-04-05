package com.masirhh.ucmsplatform.feign;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/***
 * 增加支持feign远程调用
 */
@FeignClient(name = "ucms-system")
public interface UcmsSystemFeign {
    @GetMapping("/ucms/file")
    public R<String> getUrl(@RequestParam("fileId") Long fileId);
}
