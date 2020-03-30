package pe.com.niubiz.component;

import java.net.URI;
import java.util.List;

import pe.com.niubiz.model.CustomerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;


@Component
public class UsuarioRestClient {

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioRestClient.class);

    @Value("${rest.security.keycloak.url}")
    private String keycloakServerUrl;

    @Value("${rest.security.keycloak.realm}")
    private String keycloakRealm;

    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;

//    public List<CustomerInfo> getUsuariosDirectory(){
//
//        StringBuilder sb = new StringBuilder(keycloakServerUrl);
//        sb.append("/admin/realms/").append(keycloakRealm).append("/users");
//
//        LOG.debug("***** URI: " + sb.toString());
//        LOG.debug("***** GET ACCES TOKE: " + oAuth2RestTemplate.getAccessToken().toString());
//
//        ResponseEntity<CustomerInfo[]> response =oAuth2RestTemplate.getForEntity(sb.toString(), CustomerInfo[].class);
//
//        CustomerInfo[] customerInfos = response.getBody();
//
//        List<CustomerInfo> searchList= Arrays.asList(customerInfos);
//
//        return searchList;
//    }


    public List<CustomerInfo> getUsuariosDirectory(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + oAuth2RestTemplate.getAccessToken());

        StringBuilder sb = new StringBuilder(keycloakServerUrl);
        sb.append("/admin/realms/").append(keycloakRealm).append("/users");

        LOG.debug("***** URI: " + sb.toString());
        LOG.debug("***** GET ACCES TOKEN: " + oAuth2RestTemplate.getAccessToken());
        LOG.debug("***** GET ACCES TOKEN2: " + oAuth2RestTemplate.getAccessToken().getValue());

        HttpEntity<String> entity = new HttpEntity<>(headers);

        List<CustomerInfo> users = oAuth2RestTemplate.exchange(URI.create(sb.toString()), HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<CustomerInfo>>() {
                }).getBody();

        return users;
    }
}
