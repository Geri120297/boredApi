package com.boredAPI.boredApi.Client;

import com.boredAPI.boredApi.Model.BoredResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface BoredClient {

    @GetExchange("/activity")
    BoredResponse random();

    @GetExchange("/activity?type=")
    BoredResponse getByType(@RequestParam String type);
}
