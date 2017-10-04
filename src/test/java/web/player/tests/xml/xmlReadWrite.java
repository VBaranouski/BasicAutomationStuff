package web.player.tests.xml;

import org.testng.annotations.Test;
import web.player.tests.WebPlayerBaseTest;
import web.player.other.xmlReaderWriter;

public class xmlReadWrite extends WebPlayerBaseTest{

  @Test (enabled = false, priority = 1)
    public void savingToXml() throws Exception {
      xmlReaderWriter.saveToXml();
  }

    @Test (enabled = false, priority = 2)
    public void readingFromXml() throws Exception {
      xmlReaderWriter.readFromXml();

    }
}


