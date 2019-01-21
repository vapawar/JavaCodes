package com.vpz.beans;

public class TextEditor 
{
	
	private SpellChecker spellchecker;
	private String name;
	
	public void setSpellchecker(SpellChecker spellchecker) 
	{
		this.spellchecker = spellchecker;
	}
	public SpellChecker getSpellchecker() 
	{
		return spellchecker;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getName() 
	{
		return name;
	}
	
	public void spellCheck()
	{
		spellchecker.checkSpelling();
	}

}