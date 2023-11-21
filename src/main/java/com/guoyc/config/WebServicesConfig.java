package com.guoyc.config;

import com.guoyc.WebServiceClient;
import com.guoyc.WebServiceMessageCallback;
import com.guoyc.properties.WebServicesProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * <p>项目名称: guoyc-web-services-starter </p>
 * <p>文件名称: WebServicesConfig </p>
 * <p>功能描述: 配置类 </p>
 * <p>创建时间: 2023/10/31 17:07 </p>
 *
 * @author guoyc
 * @version v1.0
 */
@Configuration
@EnableConfigurationProperties(value = WebServicesProperties.class)
public class WebServicesConfig {
    @Autowired
    private WebServicesProperties webServicesProperties;

    /**
     * soap协议报文，组包
     * @return
     */
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(webServicesProperties.getContextPath());
        return marshaller;
    }

    /**
     *
     * @param marshaller
     * @return
     */
    @Bean
    public WebServiceTemplate webServiceTemplate(Jaxb2Marshaller marshaller) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
        return webServiceTemplate;
    }

    /**
     * webservice调用客户端
     * @param webServiceTemplate
     * @return
     */
    @Bean
    public WebServiceClient dapWebService(WebServiceTemplate webServiceTemplate, WebServiceMessageCallback webServiceMessageCallback){
        WebServiceClient webServiceClient = new WebServiceClient();
        webServiceClient.setWebServiceTemplate(webServiceTemplate);
        webServiceClient.setWebServiceMessageCallback(webServiceMessageCallback);
        webServiceClient.setWeburl(webServicesProperties.getWeburl());
        return webServiceClient;
    }

    /**
     * 发送webservice的请求报文前的回调，设置请求头信息
     * @return
     */
    @Bean
    public WebServiceMessageCallback webServiceMessageCallback(){
        WebServiceMessageCallback webServiceMessageCallback = new WebServiceMessageCallback();
        webServiceMessageCallback.setSoapAction(webServicesProperties.getSoapAction());
        return webServiceMessageCallback;
    }

}
