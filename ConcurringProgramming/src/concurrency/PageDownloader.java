package concurrency;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class PageDownloader implements Runnable{

    String[] urlList;
    public PageDownloader(String[] urlList){
        this.urlList = urlList;
    }
    @Override
    public void run() {
        try{
            for(String urlString : urlList){
                URL url = new URL(urlString);
                String fileName = urlString.substring(urlString.lastIndexOf("/") + 1).trim()+".html";
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

                String line;
                while ((line = reader.readLine()) != null){
                    writer.write(line);
                }
        System.out.println("Page downloaded to "+fileName);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

  public static void main(String[] args) {
    String[] urls = new String[]{"http://www.youtube.com",
      "http://www.facebook.com",
     "http://www.baidu.com",
     "http://www.yahoo.com",
     "http://www.amazon.com",
     "http://www.wikipedia.org",
      "http://www.qq.com",
      "http://www.google.co.in",
      "http://www.twitter.com"};

      Thread downloaderOne = new Thread(new PageDownloader(Arrays.copyOfRange(urls, 0, 4)));
      Thread downloaderTwo = new Thread(new PageDownloader(Arrays.copyOfRange(urls, 4, urls.length)));

      try{
          long start = System.currentTimeMillis();
          downloaderOne.start();
          downloaderTwo.start();

          downloaderOne.join();
          downloaderTwo.join();
          long end = System.currentTimeMillis();

          System.out.println("Total time: "+ (end-start)/1000+"s");
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }
  }


}
