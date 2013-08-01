package org.ow2.chameleon.fuchsia.importer;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;
import org.ow2.chameleon.fuchsia.device.GenericDevice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * This class is a proxy in order to delegate calls on the fake device
 * Note : In the future this will use events !
 *
 * @author jeremy.savonet@gmail.com
 */
public class DelegationProxy implements InvocationHandler {

    private final GenericDevice m_proxied;

    public DelegationProxy(GenericDevice proxied) {
        this.m_proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(m_proxied, args);
    }
}
