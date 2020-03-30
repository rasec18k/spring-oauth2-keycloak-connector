package pe.com.niubiz.service;

import pe.com.niubiz.component.UsuarioRestClient;
import pe.com.niubiz.model.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRestClient usuarioRestClient;

    public List<CustomerInfo> getUsers() {

        return usuarioRestClient.getUsuariosDirectory();

    }
}
