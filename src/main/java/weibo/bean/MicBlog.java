package weibo.bean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.spider.JsonBean;

@Gecco(matchUrl="https://m.weibo.cn/api/container/getIndex?uid=1648007681&luicode=10000011&lfid=100103type%3D3%26q%3D%E8%B5%B0%E9%A5%AD&featurecode=20000320&type=uid&value=1648007681&containerid=1076031648007681&page={page}", pipelines="consolePipeline")
public class MicBlog implements JsonBean {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
}
