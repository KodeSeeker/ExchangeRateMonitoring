package com.paisebhejo.business;

import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SimpleScraper {

	public SimpleScraper() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) throws MalformedURLException {
	
		
			parsewithJSoup(new URL("http://www.coziie.com/exchange-rates/usd-inr"));
		

		
}


private static void parsewithJSoup(URL url) {
	String urlString = url.toString();
	try {

		// Element body=htmlDoc.body();
		String htmlText = Jsoup.connect(urlString).get().html();
		Document htmlDoc = Jsoup.parse(htmlText);
		
		Element table = htmlDoc.select("table.table").first();
		String tablehtml=table.html();
		Document tableDoc=Jsoup.parse(tablehtml);
		String tabletext= tableDoc.text();
		
		int indianBank = tabletext.indexOf("1 Indian Bank IndRemit");
		//if (claimIndex == -1)
		
		int	hdfcBank= tabletext.indexOf("2 HDFC Bank");
		int	Rbi= tabletext.indexOf("3 Reserve Bank Of India (RBI)");
		int indusindBank=tabletext.indexOf("4 IndusInd Bank");
		//
		int westernUnion=tabletext.indexOf("5 Western Union");
		int punjabBank=tabletext.indexOf("6 Punjab National Bank (Indicative)");
		int moneyDart=tabletext.indexOf("7 MoneyDart");
		int bankOfIndia=tabletext.indexOf("8 Bank Of India");
		int remit2India=tabletext.indexOf("9 Remit 2 India");
		int royalExchange=tabletext.indexOf("10 Royal Exchange");
		//
		int sbi=tabletext.indexOf("11 SBI Money to India");
		int transfast=tabletext.indexOf("12 Trans-Fast (Locked In)");
		int iciciBank=tabletext.indexOf("13 ICICI Bank");
		int axisBankWire=tabletext.indexOf("14 AXIS Bank - Smart Wire Transfer");
		int axisBankACH=tabletext.indexOf("15 AXIS Bank - ACH Transfer");
		
		//
		///surlTagsLog(urlString, claimIndex, statusIndex, exIndex,
			//	orgIndex, srcIndex);
		double indBankRate=Double.parseDouble(tabletext.substring(indianBank+22, hdfcBank).trim());
		double hdfcRate=Double.parseDouble(tabletext.substring(hdfcBank+12, Rbi).trim());
		double rbiRate=Double.parseDouble(tabletext.substring(Rbi+29, indusindBank).trim());
		double indusIndRate=Double.parseDouble(tabletext.substring(indusindBank, westernUnion).trim());
		System.out.println(tabletext.substring(indusindBank+2, westernUnion));
	} 
	catch(StringIndexOutOfBoundsException s)
	{
		return;
	}
	catch (Exception e) {
		e.printStackTrace();
		System.out.println("hello " + urlString);
	}
}

}
