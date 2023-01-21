package edu.neu.swc.stock.crawler.fetcher.impl;

import edu.neu.swc.stock.crawler.fetcher.Fetcher;
import edu.neu.swc.stock.crawler.vo.Request;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class HttpFetcher implements Fetcher {

    private final HttpClient httpClient;

    public HttpFetcher(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public String fetch(Request request) {
        HttpGet httpGet = new HttpGet(request.getUrl());
        HttpResponse response;
        InputStream is = null;
        InputStreamReader isr = null;
        try {
            response = httpClient.execute(httpGet);
            is = response.getEntity().getContent();

            //读取结果字符
            StringBuilder stringBuilder = new StringBuilder();
            isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            char[] buffer = new char[1024];
            while(true) {
                int l = isr.read(buffer, 0, buffer.length);
                if(l < 0) {
                    break;
                }
                stringBuilder.append(buffer, 0, l);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            log.error("there is an error happen in fetching phase");
        } finally {
            try {
                if(is != null) {
                    is.close();
                }
                if(isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                log.error("stream close error");
            }
        }
        return null;
    }
}
