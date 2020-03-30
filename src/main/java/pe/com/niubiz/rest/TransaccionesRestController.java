package pe.com.niubiz.rest;

import java.util.List;
import java.util.Set;
import pe.com.niubiz.config.SecurityContextUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.niubiz.model.CustomerInfo;
import pe.com.niubiz.model.Transacciones;
import pe.com.niubiz.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="Transacciones API", description="transacciones visadirect")
@RestController
@RequestMapping("/api/v1/employees")
public class TransaccionesRestController {

  @Autowired
  private UsuarioService usuarioService;

  @ApiOperation(value = "Vista de las listas de los limites")
  @GetMapping(path = "/username2")
  @PreAuthorize("hasAnyAuthority('ROLE_USER')")
  public ResponseEntity<String> getAuthorizedUserName2() {
    return ResponseEntity.ok(SecurityContextUtils.getUserName());
  }

  @ApiOperation(value = "Vista de las listas de los limites")
  @GetMapping(path = "/username")
  @PreAuthorize("hasAnyAuthority('ROLE_view-clients')")
  public ResponseEntity<List<CustomerInfo>> getAuthorizedUserName() {
    return ResponseEntity.ok(usuarioService.getUsers());
  }

  @ApiOperation(value = "Vista de las usuarios")
  @GetMapping(path = "/roles")
  @PreAuthorize("hasAnyAuthority('ROLE_USER')")
  public ResponseEntity<Set<String>> getAuthorizedUserRoles() {
    return ResponseEntity.ok(SecurityContextUtils.getUserRoles());
  }

  @ApiOperation(value = "Vista de las transacciones")
  @GetMapping(path = "/transacciones")
  @PreAuthorize("hasAnyAuthority('ROLE_USER')")
  public ResponseEntity<Transacciones> getAuthorizedTransacciones(){
    return null;
  }
}
