package ru.gb.lesson1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

//@Component
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();
        for(String name:names){
            System.out.println(name);
            if(name.equals("blackAndWhiteRoll")){
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
                beanDefinition.setBeanClassName(ColorRoll.class.getName());
                System.out.println(beanDefinition);
            }
        }
    }
}
