package com.vpz.beans;

public class TextEditor 
{
	
	private SpellChecker spellchecker;
	
	public TextEditor(SpellChecker spellchecker) 
	{
		System.out.println("Inside text editor constructor.");
		this.spellchecker=spellchecker;
	}
	
	public void spellCheck() 
	{
		spellchecker.checkSpelling();
	}
}
