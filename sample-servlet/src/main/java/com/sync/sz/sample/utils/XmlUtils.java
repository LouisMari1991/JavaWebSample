package com.sync.sz.sample.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * Created by Administrator on 2017/2/24 0024.
 */
public class XmlUtils {

  public static void main(String[] args) {
    System.out.println(filepath);
  }

  private static String filepath;

  static {
    filepath = XmlUtils.class.getClassLoader().getResource("users.xml").getPath();
  }

  public static Document getDocument() throws DocumentException {
    SAXReader reader = new SAXReader();
    Document document = reader.read(new File(filepath));
    return document;
  }

  public static void write2Xml(Document document) throws IOException {
    XMLWriter writer = null;
    try {
      OutputFormat format = OutputFormat.createPrettyPrint();
      format.setEncoding("UTF-8");
      writer = new XMLWriter(new FileOutputStream(filepath), format);
      writer.write(document);
    } finally {
      if (writer != null) {
        writer.close();
      }
    }
  }
}
