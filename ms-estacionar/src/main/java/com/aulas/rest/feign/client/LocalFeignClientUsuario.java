package com.aulas.rest.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "usuario", url = "localhost:8003", path = "/usuario")
public interface LocalFeignClientUsuario {

}
