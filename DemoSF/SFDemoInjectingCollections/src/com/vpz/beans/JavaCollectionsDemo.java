package com.vpz.beans;

import java.util.*;

public class JavaCollectionsDemo 
{
	List list;
	Set set;
	Map map;
	Properties props;
	
	public void setList(List list) 
	{
		this.list = list;
	}
	public List getList() 
	{
		System.out.println("List elements are : "+list);
		return list;
	}
	
	public void setSet(Set set) 
	{
		this.set = set;
	}
	public Set getSet() 
	{
		System.out.println("Set elements are : "+set);
		return set;
	}
	
	public void setMap(Map map) 
	{
		this.map = map;
	}
	public Map getMap() 
	{
		System.out.println("Map elements are : "+map);
		return map;
	}
	
	public void setProps(Properties props) 
	{
		this.props = props;
	}
	public Properties getProps() 
	{
		System.out.println("Properties elements are : "+props);
		return props;
	}
}
