package com.himedia.shop01.ioc.injection;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");

		//List<String> addressList = bean.getAddressList();
//		for (String address : addressList) {
//			System.out.println(address.toString());
//		}
//		Map<String, String> addressList = bean.getAddressList();
//		
//		Set<String> key=addressList.keySet();
//		
//		for(String i : key) {
//			System.out.println(i+" : "+addressList.get(i));
//		}
		
		Properties addressList = bean.getAddressList();
		
		Set<String> key=addressList.stringPropertyNames();
		for(String i : key) {
			System.out.println(i+" : "+addressList.get(i));
		}
		
		factory.close();

	}
}
