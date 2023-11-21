package com.guoyc;

import lombok.Data;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 * <p>项目名称: guoyc-web-services-starter </p>
 * <p>文件名称: WebServiceClient </p>
 * <p>功能描述: TODO </p>
 * <p>创建时间: 2023/10/31 15:50 </p>
 *
 * @author guoyc
 * @version v1.0
 */
@Data
public class WebServiceClient extends WebServiceGatewaySupport {

    private String weburl;


    WebServiceMessageCallback webServiceMessageCallback;

    public Object invokeWebService(Object requestData) {

        Object o = getWebServiceTemplate().marshalSendAndReceive(weburl, requestData, webServiceMessageCallback);

        return o;
    }
}
