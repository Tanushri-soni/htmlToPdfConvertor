package yahp.yahp;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.allcolor.yahp.converter.CYaHPConverter;
import org.allcolor.yahp.converter.IHtmlToPdfTransformer;

public class HtmlToPdf_yahp_2 {
	public  static void main(String ... args ) throws Exception {
        String root = "D://temp//html//";
        String input = "abc.html";  // need to be charset utf-8
        htmlToPdfFile(new File(root, input),
                      new File(root, input+ ".pdf"));
        System.out.println("Done");
      }

      public static void htmlToPdfFile(File htmlIn, File pdfOut) throws Exception {
        Scanner scanner =
           new Scanner(htmlIn).useDelimiter("\\Z");
        String htmlContents = scanner.next();

        CYaHPConverter converter = new CYaHPConverter();
        FileOutputStream out = new FileOutputStream(pdfOut);
        Map properties = new HashMap();
        List headerFooterList = new ArrayList();

        properties.put(IHtmlToPdfTransformer.PDF_RENDERER_CLASS,
                       IHtmlToPdfTransformer.FLYINGSAUCER_PDF_RENDERER);
       // properties.put(IHtmlToPdfTransformer.FOP_TTF_FONT_PATH, fontPath);
        converter.convertToPdf(htmlContents,
                    IHtmlToPdfTransformer.A4P,
                    headerFooterList,
                    "file:///temp/html/",
                    out,
                    properties);
        out.flush();
        out.close();
      }
    }