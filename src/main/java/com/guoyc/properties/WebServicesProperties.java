package com.guoyc.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>项目名称: guoyc-web-services-starter </p>
 * <p>文件名称: WebServicesProperties </p>
 * <p>功能描述: 配置项 </p>
 * <p>创建时间: 2023/10/31 17:09 </p>
 *
 * @author guoyc
 * @version v1.0
 */
@ConfigurationProperties(prefix = "guoyc.webservices")
@Data
public class WebServicesProperties {
    /**
     * webservice 的 url
     */
    private String weburl;

    /**
     * 与 webservice 服务相关的 XML 数据结构的 Java 类所在的包路径
     */
    private String contextPath;

    /**
     * webservice 的请求信息。
     * SOAPAction 的格式通常为："命名空间/操作名称"
     */
    private String soapAction;
}
