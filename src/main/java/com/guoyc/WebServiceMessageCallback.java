package com.guoyc;

import lombok.Data;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.SoapMessage;

import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * <p>项目名称: guoyc-web-services-starter </p>
 * <p>文件名称: MyWebServiceMessageCallback </p>
 * <p>功能描述: 请求回调 </p>
 * <p>创建时间: 2023/10/31 15:43 </p>
 *
 * @author guoyc
 * @version v1.0
 */
@Data
public class WebServiceMessageCallback implements org.springframework.ws.client.core.WebServiceMessageCallback {

    private String soapAction;
    @Override
    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
        // 处理请求消息
        SoapMessage soapMessage = (SoapMessage) message;
        soapMessage.setSoapAction(soapAction);
    }
}
