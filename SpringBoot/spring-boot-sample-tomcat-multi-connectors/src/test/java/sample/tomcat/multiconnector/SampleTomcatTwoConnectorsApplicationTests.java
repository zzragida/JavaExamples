package sample.tomcat.multiconnector;

import javax.net.ssl.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SampleTomcatTwoConnectorsApplication.class)
@WebIntegrationTest(randomPort = true)
@DirtiesContext
public class SampleTomcatTwoConnectorsApplicationTests {

    @Value("${local.server.port}")
    private String port;

    @Autowired
    private ApplicationContext context;

    @BeforeClass
    public static void setUp() {

        try {
            // setup ssl context to ignore certificate errors
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {

                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
                                               String authType) throws java.security.cert.CertificateException {
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain,
                                               String authType) throws java.security.cert.CertificateException {
                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[] { tm }, null);
            SSLContext.setDefault(ctx);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Test
    public void testHello() throws Exception {
        RestTemplate template = new RestTemplate();
        final MySimpleClientHttpRequestFactory factory = new MySimpleClientHttpRequestFactory(
                new HostnameVerifier() {
                    @Override
                    public boolean verify(String s, SSLSession sslSession) {
                        return true;
                    }
                }
        );
        template.setRequestFactory(factory);

        ResponseEntity<String> entity = template.getForEntity(
                "http://localhost:" + this.context.getBean("port") + "/hello",
                String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isEqualTo("hello");

        ResponseEntity<String> httpsEntity = template
                .getForEntity("https://localhost:" + this.port + "/hello", String.class);
        assertThat(httpsEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(httpsEntity.getBody()).isEqualTo("hello");
    }

    class MySimpleClientHttpRequestFactory extends SimpleClientHttpRequestFactory {

        private final HostnameVerifier verifier;

        public MySimpleClientHttpRequestFactory(final HostnameVerifier verifier) {
            this.verifier = verifier;
        }

        @Override
        protected void prepareConnection(final HttpURLConnection connection,
                                         final String httpMethod) throws IOException {
            if (connection instanceof HttpURLConnection) {
                ((HttpsURLConnection) connection).setHostnameVerifier(this.verifier);
            }
            super.prepareConnection(connection, httpMethod);
        }
    }
}
