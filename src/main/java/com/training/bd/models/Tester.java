package com.training.bd.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




import com.training.bd.dao.*;
import com.training.bd.webModels.ItemFromWeb;
import com.training.*;


class Tester{ 
	 public static void main(String[] args) { 
		 ApplicationContext context ;
			
							
		context= new ClassPathXmlApplicationContext("spring.xml");
		ItemDAOImpl itemDAO = (ItemDAOImpl) context.getBean("itemDAO");
		itemDAO.deleteItem(33);
		
	 } 


}






