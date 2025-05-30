package com.solvd.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/carts/add", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/carts/_post/rq.json")
@ResponseTemplatePath(path = "api/carts/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostAddNewCartMethod extends AbstractApiMethodV2 {
    public PostAddNewCartMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}


