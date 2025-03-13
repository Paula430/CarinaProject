package com.solvd.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/carts/user/5", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/carts/_get/_getByUser/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetCartsByUserMethod extends AbstractApiMethodV2 {
    public GetCartsByUserMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
