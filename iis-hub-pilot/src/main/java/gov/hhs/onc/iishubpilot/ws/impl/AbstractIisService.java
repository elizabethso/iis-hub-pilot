package gov.hhs.onc.iishubpilot.ws.impl;

import gov.hhs.onc.iishubpilot.ws.ConnectivityTestRequestType;
import gov.hhs.onc.iishubpilot.ws.ConnectivityTestResponseType;
import gov.hhs.onc.iishubpilot.ws.IisService;
import gov.hhs.onc.iishubpilot.ws.UnsupportedOperationFault;
import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public abstract class AbstractIisService implements IisService {
    @Resource
    protected WebServiceContext wsContext;

    protected AbstractApplicationContext appContext;
    protected ObjectFactory objFactory;

    @Override
    public ConnectivityTestResponseType connectivityTest(ConnectivityTestRequestType reqParams) throws UnsupportedOperationFault {
        return this.connectivityTestInternal(reqParams);
    }

    protected ConnectivityTestResponseType connectivityTestInternal(ConnectivityTestRequestType reqParams) {
        ConnectivityTestResponseType respParams = this.objFactory.createConnectivityTestResponseType();
        respParams.setEchoBack(reqParams.getEchoBack());

        return respParams;
    }

    @Override
    public void setApplicationContext(ApplicationContext appContext) throws BeansException {
        this.appContext = ((AbstractApplicationContext) appContext);
    }

    @Override
    public ObjectFactory getObjectFactory() {
        return this.objFactory;
    }

    @Override
    public void setObjectFactory(ObjectFactory objFactory) {
        this.objFactory = objFactory;
    }
}
