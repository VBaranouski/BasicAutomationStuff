package web.player.tests.xml;

import org.testng.annotations.Test;
import web.player.tests.WebPlayerBaseTest;
import web.player.xml.xmlReaderWriter;

public class xmlReadWrite extends WebPlayerBaseTest{

  @Test (enabled = true, priority = 1)
    public void savingToXml() throws Exception {
      xmlReaderWriter.saveToXml();
  }

    @Test (enabled = true, priority = 2)
    public void readingFromXml() throws Exception {
      xmlReaderWriter.readFromXml();

    }
}


