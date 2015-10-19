package uts.wsd.teamtwo.translator;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.tempuri.SoapServiceLocator;

import com.microsofttranslator.api.V2.LanguageService;

public class TranslatorClient
{
	public static final String
		CLIENT_ID = "HotelService33",
		CLIENT_SECRET = "OoqnSU0wqCGoJh+Dew+S1WiWK/quJ3C/HB69hf3WHKQ=";
	
	public static void main (String[] args)
	{
		try {
			System.out.println(TranslatorClient.translate("Good evening, world!", "de"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String translate(String inputStr, String toLanguage) throws ServiceException, RemoteException
	{
		SoapServiceLocator locator = new SoapServiceLocator();
		LanguageService langServ = locator.getBasicHttpBinding_LanguageService();
		
		String accessToken = TranslateHelper.getAccessToken(CLIENT_ID, CLIENT_SECRET);
		String appId = "Bearer " + accessToken;
		
		String translation = langServ.translate(appId, inputStr, "en", toLanguage, "text/plain", "", "");
		
		return translation;
	}
}
