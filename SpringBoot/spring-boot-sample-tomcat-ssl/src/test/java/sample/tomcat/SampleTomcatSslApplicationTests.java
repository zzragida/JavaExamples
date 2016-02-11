package sample.tomcat;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.tomcat.ssl.SampleTomcatSslApplication;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SampleTomcatSslApplication.class)
@WebIntegrationTest(randomPort = true)
@DirtiesContext
public class SampleTomcatSslApplicationTests {

    @Value("${local.server.port}")
    private String port;

    @Test
    public void testHome() throws Exception {
        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
                new SSLContextBuilder()
                    .loadTrustMaterial(null, new TrustSelfSignedStrategy()).build());
        HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();

        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ((HttpComponentsClientHttpRequestFactory) testRestTemplate.getRequestFactory())
                .setHttpClient(httpClient);
        ResponseEntity<String> entity = testRestTemplate
                .getForEntity("http://localhost:" + this.port, String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isEqualTo("Hello, world");
    }
}
