package com.vpz.beans;

public class TextEditor 
{
	private SpellChecker spellchecker;
	
	public void setSpellchecker(SpellChecker spellchecker) 
	{
		System.out.println("Inside set spellChecker.");
		this.spellchecker = spellchecker;
	}
	public SpellChecker getSpellchecker() 
	{
		return spellchecker;
	}
	
	public void spellCheck()
	{
		spellchecker.checkSpelling();
	}

}
