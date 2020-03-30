package pe.com.niubiz.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.niubiz.model.Limites;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="Limites API", description="Limites de Transacciones")
@RestController
@RequestMapping("/api/v1/transacciones")
public class LimitesRestController {

    @ApiOperation(value = "Vista de las listas de los limites")
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_LIMITE')")
    public ResponseEntity<Limites> getLimites(){
        return null;
    }
}
