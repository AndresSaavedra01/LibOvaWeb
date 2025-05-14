package co.uceva.libovaweb;

import co.uceva.libovaweb.javaLib.OvaWeb;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/libOvaWeb")
public class JNIRestController {

    private final OvaWeb ovaWeb = new OvaWeb();

    @PostMapping("/ejecutar-comando")
    public ResponseEntity<Map<String, Object>> ejecutarComandoGit(@RequestBody ComandoRequest request) {
        Map<String, Object> response = new HashMap<>();

        try {
            String resultado = ovaWeb.ejecutarComandosGit("3.138.123.82", "id_rsa.pem", request.getComando());
            response.put("resultado", resultado);
            response.put("estado", "éxito");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("estado", "error");
            response.put("mensaje", e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

}
