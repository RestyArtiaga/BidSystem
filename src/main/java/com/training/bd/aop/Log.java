package com.training.bd.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.training.bd.models.Bid;
import com.training.bd.models.Item;
import com.training.bd.models.User;
import com.training.bd.webModels.BidFromWeb;
import com.training.bd.webModels.ItemDetails;
import com.training.bd.webModels.ItemFromWeb;
import com.training.bd.webModels.StatusObject;
import com.training.bd.webModels.UserFromWeb;


@EnableAspectJAutoProxy
@Aspect
public class Log{
	
	 @Before("execution(* com.training.bd.services.UserService.isUser(..))")
	 public void logBeforeLogin(JoinPoint joinPoint) {	         
	         Object[] objs = joinPoint.getArgs();	         
	         System.out.print("Login---");
	         System.out.print("Username: " + objs[0]);
	         System.out.println(",Password: " + objs[1]);
	 }
	 
	 @AfterReturning(pointcut = "execution(* com.training.bd.services.UserService.isUser(..))",
			   returning= "result")
	 public void logAfterLogin(JoinPoint joinPoint, Object result) {
		 User user = (User) result;
		 if(user.getUserID()!=0)
			 System.out.println("Login---Success");
		 else
			 System.out.println("Login---Failure");
	 }
	 

	 @Before("execution(* com.training.bd.services.UserService.usernameExists(..))")
	 public void logBeforeCheckingUsername(JoinPoint joinPoint) {	         
	         Object[] objs = joinPoint.getArgs();	         
	         System.out.println("Checki username---" + objs[0]);	         
	 }
	 	 
	 @AfterReturning(pointcut = "execution(* com.training.bd.services.UserService.usernameExists(..))",
			   returning= "result")
	 public void logAfterCheckingUsername(JoinPoint joinPoint, Object result) {
		 StatusObject ret = (StatusObject) result;
		 if(ret.getStatus())
			 System.out.println("Check username---exists.");
		 else
			 System.out.println("Check username---does not exist");
	 }
	 
	 
	 @Before("execution(* com.training.bd.services.UserService.register(..))")
	 public void logBeforeRegister(JoinPoint joinPoint) {	         
	         Object[] objs = joinPoint.getArgs();		         
	         System.out.println("Registering---" + ((UserFromWeb) objs[0]).getUsername());	        
	 }
	 	 
	 @AfterReturning(pointcut = "execution(* com.training.bd.services.UserService.register(..))",
			   returning= "result")
	 public void logAfterRegister(JoinPoint joinPoint, Object result) {
		 	System.out.println("Registering---done");
	 }
	 
	 @Before("execution(* com.training.bd.services.ItemService.getItemList(..))")
	 public void logBeforeGettingAllItems(JoinPoint joinPoint) {	         	                 
	         System.out.println("Requesting All Item List---");	        
	 }
	 	 
	 @AfterReturning(pointcut = "execution(* com.training.bd.services.ItemService.getItemList(..))",
			   returning= "result")
	 public void logAfterGettingAllItems(JoinPoint joinPoint, Object result) {
		 List<Item> res = (List<Item>) result;
		 	System.out.println("Requesting All Item List---" + res.size() + " items retrieved");
	 }
	 
	 @Before("execution(* com.training.bd.services.ItemService.getItemDetails(..))")
	 public void logBeforeGettingDetailsOfItem(JoinPoint joinPoint) {	
		 	 Object[] objs = joinPoint.getArgs();
	         System.out.println("Requesting details of item---itemID=" + objs[0]);	        
	 }
	 	 
	 @AfterReturning(pointcut = "execution(* com.training.bd.services.ItemService.getItemDetails(..))",
			   returning= "result")
	 public void logAfterGettingDetailsOfItem(JoinPoint joinPoint, Object result) {
		 	ItemDetails it = (ItemDetails) result;		 	
		 	System.out.print("Requesting details of item---");
		 	if(it.getItem()!=null)
		 		System.out.println("item details returned");
		 	else
		 		System.out.println("item not found");
	 }
	 
	 @Before("execution(* com.training.bd.services.ItemService.saveItem(..))")
	 public void logBeforeSavingItem(JoinPoint joinPoint) {	
		 	 Object[] objs = joinPoint.getArgs();
	         System.out.println("Saving item---" + ((ItemFromWeb) objs[0]).getItemName());	        
	 }
	 	 
	 @AfterReturning(pointcut = "execution(* com.training.bd.services.ItemService.saveItem(..))",
			   returning= "result")
	 public void logAfterSavingItem(JoinPoint joinPoint, Object result) {
		 			 	
		 	System.out.print("Saving item---done");		 	
	 }
	 
	 @Before("execution(* com.training.bd.services.ItemService.updateItem(..))")
	 public void logBeforeUpdatingItem(JoinPoint joinPoint) {	
		 	 Object[] objs = joinPoint.getArgs();
	         System.out.println("Updating item---" + ((ItemFromWeb) objs[0]).getItemName());	        
	 }
	 	 
	 @AfterReturning(pointcut = "execution(* com.training.bd.services.ItemService.updateItem(..))",
			   returning= "result")
	 public void logAfterUpdatingItem(JoinPoint joinPoint, Object result) {
		 			 	
		 	System.out.print("Updating item---done");		 	
	 }
	 
	 
	 @Before("execution(* com.training.bd.services.ItemService.updateItem(..))")
	 public void logBeforeDeletingItem(JoinPoint joinPoint) {	
		 	 Object[] objs = joinPoint.getArgs();
	         System.out.println("Deleting item---" + objs[0]);	        
	 }
	 	 
	 @AfterReturning(pointcut = "execution(* com.training.bd.services.ItemService.updateItem(..))",
			   returning= "result")
	 public void logAfterDeletingItem(JoinPoint joinPoint, Object result) {
		 	 	
		 	System.out.print("Deleting item---done");		 	
	 }
	 
	 @Before("execution(* com.training.bd.services.BidService.placeBid(..))")
	 public void logBeforePlacingBid(JoinPoint joinPoint) {	
		 	 Object[] objs = joinPoint.getArgs();
	         System.out.println("Placing Bid---" + ((BidFromWeb) objs[0]).getItemID());	        
	 }
	 	 
	 @AfterReturning(pointcut = "execution(* com.training.bd.services.ItemService.updateItem(..))",
			   returning= "result")
	 public void logAfterPlacingBid(JoinPoint joinPoint, Object result) {
		 	StatusObject it = (StatusObject) result;		 	
		 	System.out.print("Placing Bid---" + it.getStatus().toString());		 	
	 }
	 
	 @Before("execution(* com.training.bd.services.BidService.getBidHistoryOf(..))")
	 public void logBeforeGettingBidHistoryOf(JoinPoint joinPoint) {	
		 	 Object[] objs = joinPoint.getArgs();
	         System.out.println("Getting bid history of---itemID," + objs[0]);	        
	 }
	 	 
	 @AfterReturning(pointcut = "execution(* com.training.bd.services.BidService.getBidHistoryOf(..))",
			   returning= "result")
	 public void logAfterGettingBidHistoryOf(JoinPoint joinPoint, Object result) {
		 	List<Bid> it = (List<Bid>) result;		 	
		 	System.out.print("Getting bid history of---" + it.size() + " bid results found");		 	
	 }
	 
}

