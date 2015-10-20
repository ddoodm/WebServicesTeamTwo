package uts.wsd.teamtwo.translator;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.tempuri.SoapServiceLocator;

import com.microsofttranslator.api.V2.LanguageService;

/**
 * A static wrapper class which interfaces with the 
 * Microwoft Translator SOAP client to provide a
 * simple translation interface.
 * 
 * The class provides a program entry point for testing purposes.
 * 
 * @author Deinyon L Davies
 */
public class TranslatorClient
{
	/**
	 * The client ID and public key that are used to request an access token
	 * from the Microsoft translation service
	 */
	private static final String
		CLIENT_ID = "HotelService33",
		CLIENT_SECRET = "OoqnSU0wqCGoJh+Dew+S1WiWK/quJ3C/HB69hf3WHKQ=";
	
	/**
	 * Test program entry point
	 */
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
	
	/**
	 * Translate a given English string to a given language
	 * @param inputStr The English language string to be translated
	 * @param toLanguage The Microsoft Language Code of the language to which the input shall be translated
	 * @return The input string translated to the given language
	 * @throws ServiceException If the client could not connect to the SOAP service
	 * @throws RemoteException If an invalid language code is specified
	 */
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
