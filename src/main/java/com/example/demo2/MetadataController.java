package com.example.demo2;
import com.example.demo2.CalculationBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Set;

@Named
@RequestScoped
public class MetadataController {

    @Inject
    private BeanManager beanManager;

    public String getBeanMetadata() {
        Set<Bean<?>> beans = beanManager.getBeans(CalculationBean.class);
        Bean<?> bean = beans.iterator().next();

        String beanName = bean.getName();
        String beanScope = bean.getScope().getName();

        return "Bean: " + beanName + ", Scope: " + beanScope;
    }
}