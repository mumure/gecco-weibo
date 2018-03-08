package weibo.bean;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;

@PipelineName("downloadPipeline")
public class DownLoadPipeline implements Pipeline<MicBlog> {

    private CloseableHttpClient httpClient;

    {
        RequestConfig clientConfig = RequestConfig.custom().setRedirectsEnabled(false).build();
        PoolingHttpClientConnectionManager syncConnectionManager = new PoolingHttpClientConnectionManager();
        syncConnectionManager.setMaxTotal(1000);
        syncConnectionManager.setDefaultMaxPerRoute(50);
        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(clientConfig).setConnectionManager(syncConnectionManager).build();
    }

    @Override
    public void process(MicBlog bean) {
        BufferedWriter out = null;
        List<String> date = bean.getDate();
        List<String> source = bean.getSource();
        List<String> text = bean.getText();
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data.txt", true)));
            for(int i=0; i<date.size(); i++) {
                out.write(date.get(i) + " 来自：" + source.get(i) + "\r\n" + text.get(i) + "\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
