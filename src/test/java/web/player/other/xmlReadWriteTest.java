package web.player.other;

import org.testng.annotations.Test;
import web.player.tests.WebPlayerBaseTest;
import web.player.other.xmlReaderWriter;

public class xmlReadWriteTest extends WebPlayerBaseTest{

  @Test (enabled = false, priority = 1)
    public void savingToXml() throws Exception {
      xmlReaderWriter.saveToXml();
  }

    @Test (enabled = false, priority = 2)
    public void readingFromXml() throws Exception {
      xmlReaderWriter.readFromXml();

    }
}


