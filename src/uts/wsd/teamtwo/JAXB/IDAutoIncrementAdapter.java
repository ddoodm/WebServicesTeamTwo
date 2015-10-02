package uts.wsd.teamtwo.JAXB;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * XML adapter to auto-increment an integer field.
 * 
 * Reference from StackOverflow answer by Blaise Doughan:
 * http://stackoverflow.com/questions/24180499/how-to-auto-increment-id-in-xml-using-jaxb
 * 
 * @author Deinyon L Davies
 */
public class IDAutoIncrementAdapter extends XmlAdapter<Integer, Integer>
{
    private int id = 0;

    @Override
    public Integer unmarshal(Integer v) throws Exception
    {
        return id++;
    }

    @Override
    public Integer marshal(Integer v) throws Exception
    {
        return v;
    }
}
