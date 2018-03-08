package weibo.bean;

import java.util.List;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.spider.JsonBean;

@Gecco(matchUrl="https://m.weibo.cn/api/container/getIndex?uid=5561201198&luicode=10000011&lfid=100103type%3D3%26q%3D%E6%A2%81%E7%B4%AB%E6%99%A8&featurecode=20000320&type=uid&value=5561201198&containerid=1076035561201198&page={page}", pipelines = { "consolePipeline" , "downloadPipeline"})
public class MicBlog implements JsonBean {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @RequestParameter("page")
    private int page;

    @JSONPath("$.data.cards[0:].mblog.text")
    private List<String> text;
    
    @JSONPath("$.data.cards[0:].mblog.source")
    private List<String> source;
    
    @JSONPath("$.data.cards[0:].mblog.created_at")
    private List<String> date;
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    public List<String> getSource() {
        return source;
    }

    public void setSource(List<String> source) {
        this.source = source;
    }

    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }
    
    public static void main(String[] args) {
        for(int i=1; i<5; i++) {
            HttpGetRequest start = new HttpGetRequest("https://m.weibo.cn/api/container/getIndex?uid=5561201198&luicode=10000011&lfid=100103type%3D3%26q%3D%E6%A2%81%E7%B4%AB%E6%99%A8&featurecode=20000320&type=uid&value=5561201198&containerid=1076035561201198&page="+i);
            start.setCharset("UTF-8");
            GeccoEngine.create().classpath("weibo.bean").start(start).interval(5000).run();
        }
    }
}
