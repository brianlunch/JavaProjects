import controlP5.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;
//import processing.event.KeyEvent;


public class CurrencyConverter extends PApplet {
	ArrayList<Currency> currencyRates  = new ArrayList<Currency>();
	DropdownList fromDrop;
	DropdownList toDrop;
	double converted;
	Textfield fromText;
	Boolean error = false;
	Button convert;
	ControlP5 cp5;
	Robot robot;
	PImage backgroundImage;
	String to;
	String from;
	Double amount;
	String convertedString=" ";
	public static void main(String[] args) {
		PApplet.main("CurrencyConverter");
	}
	
	public void settings() {
		size(528,300);
	}
	public void setup() {
		cp5 = new ControlP5(this);
		backgroundImage = loadImage("C:\\Users\\brian\\Downloads\\Bg.jpg");
		backgroundImage.resize(528, 300);
		try {
			CurrencyRates.currencyRates(currencyRates);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		fromDrop = new DropdownList(cp5, "Currency From").setOpen(false);
		fromDrop.setColorBackground(color(201, 199, 187)).setColorForeground(color(255)).setColorLabel(0);
		fromDrop.setPosition(50,100).setSize(140, 300).setBarHeight(30).setItemHeight(25);
		fromDrop.getCaptionLabel().toUpperCase(false).setSize(12);
		fromDrop.getValueLabel().toUpperCase(false).setSize(13).setColor(0)
		;
		addItemsToDrop(currencyRates, fromDrop);
		
		toDrop = new DropdownList(cp5, "Currency To").setOpen(false);
		toDrop.setColorBackground(color(201, 199, 187)).setColorForeground(color(255)).setColorLabel(0);
		toDrop.setPosition(360,100).setSize(140, 300).setBarHeight(30).setItemHeight(25);
		toDrop.getCaptionLabel().toUpperCase(false).setSize(12);
		toDrop.getValueLabel().toUpperCase(false).setSize(13).setColor(0);
		addItemsToDrop(currencyRates, toDrop);
		
		
		fromText = new Textfield(cp5, "Amount").setPosition(50, 150).setSize(140, 25);
		fromText.setColorBackground(color(201, 199, 187)).setColorForeground(color(255, 20)).setColorLabel(255).setColorActive(255);
		fromText.setValue("  " ).setColorValue(0).setAutoClear(false); 
		
		
		convert = new Button(cp5, "Convert").setPosition(240, 125).setSize(70, 25);
		convert.getCaptionLabel().toUpperCase(false).setSize(15);
		convert.setColorBackground(color(40,200,40)).setColorForeground(color(0,255,0)).setColorActive(color(0,255,0));
		
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void draw() {
		try {
		background(backgroundImage);
		if(fromDrop.isOpen())
			fromText.hide();
		else
			fromText.show();
		fill(155,200);
		rect(0,0,852,480);
		fill(250,0,0);
		if(error || fromDrop.getLabel().contains("All Currencies")|| fromDrop.getLabel().contains("Popular Currencies")
				|| toDrop.getLabel().contains("All Currencies")|| toDrop.getLabel().contains("Popular Currencies"))
			text("Please Enter Valid values in each field.", 165, 220);
		if(convert.isMousePressed())

		{
			try{if(fromText.getStringValue()!= null)amount = Double.parseDouble(fromText.getStringValue());}
			catch(Exception e) {}
			error = false;
			from = fromDrop.getLabel();
			to = toDrop.getLabel();
			converted = CurrencyRates.convert(CurrencyRates.findCurrency(from, currencyRates), CurrencyRates.findCurrency(to, currencyRates), amount);
			convertedString = new DecimalFormat("#.00000").format(converted);
		}
		if(fromText.isActive() && !fromDrop.isMouseOver() && !toDrop.isMouseOver()) {
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		}
		
		noStroke();
		fill(201, 199, 187);
		rect(360,150,140,25);
		fill(0);
		text(convertedString, 360,170);
		}
			catch(NullPointerException e) {
				fill(200,0,0);
				error = true;
			}
	}
	
	public static void addItemsToDrop(ArrayList<Currency> currencyRates, DropdownList list){
		String[] currencyNames = new String[currencyRates.size()];
		for(int index = 0; index<currencyNames.length; index++)
		{
			currencyNames[index]= currencyRates.get(index).getCurrencyName();
		}
		list.addItems(currencyNames);
	}
	
}

