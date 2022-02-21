package com.ibm.proyectos.universidad.controladores;

import com.ibm.proyectos.universidad.excepciones.NotFoundException;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Direccion;
import com.ibm.proyectos.universidad.modelo.entidades.Pabellon;
import com.ibm.proyectos.universidad.servicios.PabellonDAO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/restapi")
public class PabellonController
{
    private final static Logger logger = LoggerFactory.getLogger(PabellonController.class);

    @Autowired
    private PabellonDAO pabellonDAO;

    /**
     * Endpoint para consultar todos los pabellones
     * @return Retorna una lista de pabellones.
     * @author EEAA - 19-02-2022
     */
    @ApiOperation(value = "Consultar todos los pabellones")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Endpoint ejecutado satisfactoriamente"),
            @ApiResponse(code = 404, message = "No hay elementos en la base de datos")
    })
    @GetMapping("/pabellones/lista")
    public List<Pabellon> listarTodas()
    {
        List<Pabellon> pabellones = (List<Pabellon>) pabellonDAO.buscarTodos();
        return pabellones;
    }

    /**
     * Endpoint para consultar un pabellon por id
     * @param pabellonId Parámetro de bÃºsqueda del pabellon
     * @return Retorna un objeto de tipo Pabellon
     * @NotFoundException En caso de que falle buscando el pabellon
     * @author -EEAA - 19-02-2022
     */


    @GetMapping("/pabellon/pabellonId/{pabellonId}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long pabellonId)
    {
        Optional<Pabellon> oPabellon = pabellonDAO.buscarPorId(pabellonId);

        if(!oPabellon.isPresent())
            throw new NotFoundException(String.format("El pabellon con id: %d no existe", pabellonId));

        return new ResponseEntity<Pabellon>(oPabellon.get(), HttpStatus.OK);
    }


    /**
     *Endpoint para guardar una nuevo pabellon
     * @param pabellon Parametro para buscar el pabellon
     * @param result Parametro que guarda la lista de errores
     * @return Retorna un objeto de tipo pabellon
     * EEAA - 19-02-2022
     */
    @PostMapping("/pabellon")
    public ResponseEntity<?> guardar(@Valid @RequestBody Pabellon pabellon, BindingResult result)
    {
        Map<String, Object> validaciones = new HashMap<String, Object>();
        if(result.hasErrors())
        {
            List<String> listaErrores = result.getFieldErrors()
                    .stream()
                    .map(errores -> "Campo: '" + errores.getField() + "' " + errores.getDefaultMessage())
                    .collect(Collectors.toList());
            validaciones.put("Lista Errores", listaErrores);
            return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
        }

        Pabellon pabellonGuardado = pabellonDAO.guardar(pabellon);
        return new ResponseEntity<Pabellon>(pabellonGuardado, HttpStatus.CREATED);
    }

    /**
     * Endpoint para eliminar pabellon
     * @param pabellonId Parametro para buscar el pabellon
     * @return Retorna unicamente una lista de errores
     * EEAA - 19-02-2022
     */

    @DeleteMapping("/pabellon/eliminar/pabellonId/{pabellonId}")
    public ResponseEntity<?> eliminar(@PathVariable Long pabellonId)
    {
        Optional<Pabellon> oPabellon = pabellonDAO.buscarPorId(pabellonId);

        if(!oPabellon.isPresent())
            throw new NotFoundException(String.format("El pabellon con id: %d no existe", pabellonId));

        pabellonDAO.eliminarPorId(pabellonId);
        return new ResponseEntity<>("El pabellon con id: " + pabellonId + " fue eliminada", HttpStatus.NO_CONTENT);
    }


    /**
     * Endpoint para consultar una pabellon por Nombre
     * @param pabellonNombre ParÃ¡metro de bÃºsqueda del pabellon
     * @return Retorna un objeto de tipo pabellon
     * @NotFoundException En caso de que falle buscando el pabellon
     * @author -EEAA - 19-02-2022
     */


    @GetMapping("/pabellon/pabellonNombre/{pabellonNombre}")
    public ResponseEntity<?> buscarPabellonPorNombre(@PathVariable String pabellonNombre)
    {
        Iterable<Pabellon> oPabellon = pabellonDAO.findPabellonByNombreContains(pabellonNombre);


        if(oPabellon.toString().isEmpty())
            throw new NotFoundException(String.format("El pabellon con nombre: %d no existe", pabellonNombre));

        return new ResponseEntity<Pabellon>((Pabellon) oPabellon.iterator(),HttpStatus.OK);
    }

    /**
     * Endpoint para consultar una pabellon por Localidad
     * @param pabellonLocalidad ParÃ¡metro de bÃºsqueda del pabellon
     * @return Retorna un objeto de tipo pabellon
     * @NotFoundException En caso de que falle buscando el pabellon
     * @author -EEAA - 17-02-2022
     */


    @GetMapping("/pabellon/pabellonLocalidad/{pabellonLocalidad}")
    public ResponseEntity<?> buscarPabellonPorLocalidad(@PathVariable String pabellonLocalidad)
    {
        Iterable<Pabellon> oPabellon = pabellonDAO.findPabellonByLocalidadContains(pabellonLocalidad);


        if(oPabellon.toString().isEmpty())
            throw new NotFoundException(String.format("La carrera con Pabellon: %d no existe", pabellonLocalidad));

        return new ResponseEntity<Pabellon>((Pabellon) oPabellon.iterator(),HttpStatus.OK);
    }



}
